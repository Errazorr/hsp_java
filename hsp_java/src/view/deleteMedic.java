package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import global_variable.*;
import javax.swing.JFrame;

import db_connexion.DbConnection;

import javax.swing.JButton;
import javax.swing.JComboBox;

public class deleteMedic extends global {

	JFrame Delete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deleteMedic window = new deleteMedic();
					window.Delete.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public deleteMedic() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Delete = new JFrame();
		Delete.setTitle("Supprimer un m\u00E9dicament");
		Delete.setBounds(100, 100, 370, 269);
		Delete.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Delete.getContentPane().setLayout(null);
		
		DbConnection Connect = new DbConnection();
	    Connection cnx = Connect.dbConnection();
		String requete = "Select nom from stock";
		ResultSet result = Connect.Requete(cnx, requete);

		JComboBox cb=new JComboBox();    
		cb.setBounds(84, 72,200,20);
		Delete.getContentPane().add(cb);

		try {
			while(result.next()) {
				cb.addItem(result.getString(1).trim());
			}
			result.close();
		}
		catch (Exception ex) {System.out.println(ex);}

		JButton btnDelete = new JButton("Supprimer");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				medic = cb.getSelectedItem().toString();
				Delete.dispose();
				confirmDeleteMedic window = new confirmDeleteMedic();
				window.DeleteConfirm.setVisible(true);
			}
		});
		btnDelete.setBounds(111, 158, 130, 23);
		Delete.getContentPane().add(btnDelete);
	}
}
