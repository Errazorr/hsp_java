package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import javax.swing.JLabel;

import db_connexion.DbConnection;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class viewRDV {

	 JFrame frame;
	 private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewRDV window = new viewRDV();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public viewRDV() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 775, 569);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JComboBox cb = new JComboBox();
		cb.setBounds(206, 61, 205, 22);
		frame.getContentPane().add(cb);
		
		JLabel lblNewLabel = new JLabel("id");
		lblNewLabel.setBounds(295, 36, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Retour");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				rdv window = new rdv();
				window.Rdv.setVisible(true);
			}
		});
		btnNewButton.setBounds(483, 11, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Nom patient");
		lblNewLabel_1.setBounds(133, 142, 94, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Pr\u00E9nom patient");
		lblNewLabel_1_1.setBounds(133, 166, 94, 14);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Mail\r\n");
		lblNewLabel_1_2.setBounds(133, 191, 94, 14);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Nom m\u00E9decin\r\n");
		lblNewLabel_1_3.setBounds(133, 216, 94, 14);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Date");
		lblNewLabel_1_4.setBounds(133, 241, 94, 14);
		frame.getContentPane().add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Heure");
		lblNewLabel_1_5.setBounds(133, 266, 94, 14);
		frame.getContentPane().add(lblNewLabel_1_5);
		
		JLabel lblName = new JLabel("");
		lblName.setBounds(357, 142, 94, 14);
		frame.getContentPane().add(lblName);
		
		JLabel lblLastName = new JLabel("");
		lblLastName.setBounds(357, 166, 94, 14);
		frame.getContentPane().add(lblLastName);
		
		JLabel lblMail = new JLabel("");
		lblMail.setBounds(357, 191, 94, 14);
		frame.getContentPane().add(lblMail);
		
		JLabel lblNameDoc = new JLabel("");
		lblNameDoc.setBounds(357, 216, 94, 14);
		frame.getContentPane().add(lblNameDoc);
		
		JLabel lblDate = new JLabel("");
		lblDate.setBounds(357, 241, 94, 14);
		frame.getContentPane().add(lblDate);
		
		JLabel lblHeure = new JLabel("");
		lblHeure.setBounds(357, 266, 94, 14);
		frame.getContentPane().add(lblHeure);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(108, 325, 533, 177);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nom patient", "Pr\u00E9nom patient", "Mail", "Nom m\u00E9decin", "Date", "Heure"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		
		
		DbConnection Connect = new DbConnection();
		Connection cnx = Connect.dbConnection();
		String requete = "Select id from rdv";
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
				String requete = "Select * from rdv where id = '" + medic + "'";
				ResultSet result = Connect.Requete(cnx, requete);
				try {
					while(result.next()) {
						lblName.setText(result.getString("nom_patient"));
						lblLastName.setText(result.getString("prenom_patient"));
						lblMail.setText(result.getString("mail_patient"));
						lblNameDoc.setText(result.getString("nom_medecin"));
						lblDate.setText(result.getString("date"));
						lblHeure.setText(result.getString("heure"));
					}
					result.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
	}
}
