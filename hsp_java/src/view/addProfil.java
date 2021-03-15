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
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;

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
	private JPanel panel_1;


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
		frame.setBounds(100, 100, 766, 543);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		DbConnection Connect = new DbConnection();
		Connection cnx = Connect.dbConnection();
		String requete = "Select nom from medecin";
		ResultSet result = Connect.Requete(cnx, requete);
		
		lblError = new JLabel("");
		lblError.setBounds(35, 11, 336, 14);
		frame.getContentPane().add(lblError);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBorder(new CompoundBorder());
		panel.setBounds(0, -27, 424, 598);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel Name = new JLabel("Nom patient");
		Name.setFont(new Font("Yu Gothic", Font.PLAIN, 12));
		Name.setForeground(Color.WHITE);
		Name.setBounds(81, 164, 113, 14);
		panel.add(Name);
		
		textName = new JTextField();
		textName.setBounds(190, 161, 113, 20);
		panel.add(textName);
		textName.setColumns(10);
		
		JLabel LastName = new JLabel("Pr\u00E9nom patient");
		LastName.setForeground(Color.WHITE);
		LastName.setFont(new Font("Yu Gothic", Font.PLAIN, 12));
		LastName.setBounds(81, 205, 113, 20);
		panel.add(LastName);
		
		textLastName = new JTextField();
		textLastName.setBounds(190, 208, 113, 20);
		panel.add(textLastName);
		textLastName.setColumns(10);
		
		JLabel Mail = new JLabel("Mail patient");
		Mail.setFont(new Font("Yu Gothic", Font.PLAIN, 12));
		Mail.setForeground(Color.WHITE);
		Mail.setBounds(81, 257, 113, 14);
		panel.add(Mail);
		
		textMail = new JTextField();
		textMail.setBounds(190, 254, 113, 20);
		panel.add(textMail);
		textMail.setColumns(10);
		
		JLabel Phone = new JLabel("t\u00E9l\u00E9phone");
		Phone.setForeground(Color.WHITE);
		Phone.setFont(new Font("Yu Gothic", Font.PLAIN, 12));
		Phone.setBounds(81, 299, 113, 14);
		panel.add(Phone);
		
		textPhone = new JTextField();
		textPhone.setBounds(190, 296, 113, 20);
		panel.add(textPhone);
		textPhone.setColumns(10);
		
		JLabel Mutuelle = new JLabel("Mutuelle");
		Mutuelle.setFont(new Font("Yu Gothic", Font.PLAIN, 12));
		Mutuelle.setForeground(Color.WHITE);
		Mutuelle.setBounds(81, 351, 113, 14);
		panel.add(Mutuelle);
		
		textMutuelle = new JTextField();
		textMutuelle.setBounds(190, 348, 113, 20);
		panel.add(textMutuelle);
		textMutuelle.setColumns(10);
		
		JLabel Secu = new JLabel("Num\u00E9ro de s\u00E9cu");
		Secu.setForeground(Color.WHITE);
		Secu.setFont(new Font("Yu Gothic", Font.PLAIN, 12));
		Secu.setBounds(81, 395, 150, 14);
		panel.add(Secu);
		
		textSecu = new JTextField();
		textSecu.setBounds(190, 392, 113, 20);
		panel.add(textSecu);
		textSecu.setColumns(10);
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(0, 255, 127));
		btnNewButton.setBounds(202, 448, 89, 23);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Ajouter un patient :");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Yu Gothic", Font.BOLD, 17));
		lblNewLabel.setBounds(110, 72, 201, 38);
		panel.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(81, 121, 222, 2);
		panel.add(separator);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(423, 0, 347, 506);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Corazon App. \u00A9");
		lblNewLabel_2.setFont(new Font("Sitka Banner", Font.PLAIN, 23));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(107, 274, 154, 54);
		panel_1.add(lblNewLabel_2);
		
		btnNewButton_1 = new JButton("Retour ");
		btnNewButton_1.setBounds(140, 449, 104, 23);
		panel_1.add(btnNewButton_1);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.RED);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				rdv window = new rdv();
				window.Rdv.setVisible(true);
			}
		});
		
		
		JLabel lblNewLabel_1 = new JLabel("");
		String chemin = "patient2.jpg";
		String resource = getClass().getClassLoader().getResource(chemin).getPath();
		lblNewLabel_1.setIcon(new ImageIcon(resource));
		lblNewLabel_1.setBounds(-22, 0, 359, 506);
		panel_1.add(lblNewLabel_1);


		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String requete = "Select * from patient where nom='" + Name.getText() + "'";
				ResultSet result = Connect.Requete(cnx, requete);
				try {
					while(result.next()) {
						lblError.setText("Ce compte existe déjà.");
						return;
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
	}
}
