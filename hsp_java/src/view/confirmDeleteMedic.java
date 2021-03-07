package view;

import java.awt.EventQueue;
import global_variable.*;
import javax.swing.JFrame;
import javax.swing.JLabel;

import db_connexion.DbConnection;

import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.Color;
import java.awt.Font;

public class confirmDeleteMedic extends global {

	JFrame DeleteConfirm;
	boolean success;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					confirmDeleteMedic window = new confirmDeleteMedic();
					window.DeleteConfirm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public confirmDeleteMedic() {
		initialize();
	}

	/**
	 * Initialize the contents of the DeleteConfirm.
	 */
	private void initialize() {
		DeleteConfirm = new JFrame();
		DeleteConfirm.getContentPane().setBackground(Color.DARK_GRAY);
		DeleteConfirm.setBounds(100, 100, 766, 543);
		DeleteConfirm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DeleteConfirm.getContentPane().setLayout(null);
		
		JLabel lbl1 = new JLabel("Etes-vous sur de vouloir supprimer ce m\u00E9dicament ?");
		lbl1.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		lbl1.setForeground(Color.WHITE);
		lbl1.setBounds(229, 140, 389, 38);
		DeleteConfirm.getContentPane().add(lbl1);
		
		JLabel lblMedic = new JLabel("");
		lblMedic.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		lblMedic.setForeground(Color.CYAN);
		lblMedic.setBounds(353, 213, 116, 38);
		DeleteConfirm.getContentPane().add(lblMedic);
		lblMedic.setText(medic);
		
		JLabel lblSuccess = new JLabel("");
		lblSuccess.setBounds(74, 138, 246, 14);
		DeleteConfirm.getContentPane().add(lblSuccess);
		
		DbConnection Connect = new DbConnection();
	    Connection cnx = Connect.dbConnection();
		
		JButton btnDelete = new JButton("Valider");
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setBackground(Color.GRAY);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String requete = "Delete from stock where nom='" + medic + "'";
				success = Connect.Requete_prepare(cnx, requete);
				
				if (success == true) {
					lblSuccess.setForeground(Color.GREEN);
					lblSuccess.setText("M�dicament supprim� avec succ�s");
				}
				else {
					lblSuccess.setForeground(Color.RED);
					lblSuccess.setText("Suppression �chou�e");
				}
			}
		});
		btnDelete.setBounds(335, 262, 89, 23);
		DeleteConfirm.getContentPane().add(btnDelete);
		
		JButton btnBack = new JButton("Retour");
		btnBack.setBackground(Color.RED);
		btnBack.setForeground(Color.WHITE);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteConfirm.dispose();
				deleteMedic window = new deleteMedic();
				window.Delete.setVisible(true);
			}
		});
		btnBack.setBounds(335, 344, 89, 23);
		DeleteConfirm.getContentPane().add(btnBack);
		
	}
}
