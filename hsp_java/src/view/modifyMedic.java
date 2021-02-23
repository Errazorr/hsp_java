package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JTextField;

import global_variable.*;
import db_connexion.DbConnection;

import javax.swing.JButton;
import javax.swing.JComboBox;

public class modifyMedic extends global {

	JFrame Modify;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					modifyMedic window = new modifyMedic();
					window.Modify.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public modifyMedic() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Modify = new JFrame();
		Modify.setTitle("Modifier m\u00E9dicament");
		Modify.setBounds(100, 100, 310, 235);
		Modify.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Modify.getContentPane().setLayout(null);

		JLabel lblName = new JLabel("Nom du m\u00E9dicament \u00E0 modifier");
		lblName.setBounds(40, 40, 200, 14);
		Modify.getContentPane().add(lblName);

		DbConnection Connect = new DbConnection();
		Connection cnx = Connect.dbConnection();
		String requete = "Select nom from stock";
		ResultSet result = Connect.Requete(cnx, requete);

		JComboBox cb=new JComboBox();    
		cb.setBounds(40, 75,200,20);
		Modify.getContentPane().add(cb);

		try {
			while(result.next()) {
				cb.addItem(result.getString(1).trim());
			}
			result.close();
		}
		catch (Exception ex) {System.out.println(ex);}

		JButton btnChoix = new JButton("Modifier");
		btnChoix.setBounds(100, 115, 89, 23);
		Modify.getContentPane().add(btnChoix);
		btnChoix.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				medic = cb.getSelectedItem().toString();
				Modify.dispose();
				modifyChosenMedic window = new modifyChosenMedic();
				window.ModifyChosen.setVisible(true);
			}
		});
		
		JButton btnBack = new JButton("Retour");
		btnBack.setBounds(100, 149, 89, 23);
		Modify.getContentPane().add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Modify.dispose();
					stock window = new stock();
					window.Stock.setVisible(true);
				}
				
				catch (Exception ex) {

				}
			}
		});
		
	}
}
