package view;


import db_connexion.DbConnection;
import global_variable.*;
import manager.methods;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;

public class addMedic {

	JFrame Add;
	JTextField textName;
	JTextField textSupplier;
	JTextField textQuantity;

	/**
	 * Create the application.
	 */
	public addMedic() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Add = new JFrame();
		Add.getContentPane().setBackground(Color.DARK_GRAY);
		Add.setTitle("Ajouter un m\u00E9dicament");
		Add.setBounds(100, 100, 766, 543);
		Add.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Add.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Ajout");
		lblNewLabel_1.setForeground(new Color(50, 205, 50));
		lblNewLabel_1.setFont(new Font("Monotype Corsiva", Font.PLAIN, 63));
		lblNewLabel_1.setBounds(117, 146, 181, 189);
		Add.getContentPane().add(lblNewLabel_1);

		JLabel lblMedicName = new JLabel("Nom :");
		lblMedicName.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		lblMedicName.setForeground(Color.WHITE);
		lblMedicName.setBounds(557, 123, 54, 20);
		Add.getContentPane().add(lblMedicName);

		JLabel lblSupplier = new JLabel("Fabriquant :");
		lblSupplier.setForeground(Color.WHITE);
		lblSupplier.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		lblSupplier.setBounds(537, 185, 85, 27);
		Add.getContentPane().add(lblSupplier);

		JLabel lblQuantity = new JLabel("Quantit\u00E9 :");
		lblQuantity.setForeground(Color.WHITE);
		lblQuantity.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		lblQuantity.setBounds(548, 237, 74, 34);
		Add.getContentPane().add(lblQuantity);

		JLabel lblPack = new JLabel("Lots de 50");
		lblPack.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
		lblPack.setForeground(Color.WHITE);
		lblPack.setBounds(642, 271, 70, 14);
		Add.getContentPane().add(lblPack);

		JLabel lblPotentialDangers = new JLabel("Dangers potentiels :");
		lblPotentialDangers.setForeground(Color.WHITE);
		lblPotentialDangers.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		lblPotentialDangers.setBounds(513, 309, 154, 33);
		Add.getContentPane().add(lblPotentialDangers);

		textName = new JTextField();
		textName.setBounds(526, 154, 107, 20);
		Add.getContentPane().add(textName);
		textName.setColumns(10);

		textSupplier = new JTextField();
		textSupplier.setColumns(10);
		textSupplier.setBounds(526, 212, 107, 20);
		Add.getContentPane().add(textSupplier);

		textQuantity = new JTextField();
		textQuantity.setColumns(10);
		textQuantity.setBounds(526, 268, 107, 20);
		Add.getContentPane().add(textQuantity);

		JLabel lblError = new JLabel("");
		lblError.setForeground(Color.GREEN);
		lblError.setBounds(459, 85, 239, 27);
		Add.getContentPane().add(lblError);

		JTextArea textPotentialDangers = new JTextArea();
		textPotentialDangers.setBounds(459, 343, 239, 53);
		Add.getContentPane().add(textPotentialDangers);

		DbConnection Connect = new DbConnection();
		Connection cnx = Connect.dbConnection();

		JButton btnAddMedic = new JButton("Ajouter");
		btnAddMedic.setBackground(new Color(0, 250, 154));
		btnAddMedic.setForeground(Color.WHITE);
		btnAddMedic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				methods Methode = new methods();
				Methode.ajouter_medic(textName.getText(), lblError, textSupplier.getText(), textQuantity.getText(), textPotentialDangers.getText());
			}
		});
		btnAddMedic.setBounds(526, 429, 96, 27);
		Add.getContentPane().add(btnAddMedic);
		
		JButton btnBack = new JButton("Retour");
		btnBack.setForeground(Color.WHITE);
		btnBack.setBackground(Color.RED);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
						Add.dispose();
						stock window = new stock();
						window.Stock.setVisible(true);
					}

				catch (Exception ex) {

				}
			}
		});
		btnBack.setBounds(147, 451, 85, 20);
		Add.getContentPane().add(btnBack);
		
		JLabel lblNewLabel = new JLabel("");
		String chemin = "medoc.jpg";
		String resource = getClass().getClassLoader().getResource(chemin).getPath();
		lblNewLabel.setIcon(new ImageIcon(resource));
		lblNewLabel.setBounds(0, 0, 380, 515);
		Add.getContentPane().add(lblNewLabel);
		
		JLabel lblRemplirLesChamps = new JLabel("Remplir les champs suivants :");
		lblRemplirLesChamps.setForeground(Color.BLACK);
		lblRemplirLesChamps.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		lblRemplirLesChamps.setBounds(487, 38, 253, 33);
		Add.getContentPane().add(lblRemplirLesChamps);
		
		


	}
}
