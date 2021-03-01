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

public class displayOrder {

	JFrame dispOrder;
	private JTable OrderTable;

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
		dispOrder.setBounds(100, 100, 923, 518);
		dispOrder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dispOrder.getContentPane().setLayout(null);
		
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
		
		OrderTable = new JTable();
		OrderTable.setBounds(47, 69, 734, 331);
		dispOrder.getContentPane().add(OrderTable);
	}
}
