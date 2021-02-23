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

import javax.swing.JTextArea;

import global_variable.*;
import javax.swing.JButton;

public class modifyChosenMedic extends global{

	JFrame ModifyChosen;
	private JTextField txtName;
	private JTextField txtFabriquant;
	private JTextField txtQty;
	boolean success;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					modifyChosenMedic window = new modifyChosenMedic();
					window.ModifyChosen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		ModifyChosen.setTitle("Modifier m\u00E9dicament");
		ModifyChosen.setBounds(100, 100, 338, 400);
		ModifyChosen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ModifyChosen.getContentPane().setLayout(null);

		DbConnection Connect = new DbConnection();
		Connection cnx = Connect.dbConnection();

		JLabel lblName = new JLabel("Nom");
		lblName.setBounds(63, 58, 54, 14);
		ModifyChosen.getContentPane().add(lblName);

		JLabel lblFabriquant = new JLabel("Fabriquant");
		lblFabriquant.setBounds(32, 100, 85, 14);
		ModifyChosen.getContentPane().add(lblFabriquant);

		JLabel lblQty = new JLabel("Quantit\u00E9");
		lblQty.setBounds(43, 141, 74, 14);
		ModifyChosen.getContentPane().add(lblQty);

		JLabel lblLots = new JLabel("Lots de 50");
		lblLots.setBounds(228, 141, 70, 14);
		ModifyChosen.getContentPane().add(lblLots);

		JLabel lblDangers = new JLabel("Dangers potentiels");
		lblDangers.setBounds(32, 178, 154, 14);
		ModifyChosen.getContentPane().add(lblDangers);

		txtName = new JTextField();
		txtName.setBounds(110, 55, 96, 20);
		ModifyChosen.getContentPane().add(txtName);
		txtName.setColumns(10);

		txtFabriquant = new JTextField();
		txtFabriquant.setColumns(10);
		txtFabriquant.setBounds(110, 94, 96, 20);
		ModifyChosen.getContentPane().add(txtFabriquant);

		txtQty = new JTextField();
		txtQty.setColumns(10);
		txtQty.setBounds(110, 135, 96, 20);
		ModifyChosen.getContentPane().add(txtQty);

		JTextArea txtDangers = new JTextArea();
		txtDangers.setBounds(32, 203, 240, 60);
		ModifyChosen.getContentPane().add(txtDangers);

		JButton btnSave = new JButton("Enregistrer");
		btnSave.setBounds(94, 274, 116, 23);
		ModifyChosen.getContentPane().add(btnSave);

		JLabel lblSuccess = new JLabel("");
		lblSuccess.setBounds(32, 33, 240, 14);
		ModifyChosen.getContentPane().add(lblSuccess);

		JButton btnBack = new JButton("Retour");
		btnBack.setBounds(110, 316, 89, 23);
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
				String requete = "update stock set nom = '" + txtName.getText() + "', fabricant = '" + txtFabriquant.getText() + "', qte = '"+  txtQty.getText() + "', danger = '" + txtDangers.getText() + "' where id='" + id + "'";
				success = Connect.Requete_prepare(cnx, requete);

				if (success == true) {
					lblSuccess.setForeground(Color.GREEN);
					lblSuccess.setText("Modifications enregistrées");
				}
				else {
					lblSuccess.setForeground(Color.RED);
					lblSuccess.setText("Modifications échouées");
				}
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
