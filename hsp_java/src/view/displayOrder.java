package view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import global_variable.*;
import db_connexion.DbConnection;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class displayOrder {

	JFrame dispOrder;

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
		dispOrder.setBounds(100, 100, 397, 518);
		dispOrder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dispOrder.getContentPane().setLayout(null);
		
		JComboBox cb = new JComboBox();
		cb.setBounds(40, 36, 180, 22);
		dispOrder.getContentPane().add(cb);
		
		JLabel lblManuf = new JLabel("Fabricant");
		lblManuf.setBounds(23, 101, 80, 14);
		dispOrder.getContentPane().add(lblManuf);
		
		JLabel lblQty = new JLabel("Quantit\u00E9 command\u00E9e");
		lblQty.setBounds(23, 160, 135, 14);
		dispOrder.getContentPane().add(lblQty);
		
		JLabel lblLots = new JLabel("Lots de 50");
		lblLots.setBounds(150, 197, 70, 14);
		dispOrder.getContentPane().add(lblLots);
		
		String[] columns = {"Médicament","Fabricant","Quantité","Daete"};
		DbConnection Connect = new DbConnection();
		Connection cnx = Connect.dbConnection();
		String requete = "Select nom_medicament, fabricant, qte, date from commande where id = '1'";
		ResultSet result = Connect.Requete(cnx, requete);
		
		try {
			while(result.next()) {
				String[] row = {result.getString("nom_medicament"), result.getString("fabricant"), result.getString("qte"), result.getString("date")};
			}
			result.close();
		}
		catch (Exception ex) {System.out.println(ex);}
	}
}
