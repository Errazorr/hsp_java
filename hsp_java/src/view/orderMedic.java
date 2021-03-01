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
		order.setTitle("Commander");
		order.setBounds(100, 100, 708, 375);
		order.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		order.getContentPane().setLayout(null);

		DbConnection Connect = new DbConnection();
		Connection cnx = Connect.dbConnection();
		String requete = "Select nom from stock";
		ResultSet result = Connect.Requete(cnx, requete);

		JComboBox cb = new JComboBox();
		cb.setBounds(10, 31, 160, 22);
		order.getContentPane().add(cb);

		try {
			while(result.next()) {
				cb.addItem(result.getString(1).trim());
			}
			result.close();
		}
		catch (Exception ex) {System.out.println(ex);}

		JLabel lblManufacturer = new JLabel("Fabricant");
		lblManufacturer.setBounds(10, 107, 60, 14);
		order.getContentPane().add(lblManufacturer);

		JLabel lblQty = new JLabel("Quantit\u00E9");
		lblQty.setBounds(10, 145, 49, 14);
		order.getContentPane().add(lblQty);

		JLabel lblNewQty = new JLabel("");
		lblNewQty.setBounds(195, 145, 49, 14);
		order.getContentPane().add(lblNewQty);

		JLabel lblOrderQty = new JLabel("Nbr de lots");
		lblOrderQty.setBounds(10, 180, 95, 14);
		order.getContentPane().add(lblOrderQty);

		JLabel lblActualQty = new JLabel("");
		lblActualQty.setBounds(74, 145, 96, 14);
		order.getContentPane().add(lblActualQty);

		txtOrderQty = new JTextField();
		txtOrderQty.setBounds(115, 177, 96, 20);
		order.getContentPane().add(txtOrderQty);
		txtOrderQty.setColumns(10);

		JLabel lblLots = new JLabel("Lots de 50");
		lblLots.setBounds(254, 180, 70, 14);
		order.getContentPane().add(lblLots);

		JLabel lblLots_1 = new JLabel("Lots de 50");
		lblLots_1.setBounds(254, 145, 70, 14);
		order.getContentPane().add(lblLots_1);

		JLabel lblError = new JLabel("");
		lblError.setForeground(Color.GREEN);
		lblError.setBounds(10, 222, 160, 14);
		order.getContentPane().add(lblError);

		JButton btnDisplayOrders = new JButton("Afficher commandes");
		btnDisplayOrders.setBounds(10, 310, 314, 23);
		order.getContentPane().add(btnDisplayOrders);

		JButton btnOrder = new JButton("Passer commande");
		btnOrder.setBounds(10, 276, 314, 23);
		order.getContentPane().add(btnOrder);

		JLabel lblManufacturerName = new JLabel("");
		lblManufacturerName.setBounds(80, 107, 131, 14);
		order.getContentPane().add(lblManufacturerName);

		JButton btnOrderNew = new JButton("Commander un nouveau m\u00E9dicament");
		btnOrderNew.setBounds(10, 242, 314, 23);
		order.getContentPane().add(btnOrderNew);
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
