package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import db_connexion.DbConnection;
import manager.methods;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;

public class displayOrder {

	JFrame dispOrder;
	boolean success;



	/**
	 * Create the application.
	 */
	public displayOrder() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		dispOrder = new JFrame();
		dispOrder.getContentPane().setBackground(Color.DARK_GRAY);
		dispOrder.setBounds(100, 100, 767, 543);
		dispOrder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dispOrder.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Commandes");
		lblNewLabel_1.setForeground(Color.ORANGE);
		lblNewLabel_1.setFont(new Font("Monotype Corsiva", Font.PLAIN, 63));
		lblNewLabel_1.setBounds(51, 135, 300, 189);
		dispOrder.getContentPane().add(lblNewLabel_1);

		JComboBox cb = new JComboBox();
		cb.setBounds(456, 72, 215, 22);
		dispOrder.getContentPane().add(cb);

		JLabel lblManuf = new JLabel("Fabricant");
		lblManuf.setForeground(Color.WHITE);
		lblManuf.setBounds(474, 137, 80, 14);
		dispOrder.getContentPane().add(lblManuf);

		JLabel lblQty = new JLabel("Quantit\u00E9 command\u00E9e");
		lblQty.setForeground(Color.WHITE);
		lblQty.setBounds(474, 196, 135, 14);
		dispOrder.getContentPane().add(lblQty);

		JLabel lblLots = new JLabel("Lots de 50");
		lblLots.setForeground(Color.WHITE);
		lblLots.setBounds(601, 233, 70, 14);
		dispOrder.getContentPane().add(lblLots);

		JLabel lblDate = new JLabel("Date de la commande");
		lblDate.setForeground(Color.WHITE);
		lblDate.setBounds(474, 266, 135, 14);
		dispOrder.getContentPane().add(lblDate);

		JLabel lblOrderDate = new JLabel("");
		lblOrderDate.setForeground(Color.CYAN);
		lblOrderDate.setBounds(474, 303, 109, 14);
		dispOrder.getContentPane().add(lblOrderDate);

		JLabel lblError = new JLabel("");
		lblError.setForeground(Color.GREEN);
		lblError.setBounds(491, 439, 197, 14);
		dispOrder.getContentPane().add(lblError);

		JLabel lblOrderManuf = new JLabel("");
		lblOrderManuf.setForeground(Color.CYAN);
		lblOrderManuf.setBounds(474, 162, 180, 14);
		dispOrder.getContentPane().add(lblOrderManuf);

		JLabel lblOrderQty = new JLabel("");
		lblOrderQty.setForeground(Color.CYAN);
		lblOrderQty.setBounds(474, 233, 109, 14);
		dispOrder.getContentPane().add(lblOrderQty);

		JButton btnBack = new JButton("Retour");
		btnBack.setForeground(Color.WHITE);
		btnBack.setBackground(Color.RED);
		btnBack.setBounds(114, 447, 135, 23);
		dispOrder.getContentPane().add(btnBack);

		DbConnection Connect = new DbConnection();
		Connection cnx = Connect.dbConnection();
		String requete = "Select nom_medicament from commande";
		ResultSet result = Connect.Requete(cnx, requete);

		try {
			while(result.next()) {
				cb.addItem(result.getString(1).trim());
			}
			result.close();
		}
		catch (Exception ex) {System.out.println(ex);}

		cb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				methods Methode = new methods();
				Methode.disp_order(cb.getSelectedItem().toString(), lblOrderManuf, lblOrderQty, lblOrderDate);
			}
		});

		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispOrder.dispose();
					stock window = new stock();
					window.Stock.setVisible(true);
				}

				catch (Exception ex) {

				}
			}
		});

		JButton btnValid = new JButton("Valider la commande");
		btnValid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				methods Methode = new methods();
				Methode.validate_order(cb.getSelectedItem().toString(), success , lblError);
			}
		});
		btnValid.setBounds(474, 346, 180, 23);
		dispOrder.getContentPane().add(btnValid);
		
		JButton btnDelete = new JButton("Annuler la commande");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				methods Methode = new methods();
				Methode.delete_order(cb.getSelectedItem().toString(), lblError);
			}
		});
		btnDelete.setBounds(474, 405, 180, 23);
		dispOrder.getContentPane().add(btnDelete);
		
		JLabel lbl = new JLabel("");
		String chemin = "medoc.jpg";
		String resource = getClass().getClassLoader().getResource(chemin).getPath();
		lbl.setIcon(new ImageIcon(resource));
		lbl.setForeground(Color.ORANGE);
		lbl.setFont(new Font("Monotype Corsiva", Font.PLAIN, 63));
		lbl.setBounds(0, 0, 370, 504);
		dispOrder.getContentPane().add(lbl);
	}
}
