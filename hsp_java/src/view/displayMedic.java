package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import manager.methods;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import db_connexion.DbConnection;
import javax.swing.JDesktopPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

public class displayMedic {

	JFrame Display;


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
		Display.getContentPane().setBackground(Color.DARK_GRAY);
		Display.setTitle("Afficher un m\u00E9dicament");
		Display.setBounds(100, 100, 766, 543);
		Display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Display.getContentPane().setLayout(null);

		JComboBox cb = new JComboBox();
		cb.setForeground(Color.WHITE);
		cb.setBackground(Color.DARK_GRAY);
		cb.setBounds(507, 127, 150, 22);
		Display.getContentPane().add(cb);

		JButton btnBack = new JButton("Retour");
		btnBack.setForeground(Color.WHITE);
		btnBack.setBackground(Color.RED);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Display.dispose();
				stock window = new stock();
				window.Stock.setVisible(true);
			}
		});
		btnBack.setBounds(125, 438, 150, 23);
		Display.getContentPane().add(btnBack);

		JLabel lblName = new JLabel("Nom");
		lblName.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		lblName.setForeground(Color.WHITE);
		lblName.setBounds(447, 204, 49, 22);
		Display.getContentPane().add(lblName);

		JLabel lblMedicName = new JLabel("");
		lblMedicName.setForeground(Color.CYAN);
		lblMedicName.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		lblMedicName.setBounds(557, 204, 162, 22);
		Display.getContentPane().add(lblMedicName);

		JLabel lblManufacturer = new JLabel("Fabricant");
		lblManufacturer.setForeground(Color.WHITE);
		lblManufacturer.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		lblManufacturer.setBounds(447, 237, 80, 20);
		Display.getContentPane().add(lblManufacturer);
		
		JLabel lblNewLabel_1_1 = new JLabel("Affichage");
		lblNewLabel_1_1.setForeground(Color.CYAN);
		lblNewLabel_1_1.setFont(new Font("Monotype Corsiva", Font.PLAIN, 63));
		lblNewLabel_1_1.setBounds(81, 150, 268, 189);
		Display.getContentPane().add(lblNewLabel_1_1);

		JLabel lblMedicManufacturer = new JLabel("");
		lblMedicManufacturer.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		lblMedicManufacturer.setForeground(Color.CYAN);
		lblMedicManufacturer.setBounds(557, 237, 162, 20);
		Display.getContentPane().add(lblMedicManufacturer);

		JLabel lblQty = new JLabel("Quantit\u00E9");
		lblQty.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		lblQty.setForeground(Color.WHITE);
		lblQty.setBounds(447, 275, 80, 22);
		Display.getContentPane().add(lblQty);

		JLabel lblMedicQty = new JLabel("");
		lblMedicQty.setForeground(Color.CYAN);
		lblMedicQty.setBounds(557, 268, 100, 22);
		Display.getContentPane().add(lblMedicQty);

		JLabel lblLots = new JLabel("Lots de 50");
		lblLots.setForeground(Color.WHITE);
		lblLots.setBounds(650, 268, 100, 14);
		Display.getContentPane().add(lblLots);

		JLabel lblDanger = new JLabel("Dangers potentiels");
		lblDanger.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		lblDanger.setForeground(Color.WHITE);
		lblDanger.setBounds(507, 308, 141, 31);
		Display.getContentPane().add(lblDanger);

		JTextArea txtDangers = new JTextArea();
		txtDangers.setBounds(447, 350, 252, 69);
		Display.getContentPane().add(txtDangers);
		
		JLabel lblNewLabel = new JLabel("New label");
		String chemin = "medoc.jpg";
		String resource = getClass().getClassLoader().getResource(chemin).getPath();
		lblNewLabel.setIcon(new ImageIcon(resource));
		lblNewLabel.setBounds(0, 0, 391, 504);
		Display.getContentPane().add(lblNewLabel);
	

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
				
				methods Methode = new methods();
				Methode.disp_medic(cb.getSelectedItem().toString(), lblMedicName, lblMedicManufacturer, lblMedicQty, lblDanger);
			}
		});
	}
}
