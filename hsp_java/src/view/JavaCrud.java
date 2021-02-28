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

public class JavaCrud {

	private JFrame frame;
	private JTextField txtname;
	private JTextField txtlastname;
	private JTextField txtspeciality;
	private JTable table;
	private JTextField txtid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JavaCrud window = new JavaCrud();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JavaCrud() {
		initialize();
		table_load();
	}
	

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
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 765, 543);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("M\u00E9decin");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(327, 38, 130, 37);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Enregistrement", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(34, 108, 352, 238);
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
					// table_load();
					            
					 txtname.setText("");
					 txtlastname.setText("");
					 txtspeciality.setText("");
					 txtname.requestFocus();
					    }
					 
				catch (Exception ex) 
					        {
					 
										
					        } } }
		);
		btnNewButton.setBounds(57, 369, 100, 37);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnEdit = new JButton("Exit");
		btnEdit.setBounds(167, 369, 100, 37);
		frame.getContentPane().add(btnEdit);
		
		JButton btnExit = new JButton("Actualiser");
		btnExit.setBounds(277, 369, 100, 37);
		frame.getContentPane().add(btnExit);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(396, 114, 343, 292);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Rechercher", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(34, 427, 343, 66);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("id");
		lblNewLabel_1_1_1.setBounds(10, 25, 122, 20);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lblNewLabel_1_1_1);
		
		txtid = new JTextField();
		txtid.setBounds(142, 27, 173, 20);
		txtid.setColumns(10);
		panel_1.add(txtid);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(469, 441, 100, 37);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(589, 441, 100, 37);
		frame.getContentPane().add(btnDelete);
	}
}
