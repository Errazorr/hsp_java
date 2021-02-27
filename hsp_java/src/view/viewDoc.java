package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import javax.swing.JLabel;

import db_connexion.DbConnection;

import javax.swing.JComboBox;
import javax.swing.JButton;

public class viewDoc {

	 JFrame frame;

	/**
	 * Launch the application.
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
	 */
	public viewDoc() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 573, 370);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("M\u00E9decin :");
		lblNewLabel.setBounds(135, 55, 98, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(243, 51, 104, 22);
		frame.getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("Retour");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				rdv window = new rdv();
				window.Rdv.setVisible(true);
			}
		});
		btnNewButton.setBounds(458, 11, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblName = new JLabel("Nom");
		lblName.setBounds(153, 120, 49, 14);
		frame.getContentPane().add(lblName);
		
		JLabel lblDocName = new JLabel("");
		lblDocName.setBounds(216, 120, 151, 14);
		frame.getContentPane().add(lblDocName);
		
		JLabel lblLastName = new JLabel("Prenom");
		lblLastName.setBounds(153, 165, 49, 14);
		frame.getContentPane().add(lblLastName);
		
		JLabel lblDocLastName = new JLabel("");
		lblDocLastName.setBounds(216, 165, 151, 14);
		frame.getContentPane().add(lblDocLastName);
		
		JLabel lblSpeciality = new JLabel("Prenom");
		lblSpeciality.setBounds(153, 210, 49, 14);
		frame.getContentPane().add(lblSpeciality);
		
		JLabel lblDocSpeciality = new JLabel("");
		lblDocSpeciality.setBounds(216, 210, 151, 14);
		frame.getContentPane().add(lblDocSpeciality);
		
		DbConnection Connect = new DbConnection();
		Connection cnx = Connect.dbConnection();
		String requete = "Select nom from medecin";
		ResultSet result = Connect.Requete(cnx, requete);
		
		try {
			while(result.next()) {
				comboBox.addItem(result.getString(1).trim());
			}
			result.close();
		}
		catch (Exception ex) {System.out.println(ex);}
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String medic = comboBox.getSelectedItem().toString();
				String requete = "Select * from medecin where nom = '" + medic + "'";
				ResultSet result = Connect.Requete(cnx, requete);
				try {
					while(result.next()) {
						lblDocName.setText(result.getString("nom"));
						lblDocLastName.setText(result.getString("prenom"));
						lblDocSpeciality.setText(result.getString("specialite"));						
					}
					result.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
	}
}
