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
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

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
		Modify.getContentPane().setBackground(Color.DARK_GRAY);
		Modify.setTitle("Modifier m\u00E9dicament");
		Modify.setBounds(100, 100, 766, 543);
		Modify.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Modify.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Modifier");
		lblNewLabel_1.setForeground(Color.ORANGE);
		lblNewLabel_1.setFont(new Font("Monotype Corsiva", Font.PLAIN, 63));
		lblNewLabel_1.setBounds(86, 147, 247, 189);
		Modify.getContentPane().add(lblNewLabel_1);

		JLabel lblName = new JLabel("Nom du m\u00E9dicament \u00E0 modifier");
		lblName.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		lblName.setForeground(Color.WHITE);
		lblName.setBounds(511, 195, 211, 33);
		Modify.getContentPane().add(lblName);

		DbConnection Connect = new DbConnection();
		Connection cnx = Connect.dbConnection();
		String requete = "Select nom from stock";
		ResultSet result = Connect.Requete(cnx, requete);

		JComboBox cb=new JComboBox();    
		cb.setBackground(Color.DARK_GRAY);
		cb.setForeground(Color.WHITE);
		cb.setBounds(511, 242,200,20);
		Modify.getContentPane().add(cb);

		try {
			while(result.next()) {
				cb.addItem(result.getString(1).trim());
			}
			result.close();
		}
		catch (Exception ex) {System.out.println(ex);}

		JButton btnChoix = new JButton("Modifier");
		btnChoix.setBackground(Color.ORANGE);
		btnChoix.setBounds(563, 294, 89, 23);
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
		btnBack.setForeground(Color.WHITE);
		btnBack.setBackground(Color.RED);
		btnBack.setBounds(172, 440, 89, 23);
		Modify.getContentPane().add(btnBack);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\FONTAINE_Ry\\Pictures\\medoc.jpg"));
		lblNewLabel.setBounds(0, 0, 410, 504);
		Modify.getContentPane().add(lblNewLabel);
		

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
