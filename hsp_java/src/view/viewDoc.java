package view;

import java.awt.EventQueue; 
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import db_connexion.DbConnection;
import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class viewDoc {

	 JFrame frame;
	private JTextField txtname;
	private JTextField txtlastname;
	private JTextField txtspeciality;
	private JTable table;
	private JTextField txtid;

	/**
	 * Launch the application.
	 * @wbp.parser.entryPoint
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewDoc window = new viewDoc();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public viewDoc() {
		initialize();
		table_load();
	}
	

	  /**
	   * @wbp.parser.entryPoint
	   */
	  public void table_load()
		    {
			DbConnection Connect = new DbConnection();
			Connection cnx = Connect.dbConnection();
			String requete = "Select * from medecin";
			ResultSet result = Connect.Requete(cnx, requete);
			
			table.setModel(DbUtils.resultSetToTableModel(result));
			
			
		    }

	
	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 766, 543);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("M\u00E9decin");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(327, 38, 130, 37);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Enregistrement", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(31, 192, 352, 238);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Nom");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(32, 52, 104, 28);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Pr\u00E9nom");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(32, 113, 104, 28);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Sp\u00E9cialit\u00E9");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(32, 175, 104, 28);
		panel.add(lblNewLabel_1_2);
		
		txtname = new JTextField();
		txtname.setBounds(146, 58, 177, 20);
		panel.add(txtname);
		txtname.setColumns(10);
		
		txtlastname = new JTextField();
		txtlastname.setColumns(10);
		txtlastname.setBounds(146, 119, 177, 20);
		panel.add(txtlastname);
		
		txtspeciality = new JTextField();
		txtspeciality.setColumns(10);
		txtspeciality.setBounds(146, 181, 177, 20);
		panel.add(txtspeciality);
		
		DbConnection Connect = new DbConnection();
		Connection cnx = Connect.dbConnection();
		String requete = "Select nom from medecin";
		ResultSet result = Connect.Requete(cnx, requete);
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String name, lastname, speciality;
				
				name = txtname.getText();
				lastname = txtlastname.getText();
				speciality = txtspeciality.getText();
				
				try {
					
					String requete = "INSERT INTO medecin(nom, prenom, specialite) VALUES('" + txtname.getText() + "', '" 
							+ txtlastname.getText()  + "' , '" + txtspeciality.getText() + "')";
					Connect.Requete_prepare(cnx, requete);

					 JOptionPane.showMessageDialog(null, "Médecin ajouté !");
					 table_load();
					            
					 txtname.setText("");
					 txtlastname.setText("");
					 txtspeciality.setText("");
					 txtname.requestFocus();
					    }
					 
				catch (Exception ex) 
					        {
					 
										
					        } } }
		);
		btnNewButton.setBounds(157, 441, 100, 37);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnEdit = new JButton("Retour");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				rdv window = new rdv();
				window.Rdv.setVisible(true);
			}
		});
		btnEdit.setBackground(Color.RED);
		btnEdit.setForeground(Color.WHITE);
		btnEdit.setBounds(483, 441, 100, 37);
		frame.getContentPane().add(btnEdit);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(396, 114, 343, 292);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Rechercher", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(31, 115, 352, 66);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("id");
		lblNewLabel_1_1_1.setBounds(10, 25, 122, 20);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lblNewLabel_1_1_1);
		
		txtid = new JTextField();
		txtid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				 
				 try {
					 
						DbConnection Connect = new DbConnection();
						Connection cnx = Connect.dbConnection();
				           
				             String id = txtid.getText();
				 
				             String requetes = "select nom, prenom, specialite from medecin where id = '" + id + "'";
				                 
				                 ResultSet resultat = Connect.Requete(cnx, requetes);
				                 
				                 //resultat.updateString(1, id);
				 
				             if(resultat.next()==true)
				             {
				               
				                 String name = resultat.getString(1);
				                 String lastname = resultat.getString(2);
				                 String speciality = resultat.getString(3);
				                 
				                 txtname.setText(name);
				                 txtlastname.setText(lastname);
				                 txtspeciality.setText(speciality);
				                 
				                 
				             }   
				             else
				             {
				              txtname.setText("");
				              txtlastname.setText("");
				                 txtspeciality.setText("");
				                  
				             }
				             
				 
				 
				         } 
				 
				 catch (SQLException ex) {
				            
				         }
			}
		});
		txtid.setBounds(142, 27, 173, 20);
		txtid.setColumns(10);
		panel_1.add(txtid);
		
		JButton btnUpdate = new JButton("Mettre à jour");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				String name,lastname,speciality,id;
				
				
				name = txtname.getText();
				lastname = txtlastname.getText();
				speciality = txtspeciality.getText();
				id  = txtid.getText();
				
				 try {
					 
					 
					 String requetes2 = "update medecin set nom = '" + name + "', prenom = '" + lastname + "', specialite = '" + speciality + 
							 "' where id = '" + id + "'";
	                 
					Connect.Requete_prepare(cnx, requetes2);
	                
	
			            JOptionPane.showMessageDialog(null, "Compte mis à jour!");
			            table_load();
			           
			            txtname.setText("");
			            txtlastname.setText("");
			            txtspeciality.setText("");
			            txtname.requestFocus();
					}

		            catch (Exception ex) {
						
						
					}
	
				
				
			}
		});
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setBackground(Color.BLUE);
		btnUpdate.setBounds(47, 441, 100, 37);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("Supprimer");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

                String bid;
bid  = txtid.getText();

try {

	String requetes3 = "delete from medecin where id = '" + bid + "'";
Connect.Requete_prepare(cnx, requetes3);
     JOptionPane.showMessageDialog(null, "Compte supprimé !");
     table_load();
    
     txtname.setText("");
     txtlastname.setText("");
     txtspeciality.setText("");
     txtname.requestFocus();
}

     catch (Exception e1) {

e1.printStackTrace();
}
				
			}
		});
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setBackground(Color.RED);
		btnDelete.setBounds(267, 441, 100, 37);
		frame.getContentPane().add(btnDelete);
		
		JButton btnExit = new JButton("Actualiser");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table_load();
			}
		});
		btnExit.setForeground(Color.WHITE);
		btnExit.setBackground(Color.ORANGE);
		btnExit.setBounds(593, 441, 100, 37);
		frame.getContentPane().add(btnExit);
	}
}
