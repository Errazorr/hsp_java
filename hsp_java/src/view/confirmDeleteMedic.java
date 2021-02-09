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

public class confirmDeleteMedic extends global {

	JFrame DeleteConfirm;

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
		DeleteConfirm.setBounds(100, 100, 444, 246);
		DeleteConfirm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DeleteConfirm.getContentPane().setLayout(null);
		
		JLabel lbl1 = new JLabel("Etes-vous sur de vouloir supprimer ce m\u00E9dicament ?");
		lbl1.setBounds(74, 48, 296, 14);
		DeleteConfirm.getContentPane().add(lbl1);
		
		JLabel lblMedic = new JLabel("");
		lblMedic.setBounds(74, 89, 246, 14);
		DeleteConfirm.getContentPane().add(lblMedic);
		lblMedic.setText(medic);
		
		DbConnection Connect = new DbConnection();
	    Connection cnx = Connect.dbConnection();
		System.out.println(Connect.dbConnection());
		
		JButton btnDelete = new JButton("Valider");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String requete = "Delete from stock where nom='" + medic + "'";
				Connect.Requete_prepare(cnx, requete);
			}
		});
		btnDelete.setBounds(74, 150, 89, 23);
		DeleteConfirm.getContentPane().add(btnDelete);
		
		JButton btnBack = new JButton("Retour");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteConfirm.dispose();
				deleteMedic window = new deleteMedic();
				window.Delete.setVisible(true);
			}
		});
		btnBack.setBounds(231, 150, 89, 23);
		DeleteConfirm.getContentPane().add(btnBack);
	}
}
