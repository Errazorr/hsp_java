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
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					orderMedic window = new orderMedic();
					window.order.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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

		DbConnection Connect = new DbConnection();
		Connection cnx = Connect.dbConnection();
		String requete = "Select nom from stock";
		ResultSet result = Connect.Requete(cnx, requete);
		order.getContentPane().setLayout(null);

		JComboBox cb = new JComboBox();
		cb.setForeground(Color.WHITE);
		cb.setBackground(Color.DARK_GRAY);
		cb.setBounds(500, 106, 160, 22);
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
		lblManufacturer.setBounds(495, 177, 70, 22);
		order.getContentPane().add(lblManufacturer);
		
		JLabel lblNewLabel_1 = new JLabel("Commander");
		lblNewLabel_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1.setFont(new Font("Monotype Corsiva", Font.PLAIN, 63));
		lblNewLabel_1.setBounds(56, 149, 297, 189);
		order.getContentPane().add(lblNewLabel_1);

		JLabel lblQty = new JLabel("Quantit\u00E9");
		lblQty.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		lblQty.setForeground(Color.WHITE);
		lblQty.setBounds(495, 210, 70, 22);
		order.getContentPane().add(lblQty);

		JLabel lblNewQty = new JLabel("");
		lblNewQty.setBounds(419, 226, 49, 14);
		order.getContentPane().add(lblNewQty);

		JLabel lblOrderQty = new JLabel("Nbr de lots");
		lblOrderQty.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		lblOrderQty.setForeground(Color.WHITE);
		lblOrderQty.setBounds(535, 253, 95, 28);
		order.getContentPane().add(lblOrderQty);

		JLabel lblActualQty = new JLabel("");
		lblActualQty.setForeground(Color.CYAN);
		lblActualQty.setBounds(579, 210, 96, 14);
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
		lblLots_1.setBounds(655, 211, 70, 14);
		order.getContentPane().add(lblLots_1);

		JLabel lblError = new JLabel("");
		lblError.setBounds(234, 303, 160, 14);
		lblError.setForeground(Color.GREEN);
		order.getContentPane().add(lblError);

		JButton btnDisplayOrders = new JButton("Afficher commandes");
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
		lblManufacturerName.setBounds(575, 177, 131, 14);
		order.getContentPane().add(lblManufacturerName);

		JButton btnOrderNew = new JButton("Commander un nouveau m\u00E9dicament");
		btnOrderNew.setBackground(new Color(144, 238, 144));
		btnOrderNew.setForeground(Color.WHITE);
		btnOrderNew.setBounds(426, 315, 314, 23);
		order.getContentPane().add(btnOrderNew);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\FONTAINE_Ry\\Pictures\\medoc.jpg"));
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
					Connect.Requete_prepare(cnx, requete);
				}
				catch (Exception ex) {

				}
			}
		});
	}
}
