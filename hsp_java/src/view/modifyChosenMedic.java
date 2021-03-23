package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import db_connexion.DbConnection;
import manager.methods;
import javax.swing.JTextArea;

import global_variable.*;
import javax.swing.JButton;
import java.awt.Font;

public class modifyChosenMedic extends global{

	JFrame ModifyChosen;
	JTextField txtName;
	JTextField txtFabriquant;
	JTextField txtQty;
	boolean success;



	/**
	 * Create the application.
	 */
	public modifyChosenMedic() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ModifyChosen = new JFrame();
		ModifyChosen.getContentPane().setBackground(Color.DARK_GRAY);
		ModifyChosen.setBackground(Color.DARK_GRAY);
		ModifyChosen.setTitle("Modifier m\u00E9dicament");
		ModifyChosen.setBounds(100, 100, 766, 543);
		ModifyChosen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ModifyChosen.getContentPane().setLayout(null);

		DbConnection Connect = new DbConnection();
		Connection cnx = Connect.dbConnection();

		JLabel lblName = new JLabel("Nom");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		lblName.setBounds(339, 82, 39, 25);
		ModifyChosen.getContentPane().add(lblName);

		JLabel lblFabriquant = new JLabel("Fabriquant");
		lblFabriquant.setForeground(Color.WHITE);
		lblFabriquant.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		lblFabriquant.setBounds(318, 137, 85, 25);
		ModifyChosen.getContentPane().add(lblFabriquant);

		JLabel lblQty = new JLabel("Quantit\u00E9");
		lblQty.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		lblQty.setForeground(Color.WHITE);
		lblQty.setBounds(325, 203, 78, 25);
		ModifyChosen.getContentPane().add(lblQty);

		JLabel lblLots = new JLabel("Lots de 50");
		lblLots.setForeground(Color.WHITE);
		lblLots.setBounds(425, 226, 70, 14);
		ModifyChosen.getContentPane().add(lblLots);

		JLabel lblDangers = new JLabel("Dangers potentiels");
		lblDangers.setForeground(Color.WHITE);
		lblDangers.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		lblDangers.setBounds(295, 284, 174, 20);
		ModifyChosen.getContentPane().add(lblDangers);

		txtName = new JTextField();
		txtName.setBounds(310, 106, 96, 20);
		ModifyChosen.getContentPane().add(txtName);
		txtName.setColumns(10);

		txtFabriquant = new JTextField();
		txtFabriquant.setColumns(10);
		txtFabriquant.setBounds(310, 162, 96, 20);
		ModifyChosen.getContentPane().add(txtFabriquant);

		txtQty = new JTextField();
		txtQty.setColumns(10);
		txtQty.setBounds(307, 229, 104, 20);
		ModifyChosen.getContentPane().add(txtQty);

		JTextArea txtDangers = new JTextArea();
		txtDangers.setBounds(244, 314, 240, 60);
		ModifyChosen.getContentPane().add(txtDangers);

		JButton btnSave = new JButton("Enregistrer");
		btnSave.setForeground(Color.WHITE);
		btnSave.setBackground(Color.ORANGE);
		btnSave.setBounds(307, 403, 116, 23);
		ModifyChosen.getContentPane().add(btnSave);

		JLabel lblSuccess = new JLabel("");
		lblSuccess.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		lblSuccess.setForeground(Color.ORANGE);
		lblSuccess.setBounds(227, 32, 305, 30);
		ModifyChosen.getContentPane().add(lblSuccess);

		JButton btnBack = new JButton("Retour");
		btnBack.setForeground(Color.WHITE);
		btnBack.setBackground(Color.RED);
		btnBack.setBounds(318, 458, 89, 23);
		ModifyChosen.getContentPane().add(btnBack);

		String requete = "Select * from stock where nom='" + medic + "'";
		ResultSet result = Connect.Requete(cnx, requete);
		try {
			while(result.next()) {
				txtName.setText(result.getString("nom"));
				txtFabriquant.setText(result.getString("fabricant"));
				txtQty.setText(result.getString("qte"));
				txtDangers.setText(result.getString("danger"));
				id = result.getInt("id");
			}
		} 
		catch (Exception ex) {
			//System.out.println(ex);
		}

		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				methods Methode = new methods();
				Methode.modify_medic(txtName.getText(), txtFabriquant.getText(), txtQty.getText(), txtDangers.getText(), success, lblSuccess);
			}
		});

		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ModifyChosen.dispose();
					modifyMedic window = new modifyMedic();
					window.Modify.setVisible(true);
				}

				catch (Exception ex) {

				}
			}
		});
	}
}
