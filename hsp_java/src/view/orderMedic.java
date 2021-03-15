package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import java.awt.Font;
public class orderMedic {

	JFrame order;
	private JTextField txtOrderQty;

	


	/**
	 * Create the application.
	 */
	public orderMedic() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		order = new JFrame();
		order.getContentPane().setBackground(Color.DARK_GRAY);
		order.setTitle("Commander");
		order.setBounds(100, 100, 766, 543);
		order.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnBack = new JButton("Retour");
		btnBack.setForeground(Color.WHITE);
		btnBack.setBackground(Color.RED);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				order.dispose();
				stock window = new stock();
				window.Stock.setVisible(true);
			}
		});
		btnBack.setBounds(125, 438, 150, 23);
		order.getContentPane().add(btnBack);

		DbConnection Connect = new DbConnection();
		Connection cnx = Connect.dbConnection();
		String requete = "Select nom from stock";
		ResultSet result = Connect.Requete(cnx, requete);
		order.getContentPane().setLayout(null);

		JComboBox cb = new JComboBox();
		cb.setForeground(Color.WHITE);
		cb.setBackground(Color.DARK_GRAY);
		cb.setBounds(495, 108, 160, 22);
		order.getContentPane().add(cb);

		try {
			while(result.next()) {
				cb.addItem(result.getString(1).trim());
			}
			result.close();
		}
		catch (Exception ex) {System.out.println(ex);}

		JLabel lblManufacturer = new JLabel("Fabricant");
		lblManufacturer.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		lblManufacturer.setForeground(Color.WHITE);
		lblManufacturer.setBounds(467, 174, 70, 22);
		order.getContentPane().add(lblManufacturer);
		
		JLabel lblNewLabel_1 = new JLabel("Commander");
		lblNewLabel_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1.setFont(new Font("Monotype Corsiva", Font.PLAIN, 63));
		lblNewLabel_1.setBounds(56, 149, 297, 189);
		order.getContentPane().add(lblNewLabel_1);

		JLabel lblQty = new JLabel("Quantit\u00E9");
		lblQty.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		lblQty.setForeground(Color.WHITE);
		lblQty.setBounds(467, 207, 70, 22);
		order.getContentPane().add(lblQty);

		JLabel lblNewQty = new JLabel("");
		lblNewQty.setForeground(Color.CYAN);
		lblNewQty.setBounds(547, 232, 84, 14);
		order.getContentPane().add(lblNewQty);

		JLabel lblOrderQty = new JLabel("Nbr de lots");
		lblOrderQty.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		lblOrderQty.setForeground(Color.WHITE);
		lblOrderQty.setBounds(442, 273, 95, 28);
		order.getContentPane().add(lblOrderQty);

		JLabel lblActualQty = new JLabel("");
		lblActualQty.setForeground(Color.CYAN);
		lblActualQty.setBounds(547, 207, 84, 14);
		order.getContentPane().add(lblActualQty);

		txtOrderQty = new JTextField();
		txtOrderQty.setBounds(535, 274, 96, 20);
		order.getContentPane().add(txtOrderQty);
		txtOrderQty.setColumns(10);

		JLabel lblLots = new JLabel("Lots de 50");
		lblLots.setForeground(Color.WHITE);
		lblLots.setBounds(655, 277, 70, 14);
		order.getContentPane().add(lblLots);

		JLabel lblLots_1 = new JLabel("Lots de 50");
		lblLots_1.setForeground(Color.WHITE);
		lblLots_1.setBounds(655, 208, 70, 14);
		order.getContentPane().add(lblLots_1);

		JLabel lblError = new JLabel("");
		lblError.setBounds(426, 56, 314, 14);
		order.getContentPane().add(lblError);

		JButton btnDisplayOrders = new JButton("Afficher commandes");
		btnDisplayOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				order.dispose();
				displayOrder window = new displayOrder();
				window.dispOrder.setVisible(true);
			}
		});
		btnDisplayOrders.setForeground(Color.WHITE);
		btnDisplayOrders.setBackground(Color.DARK_GRAY);
		btnDisplayOrders.setBounds(426, 408, 314, 23);
		order.getContentPane().add(btnDisplayOrders);

		JButton btnOrder = new JButton("Passer commande");
		btnOrder.setForeground(Color.WHITE);
		btnOrder.setBackground(Color.DARK_GRAY);
		btnOrder.setBounds(426, 363, 314, 23);
		order.getContentPane().add(btnOrder);

		JLabel lblManufacturerName = new JLabel("");
		lblManufacturerName.setForeground(Color.CYAN);
		lblManufacturerName.setBounds(547, 174, 131, 14);
		order.getContentPane().add(lblManufacturerName);

		JButton btnOrderNew = new JButton("Commander un nouveau m\u00E9dicament");
		btnOrderNew.setBackground(Color.DARK_GRAY);
		btnOrderNew.setForeground(Color.WHITE);
		btnOrderNew.setBounds(426, 315, 314, 23);
		order.getContentPane().add(btnOrderNew);
		
		JLabel lblNewLabel = new JLabel("New label");
		String chemin = "medoc.jpg";
		String resource = getClass().getClassLoader().getResource(chemin).getPath();
		lblNewLabel.setIcon(new ImageIcon(resource));
		lblNewLabel.setBounds(0, 0, 385, 504);
		order.getContentPane().add(lblNewLabel);
		
		btnOrderNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				order.dispose();
				addMedic window = new addMedic();
				window.Add.setVisible(true);
			}
		});

		cb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String medic = cb.getSelectedItem().toString();
				String requete = "Select * from stock where nom = '" + medic + "'";
				ResultSet result = Connect.Requete(cnx, requete);
				try {
					while(result.next()) {
						lblManufacturerName.setText(result.getString("fabricant"));
						lblActualQty.setText(result.getString("qte"));
						int acutalQty = Integer.parseInt(result.getString("qte"));

						txtOrderQty.addKeyListener(new KeyAdapter() {
							public void keyReleased(KeyEvent e) {
								try {
									int orderQty = Integer.parseInt(txtOrderQty.getText());
									int newQty = acutalQty + orderQty;
									lblNewQty.setText("-> "+newQty);
								}
								catch(Exception ex) {

								}
							}
						});
					}
					result.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});


		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Date date = new Date();
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
					String actualDate = formatter.format(date);
					String requete = "INSERT INTO commande(nom_medicament, fabricant, qte, date) VALUES('" + cb.getSelectedItem().toString() + "', '" 
							+ lblManufacturerName.getText()  + "', '" + txtOrderQty.getText()  + "', '" + actualDate + "')";
					boolean success = Connect.Requete_prepare(cnx, requete);
					if (success) {
						lblError.setForeground(Color.GREEN);
						lblError.setText("Commande passée avec succès");
					} else {
						lblError.setForeground(Color.RED);
						lblError.setText("Erreur, commande annulée");
					}
					
				}
				catch (Exception ex) {

				}
			}
		});
	}
}
