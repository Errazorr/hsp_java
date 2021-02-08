package view;


import db_connexion.DbConnection;
import global_variable.*;

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

public class addMedic {

	JFrame Add;
	private JTextField textName;
	private JTextField textSupplier;
	private JTextField textQuantity;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addMedic window = new addMedic();
					window.Add.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		Add.setTitle("Ajouter un m\u00E9dicament");
		Add.setBounds(100, 100, 338, 399);
		Add.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Add.getContentPane().setLayout(null);

		JLabel lblMedicName = new JLabel("Nom");
		lblMedicName.setBounds(63, 58, 54, 14);
		Add.getContentPane().add(lblMedicName);

		JLabel lblSupplier = new JLabel("Fabriquant");
		lblSupplier.setBounds(32, 100, 85, 14);
		Add.getContentPane().add(lblSupplier);

		JLabel lblQuantity = new JLabel("Quantit\u00E9");
		lblQuantity.setBounds(43, 141, 74, 14);
		Add.getContentPane().add(lblQuantity);

		JLabel lblPack = new JLabel("Lots de 50");
		lblPack.setBounds(228, 141, 70, 14);
		Add.getContentPane().add(lblPack);

		JLabel lblPotentialDangers = new JLabel("Dangers potentiels");
		lblPotentialDangers.setBounds(32, 178, 154, 14);
		Add.getContentPane().add(lblPotentialDangers);

		textName = new JTextField();
		textName.setBounds(110, 55, 96, 20);
		Add.getContentPane().add(textName);
		textName.setColumns(10);

		textSupplier = new JTextField();
		textSupplier.setColumns(10);
		textSupplier.setBounds(110, 94, 96, 20);
		Add.getContentPane().add(textSupplier);

		textQuantity = new JTextField();
		textQuantity.setColumns(10);
		textQuantity.setBounds(110, 135, 96, 20);
		Add.getContentPane().add(textQuantity);

		JLabel lblError = new JLabel("");
		lblError.setForeground(Color.RED);
		lblError.setBounds(32, 324, 266, 27);
		Add.getContentPane().add(lblError);

		JTextArea textPotentialDangers = new JTextArea();
		textPotentialDangers.setBounds(28, 205, 239, 53);
		Add.getContentPane().add(textPotentialDangers);

		DbConnection Connect = new DbConnection();
		Connection cnx = Connect.dbConnection();

		JButton btnAddMedic = new JButton("Ajouter");
		btnAddMedic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String requete = "Select * from stock where nom='" + textName.getText() + "'";
				ResultSet result = Connect.Requete(cnx, requete);
				try {
					while(result.next()) {
						lblError.setText("Ce médicament est déjà enregistré");
					}
					System.out.println("test");
					requete = "INSERT INTO stock(nom, fabricant, qte, danger) VALUES('" + textName.getText() + "', '" 
							+ textSupplier.getText()  + "', '" + textQuantity.getText()  + "', '" + textPotentialDangers.getText() + "')";
					System.out.println(requete);
					Connect.Requete_prepare(cnx, requete);

				}
				catch (Exception ex) {

				}
			}
		});
		btnAddMedic.setBounds(117, 290, 89, 23);
		Add.getContentPane().add(btnAddMedic);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\GONCALVES_Na\\Pictures\\abstract-medical-wallpaper-template-design_53876-61802.jpg"));
		lblNewLabel.setBounds(0, 0, 324, 362);
		Add.getContentPane().add(lblNewLabel);

	}
}
