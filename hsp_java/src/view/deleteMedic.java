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
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

public class deleteMedic extends global {

	JFrame Delete;



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
		Delete.getContentPane().setBackground(Color.DARK_GRAY);
		Delete.setTitle("Supprimer un m\u00E9dicament");
		Delete.setBounds(100, 100, 766, 543);
		Delete.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Delete.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Supprimer");
		lblNewLabel_1_1.setForeground(Color.RED);
		lblNewLabel_1_1.setFont(new Font("Monotype Corsiva", Font.PLAIN, 63));
		lblNewLabel_1_1.setBounds(68, 147, 247, 189);
		Delete.getContentPane().add(lblNewLabel_1_1);
		
		DbConnection Connect = new DbConnection();
	    Connection cnx = Connect.dbConnection();
		String requete = "Select nom from stock";
		ResultSet result = Connect.Requete(cnx, requete);

		JComboBox cb=new JComboBox();    
		cb.setForeground(Color.WHITE);
		cb.setBackground(Color.DARK_GRAY);
		cb.setBounds(486, 242,200,20);
		Delete.getContentPane().add(cb);

		try {
			while(result.next()) {
				cb.addItem(result.getString(1).trim());
			}
			result.close();
		}
		catch (Exception ex) {System.out.println(ex);}

		JButton btnDelete = new JButton("Supprimer");
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setBackground(Color.RED);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				medic = cb.getSelectedItem().toString();
				Delete.dispose();
				confirmDeleteMedic window = new confirmDeleteMedic();
				window.DeleteConfirm.setVisible(true);
			}
		});
		btnDelete.setBounds(527, 305, 130, 23);
		Delete.getContentPane().add(btnDelete);
		
		JLabel lblNewLabel = new JLabel("New label");
		String chemin = "medoc.jpg";
		String resource = getClass().getClassLoader().getResource(chemin).getPath();
		lblNewLabel.setIcon(new ImageIcon(resource));
		lblNewLabel.setBounds(0, 0, 384, 504);
		Delete.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Choisir le m\u00E9dicament \u00E0 supprimer");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(475, 196, 237, 35);
		Delete.getContentPane().add(lblNewLabel_1);
		

	}
}
