package view;

import global_variable.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

import db_connexion.DbConnection;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class index extends global{

	public JFrame index;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					index window = new index();
					window.index.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public index() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		index = new JFrame();
		/*index.setBackground(new Color(0, 0, 139));
		index.getContentPane().setBackground(new Color(192, 192, 192));*/
		index.setTitle("Index");
		index.setBounds(100, 100, 766, 543);
		index.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		index.getContentPane().setLayout(null);
		
		DbConnection Connect = new DbConnection();
	    Connection cnx = Connect.dbConnection();
		System.out.println(Connect.dbConnection());
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 191, 255));
		panel.setBounds(369, 0, 381, 504);
		index.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btn_rdv = new JButton("Rendez-vous");
		btn_rdv.setBackground(new Color(0, 191, 255));
		btn_rdv.setForeground(Color.WHITE);
		btn_rdv.setBounds(134, 234, 136, 23);
		panel.add(btn_rdv);
		
		JLabel lblError2 = new JLabel("");
		lblError2.setBounds(134, 204, 136, 14);
		panel.add(lblError2);
		lblError2.setForeground(Color.RED);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Ryan\\Pictures\\work.jpg"));
		lblNewLabel_1.setBounds(0, 0, 381, 504);
		panel.add(lblNewLabel_1);
		//btn_rdv.setBackground(new Color(255, 215, 0));
		btn_rdv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String requete = "Select * from compte where id='" + id + "' and acces_rdv= '1'";
				ResultSet result = Connect.Requete(cnx, requete);
				try {
					while(result.next()) {
						index.dispose();
						rdv window = new rdv();
						window.Rdv.setVisible(true);
					}
					lblError2.setText("Accès aux rdv refusé");
				}
				catch (Exception ex) {
					
				}
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, 370, 504);
		index.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btn_stock = new JButton("Stock");
		btn_stock.setForeground(Color.WHITE);
		btn_stock.setBackground(Color.ORANGE);
		btn_stock.setBounds(102, 231, 136, 23);
		panel_1.add(btn_stock);
		
		JLabel lblError1 = new JLabel("");
		lblError1.setBounds(102, 204, 136, 14);
		panel_1.add(lblError1);
		lblError1.setForeground(Color.RED);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Ryan\\Downloads\\stock$.jpg"));
		lblNewLabel.setBounds(0, 0, 370, 504);
		panel_1.add(lblNewLabel);
		//btn_stock.setBackground(new Color(0, 255, 127));
		btn_stock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String requete = "Select * from compte where id='" + id + "' and acces_stock= '1'";
				ResultSet result = Connect.Requete(cnx, requete);
				try {
					while(result.next()) {
						index.dispose();
						stock window = new stock();
						window.Stock.setVisible(true);
					}

					lblError1.setText("Accès au stock refusé");
				}
				catch (Exception ex) {
					
				}
			}
		});
		
		
	}

	public static void dispose() {
		// TODO Auto-generated method stub
		
	}
}
