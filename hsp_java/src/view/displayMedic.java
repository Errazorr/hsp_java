package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import db_connexion.DbConnection;

public class displayMedic {

	JFrame Display;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					displayMedic window = new displayMedic();
					window.Display.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public displayMedic() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Display = new JFrame();
		Display.setTitle("Afficher un m\u00E9dicament");
		Display.setBounds(100, 100, 590, 435);
		Display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Display.getContentPane().setLayout(null);

		JComboBox cb = new JComboBox();
		cb.setBounds(10, 11, 150, 22);
		Display.getContentPane().add(cb);

		JButton btnBack = new JButton("Retour");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Display.dispose();
				stock window = new stock();
				window.Stock.setVisible(true);
			}
		});
		btnBack.setBounds(416, 11, 150, 23);
		Display.getContentPane().add(btnBack);

		JLabel lblName = new JLabel("Nom");
		lblName.setBounds(10, 111, 49, 14);
		Display.getContentPane().add(lblName);

		JLabel lblMedicName = new JLabel("");
		lblMedicName.setBounds(111, 111, 151, 14);
		Display.getContentPane().add(lblMedicName);

		JLabel lblManufacturer = new JLabel("Fabricant");
		lblManufacturer.setBounds(10, 151, 49, 14);
		Display.getContentPane().add(lblManufacturer);

		JLabel lblMedicManufacturer = new JLabel("");
		lblMedicManufacturer.setBounds(111, 151, 151, 14);
		Display.getContentPane().add(lblMedicManufacturer);

		JLabel lblQty = new JLabel("Quantit\u00E9");
		lblQty.setBounds(10, 187, 49, 14);
		Display.getContentPane().add(lblQty);

		JLabel lblMedicQty = new JLabel("");
		lblMedicQty.setBounds(96, 187, 80, 14);
		Display.getContentPane().add(lblMedicQty);

		JLabel lblLots = new JLabel("Lots de 50");
		lblLots.setBounds(213, 187, 100, 14);
		Display.getContentPane().add(lblLots);

		JLabel lblDanger = new JLabel("Dangers potentiels");
		lblDanger.setBounds(10, 229, 252, 14);
		Display.getContentPane().add(lblDanger);

		JTextArea txtDangers = new JTextArea();
		txtDangers.setBounds(10, 254, 252, 69);
		Display.getContentPane().add(txtDangers);

		DbConnection Connect = new DbConnection();
		Connection cnx = Connect.dbConnection();
		String requete = "Select nom from stock";
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
				String requete = "Select * from stock where nom = '" + medic + "'";
				ResultSet result = Connect.Requete(cnx, requete);
				try {
					while(result.next()) {
						lblMedicName.setText(result.getString("nom"));
						lblMedicManufacturer.setText(result.getString("fabricant"));
						lblMedicQty.setText(result.getString("qte"));
						txtDangers.setText(result.getString("danger"));
					}
					result.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
	}
}
