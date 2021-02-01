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

public class connexion extends global {

	JFrame connexion;
	private JTextField txt_id;
	private JPasswordField lblPassword;

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
		connexion.setTitle("Connexion");
		connexion.setBounds(100, 100, 422, 402);
		connexion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		connexion.getContentPane().setLayout(null);
		
		txt_id = new JTextField();
		txt_id.setBounds(207, 123, 114, 20);
		connexion.getContentPane().add(txt_id);
		txt_id.setColumns(10);
		
		lblPassword = new JPasswordField();
		lblPassword.setBounds(207, 191, 114, 20);
		connexion.getContentPane().add(lblPassword);
		
		JLabel label = new JLabel("Identifiant");
		java.awt.Image img = new ImageIcon(this.getClass().getResource("/face.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(89, 105, 166, 56);
		connexion.getContentPane().add(label);
		
		JLabel label2 = new JLabel("Mot de passe");
		java.awt.Image img1 = new ImageIcon(this.getClass().getResource("/padlock.png")).getImage();
		label2.setIcon(new ImageIcon(img1));
		label2.setBounds(89, 173, 166, 56);
		connexion.getContentPane().add(label2);
		
		JButton btnConnexion = new JButton("Se connecter");
		btnConnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DbConnection Connect = new DbConnection();
			    Connection cnx = Connect.dbConnection();
				System.out.println(Connect.dbConnection());
				String requete = "Select * from compte where mail='" + txt_id.getText() + "'";
				ResultSet result = Connect.Requete(cnx, requete);
				
				try {
					while(result.next()) {
						System.out.println("Ca marche!");
						
						requete = "Select id from compte where mail='" + txt_id.getText() + "'";
						ResultSet result_id = Connect.Requete(cnx, requete);
						while(result_id.next()) {
							id = result_id.getInt(1);
							result_id.close();
						}
						connexion.dispose();
						index window = new index();
						window.index.setVisible(true);
						result.close();
					}
					System.out.println("Ca marche pas...");
				} 
				catch (Exception ex) {
					System.out.println(ex);
				}
				
			}
		});
		btnConnexion.setBounds(111, 274, 127, 23);
		connexion.getContentPane().add(btnConnexion);
	}
}
