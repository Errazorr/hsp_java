package view;
import global_variable.*;

import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.eclipse.swt.graphics.Image;

import db_connexion.DbConnection;

import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;

public class connexion extends global {

	JFrame connexion;
	private JTextField txt_id;
	private JPasswordField PasswordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					connexion window = new connexion();
					window.connexion.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public connexion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		connexion = new JFrame();
		connexion.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\FONTAINE_Ry\\Pictures\\zIb0C.jpg"));
		connexion.getContentPane().setBackground(Color.WHITE);
		connexion.setTitle("Connexion");
		connexion.setBounds(100, 100, 757, 505);
		connexion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		connexion.getContentPane().setLayout(null);
		
		txt_id = new JTextField();
		txt_id.setBounds(378, 178, 140, 23);
		connexion.getContentPane().add(txt_id);
		txt_id.setColumns(10);
		
		PasswordField = new JPasswordField();
		PasswordField.setBounds(378, 258, 140, 23);
		connexion.getContentPane().add(PasswordField);
		
		JLabel label = new JLabel("Identifiant");
		label.setForeground(Color.WHITE);
		java.awt.Image img = new ImageIcon(this.getClass().getResource("/face.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(206, 161, 166, 56);
		connexion.getContentPane().add(label);
		
		JLabel label2 = new JLabel("Mot de passe");
		label2.setForeground(Color.WHITE);
		java.awt.Image img1 = new ImageIcon(this.getClass().getResource("/padlock.png")).getImage();
		label2.setIcon(new ImageIcon(img1));
		label2.setBounds(206, 241, 166, 56);
		connexion.getContentPane().add(label2);

		JLabel lblError = new JLabel("");
		lblError.setForeground(Color.RED);
		lblError.setBounds(261, 122, 232, 14);
		connexion.getContentPane().add(lblError);
		
		JButton btnConnexion = new JButton("Se connecter");
		btnConnexion.setBackground(Color.DARK_GRAY);
		btnConnexion.setForeground(Color.WHITE);
		btnConnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DbConnection Connect = new DbConnection();
			    Connection cnx = Connect.dbConnection();
				System.out.println(Connect.dbConnection());
				String requete = "Select * from compte where mail='" + txt_id.getText() + "' and mdp='" + PasswordField.getText() + "'";
				ResultSet result = Connect.Requete(cnx, requete);
				
				try {
					while(result.next()) {
						System.out.println("Connecté !");
						
						requete = "Select id from compte where mail='" + txt_id.getText() + "'";
						ResultSet result_id = Connect.Requete(cnx, requete);
						while(result_id.next()) {
							id = result_id.getInt(1);
							result_id.close();
							connexion.dispose();
							index window = new index();
							window.index.setVisible(true);
							result.close();
						}
					}
					
					lblError.setText("Mail ou mot de passe incorrect");
				} 
				catch (Exception ex) {
					//System.out.println(ex);
				}
				
			}
		});
		btnConnexion.setBounds(378, 332, 140, 31);
		connexion.getContentPane().add(btnConnexion);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\FONTAINE_Ry\\Pictures\\zIb0C.jpg"));
		lblNewLabel.setBounds(0, 0, 933, 615);
		connexion.getContentPane().add(lblNewLabel);
		

	}
}
