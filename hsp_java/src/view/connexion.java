package view;
import global_variable.*;
import manager.methods;

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
import javax.swing.JPanel;
import java.awt.Font;

public class connexion extends global {

	JFrame connexion;
	JTextField txt_id;
	JPasswordField PasswordField;

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
		connexion.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\GONCALVES_Na\\Pictures\\zIb0C.jpg"));
		connexion.getContentPane().setBackground(Color.WHITE);
		connexion.setTitle("Connexion");
		connexion.setBounds(100, 100, 766, 543);
		connexion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		connexion.getContentPane().setLayout(null);
		java.awt.Image img = new ImageIcon(this.getClass().getResource("/face.png")).getImage();
		java.awt.Image img1 = new ImageIcon(this.getClass().getResource("/padlock.png")).getImage();
		
		JLabel lblNewLabel_2 = new JLabel("Corazon App. \u00A9");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Sitka Banner", Font.PLAIN, 23));
		lblNewLabel_2.setBounds(130, 231, 154, 54);
		connexion.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("");
		String chemin = "zIb0C.jpg";
		String resource = getClass().getClassLoader().getResource(chemin).getPath();
		lblNewLabel.setIcon(new ImageIcon(resource));
		lblNewLabel.setBounds(0, 0, 379, 504);
		connexion.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(378, 0, 372, 504);
		connexion.getContentPane().add(panel);
		panel.setLayout(null);
		
		PasswordField = new JPasswordField();
		PasswordField.setBounds(125, 295, 140, 23);
		panel.add(PasswordField);
		
		JLabel label2 = new JLabel("Mot de passe");
		label2.setBounds(125, 228, 140, 56);
		panel.add(label2);
		label2.setForeground(Color.WHITE);
		label2.setIcon(new ImageIcon(img1));
		
		JButton btnConnexion = new JButton("Se connecter");
		btnConnexion.setBounds(125, 375, 140, 31);
		panel.add(btnConnexion);
		btnConnexion.setBackground(Color.DARK_GRAY);
		btnConnexion.setForeground(Color.WHITE);
		
		txt_id = new JTextField();
		txt_id.setBounds(125, 182, 140, 23);
		panel.add(txt_id);
		txt_id.setColumns(10);
		
		JLabel label = new JLabel("Identifiant");
		label.setBounds(125, 115, 166, 56);
		panel.add(label);
		label.setForeground(Color.WHITE);
		label.setIcon(new ImageIcon(img));
		
				JLabel lblError = new JLabel("");
				lblError.setFont(new Font("Yu Gothic", Font.PLAIN, 13));
				lblError.setBounds(99, 56, 232, 14);
				panel.add(lblError);
				lblError.setForeground(Color.RED);
				
		btnConnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				methods Methode = new methods();
				Methode.se_connecter(txt_id.getText(), PasswordField.getText(), lblError, connexion);
			}
		});
		

	}
}
