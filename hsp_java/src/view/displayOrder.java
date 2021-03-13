package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import db_connexion.DbConnection;
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
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					displayOrder window = new displayOrder();
					window.dispOrder.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		dispOrder.setBounds(100, 100, 600, 511);
		dispOrder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dispOrder.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Commandes");
		lblNewLabel_1.setForeground(Color.ORANGE);
		lblNewLabel_1.setFont(new Font("Monotype Corsiva", Font.PLAIN, 63));
		lblNewLabel_1.setBounds(0, 139, 300, 189);
		dispOrder.getContentPane().add(lblNewLabel_1);

		JComboBox cb = new JComboBox();
		cb.setBounds(342, 56, 215, 22);
		dispOrder.getContentPane().add(cb);

		JLabel lblManuf = new JLabel("Fabricant");
		lblManuf.setForeground(Color.WHITE);
		lblManuf.setBounds(360, 121, 80, 14);
		dispOrder.getContentPane().add(lblManuf);

		JLabel lblQty = new JLabel("Quantit\u00E9 command\u00E9e");
		lblQty.setForeground(Color.WHITE);
		lblQty.setBounds(360, 180, 135, 14);
		dispOrder.getContentPane().add(lblQty);

		JLabel lblLots = new JLabel("Lots de 50");
		lblLots.setForeground(Color.WHITE);
		lblLots.setBounds(487, 217, 70, 14);
		dispOrder.getContentPane().add(lblLots);

		JLabel lblDate = new JLabel("Date de la commande");
		lblDate.setForeground(Color.WHITE);
		lblDate.setBounds(360, 250, 135, 14);
		dispOrder.getContentPane().add(lblDate);

		JLabel lblOrderDate = new JLabel("");
		lblOrderDate.setForeground(Color.CYAN);
		lblOrderDate.setBounds(360, 287, 109, 14);
		dispOrder.getContentPane().add(lblOrderDate);

		JLabel lblError = new JLabel("");
		lblError.setForeground(Color.GREEN);
		lblError.setBounds(377, 423, 197, 14);
		dispOrder.getContentPane().add(lblError);

		JLabel lblOrderManuf = new JLabel("");
		lblOrderManuf.setForeground(Color.CYAN);
		lblOrderManuf.setBounds(360, 146, 180, 14);
		dispOrder.getContentPane().add(lblOrderManuf);

		JLabel lblOrderQty = new JLabel("");
		lblOrderQty.setForeground(Color.CYAN);
		lblOrderQty.setBounds(360, 217, 109, 14);
		dispOrder.getContentPane().add(lblOrderQty);

		JButton btnBack = new JButton("Retour");
		btnBack.setForeground(Color.WHITE);
		btnBack.setBackground(Color.RED);
		btnBack.setBounds(68, 412, 135, 23);
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
				String medic = cb.getSelectedItem().toString();
				String requete = "Select * from commande where nom_medicament = '" + medic + "'";
				ResultSet result = Connect.Requete(cnx, requete);
				try {
					while(result.next()) {
						lblOrderManuf.setText(result.getString("fabricant"));
						lblOrderQty.setText(result.getString("qte"));
						lblOrderDate.setText(result.getString("date"));
					}
					result.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
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
				String medic = cb.getSelectedItem().toString();
				String requete = "Select qte from commande where nom_medicament = '" + medic + "'";
				ResultSet result = Connect.Requete(cnx, requete);
				try {
					while(result.next()) {
						int Order_Qte = result.getInt("qte");
						requete = "Select qte from stock where nom = '" + medic + "'";
						result = Connect.Requete(cnx, requete);
						try {
							while(result.next()) {
								int Actual_Qte = result.getInt("qte");
								int total_qte = Order_Qte + Actual_Qte;
								requete = "Update stock set qte = '" + total_qte + "' where nom = '" + medic + "'";
								success = Connect.Requete_prepare(cnx, requete);

								if (success == true) {
									lblError.setForeground(Color.GREEN);
									lblError.setText("Commande validée");
									requete = "delete from commande where nom_medicament = '" + medic + "'";
									Connect.Requete_prepare(cnx, requete);
								}
								else {
									lblError.setForeground(Color.RED);
									lblError.setText("Erreur");
								}
								
							}
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
					result.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnValid.setBounds(360, 330, 180, 23);
		dispOrder.getContentPane().add(btnValid);
		
		JButton btnDelete = new JButton("Annuler la commande");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String medic = cb.getSelectedItem().toString();
				String requete = "delete from commande where nom_medicament = '" + medic + "'";
				Connect.Requete_prepare(cnx, requete);
				lblError.setForeground(Color.GREEN);
				lblError.setText("Commande annulée");
			}
		});
		btnDelete.setBounds(360, 389, 180, 23);
		dispOrder.getContentPane().add(btnDelete);
		
		JLabel lbl = new JLabel("");
		lbl.setIcon(new ImageIcon("C:\\Users\\GONCALVES_Na\\Pictures\\medoc.jpg"));
		lbl.setForeground(Color.ORANGE);
		lbl.setFont(new Font("Monotype Corsiva", Font.PLAIN, 63));
		lbl.setBounds(0, 0, 300, 472);
		dispOrder.getContentPane().add(lbl);
	}
}
