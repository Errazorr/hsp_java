package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JTextField;

import db_connexion.DbConnection;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class addProfil {

	JFrame frame;
	private JTextField textName;
	private JTextField textLastName;
	private JTextField textMail;
	private JTextField textPhone;
	private JTextField textMutuelle;
	private JTextField textSecu;
	private JLabel lblError;
	boolean success;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addProfil window = new addProfil();
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
	public addProfil() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 730, 424);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel Name = new JLabel("Nom patient");
		Name.setBounds(207, 70, 113, 14);
		frame.getContentPane().add(Name);
		
		DbConnection Connect = new DbConnection();
		Connection cnx = Connect.dbConnection();
		String requete = "Select nom from medecin";
		ResultSet result = Connect.Requete(cnx, requete);
		
		textName = new JTextField();
		textName.setBounds(367, 67, 113, 20);
		frame.getContentPane().add(textName);
		textName.setColumns(10);
		
		JLabel LastName = new JLabel("Pr\u00E9nom patient");
		LastName.setBounds(207, 110, 113, 14);
		frame.getContentPane().add(LastName);
		
		JLabel Mail = new JLabel("Mail patient");
		Mail.setBounds(207, 155, 113, 14);
		frame.getContentPane().add(Mail);
		
		JLabel Phone = new JLabel("T\u00E9l\u00E9phone");
		Phone.setBounds(207, 200, 113, 14);
		frame.getContentPane().add(Phone);
		
		JLabel Mutuelle = new JLabel("Mutuelle");
		Mutuelle.setBounds(207, 244, 113, 14);
		frame.getContentPane().add(Mutuelle);
		
		JLabel Secu = new JLabel("Num\u00E9ro de s\u00E9cu");
		Secu.setBounds(207, 295, 150, 14);
		frame.getContentPane().add(Secu);
		
		textLastName = new JTextField();
		textLastName.setColumns(10);
		textLastName.setBounds(367, 107, 113, 20);
		frame.getContentPane().add(textLastName);
		
		textMail = new JTextField();
		textMail.setColumns(10);
		textMail.setBounds(367, 152, 113, 20);
		frame.getContentPane().add(textMail);
		
		textPhone = new JTextField();
		textPhone.setColumns(10);
		textPhone.setBounds(367, 197, 113, 20);
		frame.getContentPane().add(textPhone);
		
		textMutuelle = new JTextField();
		textMutuelle.setColumns(10);
		textMutuelle.setBounds(367, 241, 113, 20);
		frame.getContentPane().add(textMutuelle);
		
		textSecu = new JTextField();
		textSecu.setColumns(10);
		textSecu.setBounds(367, 292, 113, 20);
		frame.getContentPane().add(textSecu);
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String requete = "Select * from patient where nom='" + Name.getText() + "'";
				ResultSet result = Connect.Requete(cnx, requete);
				try {
					while(result.next()) {
						lblError.setText("Ce compte existe déjà.");
					}
					requete = "INSERT INTO patient(nom, prenom, mail, tel, mutuelle, secu) VALUES('" + textName.getText() + "', '" 
							+ textLastName.getText()  + "', '" + textMail.getText()  + "', '" + textPhone.getText()  + "', '" + textMutuelle.getText() + "', '" + textSecu.getText()
							.toString() + "')";
					success = Connect.Requete_prepare(cnx, requete);
					
					frame.dispose();
					addRDV window = new addRDV();
					window.frame.setVisible(true);

				}
				catch (Exception ex) {

				}
			}
		});
		btnNewButton.setBounds(298, 341, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		lblError = new JLabel("");
		lblError.setBounds(322, 11, 49, 14);
		frame.getContentPane().add(lblError);
		
		btnNewButton_1 = new JButton("Retour ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				rdv window = new rdv();
				window.Rdv.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(24, 341, 104, 23);
		frame.getContentPane().add(btnNewButton_1);
	}

}
