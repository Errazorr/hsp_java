package view;

import java.awt.EventQueue; 
import java.sql.*;
import java.util.TreeMap;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import db_connexion.DbConnection;
import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class viewRDV {
	
	JFrame frame;
	private JTextField txtname;
	private JTextField txtlastname;
	private JTextField txtspeciality;
	private JTable jTable1;
	private JTextField txtid;
	


	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public viewRDV() {
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
		String requete = "Select * from rdv";
		ResultSet result = Connect.Requete(cnx, requete);

		jTable1.setModel(DbUtils.resultSetToTableModel(result));


	}


	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBounds(100, 100, 766, 543);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Rendez-vous");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(259, 38, 234, 37);
		frame.getContentPane().add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Enregistrement", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(31, 192, 176, 238);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Nom");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 52, 104, 28);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Pr\u00E9nom");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(10, 113, 104, 28);
		panel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Sp\u00E9cialit\u00E9");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(10, 175, 104, 28);
		panel.add(lblNewLabel_1_2);

		txtname = new JTextField();
		txtname.setBounds(83, 58, 67, 20);
		panel.add(txtname);
		txtname.setColumns(10);

		txtlastname = new JTextField();
		txtlastname.setColumns(10);
		txtlastname.setBounds(83, 119, 67, 20);
		panel.add(txtlastname);

		txtspeciality = new JTextField();
		txtspeciality.setColumns(10);
		txtspeciality.setBounds(83, 181, 67, 20);
		panel.add(txtspeciality);

		DbConnection Connect = new DbConnection();
		Connection cnx = Connect.dbConnection();
		String requete = "Select nom from medecin";
		ResultSet result = Connect.Requete(cnx, requete);

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
		scrollPane.setBounds(217, 114, 522, 316);
		frame.getContentPane().add(scrollPane);

		jTable1 = new JTable();
		jTable1.setBackground(Color.WHITE);
		scrollPane.setViewportView(jTable1);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Rechercher", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(31, 115, 176, 66);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1_1_1 = new JLabel("id");
		lblNewLabel_1_1_1.setBackground(Color.LIGHT_GRAY);
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

					String requetes = "select nom_patient, prenom_patient, nom_medecin from rdv where id = '" + id + "'";

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
		txtid.setBounds(50, 27, 41, 20);
		txtid.setColumns(10);
		panel_1.add(txtid);

		JButton btnDelete = new JButton("Supprimer");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				String bid;
				bid  = txtid.getText();

				try {

					String requetes3 = "delete from rdv where id = '" + bid + "'";
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
		btnDelete.setBounds(68, 441, 100, 37);
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

		JButton btnExporter = new JButton("Exporter");
		btnExporter.addActionListener(new ActionListener() {
			JTable model;

			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnExporter.setForeground(Color.WHITE);
		btnExporter.setBackground(Color.ORANGE);
		btnExporter.setBounds(259, 441, 100, 37);
		frame.getContentPane().add(btnExporter);
	}
}
