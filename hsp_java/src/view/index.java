package view;

import global_variable.*;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;

import db_connexion.DbConnection;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;

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
		index.setBounds(100, 100, 320, 250);
		index.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		index.getContentPane().setLayout(null);
		
		JLabel lblError1 = new JLabel("");
		lblError1.setForeground(Color.RED);
		lblError1.setBounds(79, 31, 136, 14);
		index.getContentPane().add(lblError1);
		
		JLabel lblError2 = new JLabel("");
		lblError2.setForeground(Color.RED);
		lblError2.setBounds(79, 110, 136, 14);
		index.getContentPane().add(lblError2);
		
		DbConnection Connect = new DbConnection();
	    Connection cnx = Connect.dbConnection();
		System.out.println(Connect.dbConnection());
		
		JButton btn_stock = new JButton("Stock");
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

					lblError1.setText("Acc�s au stock refus�");
				}
				catch (Exception ex) {
					
				}
			}
		});
		btn_stock.setBounds(79, 56, 136, 23);
		index.getContentPane().add(btn_stock);
		
		JButton btn_rdv = new JButton("Rendez-vous");
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
					lblError2.setText("Acc�s aux rdv refus�");
				}
				catch (Exception ex) {
					
				}
			}
		});
		btn_rdv.setBounds(79, 135, 136, 23);
		index.getContentPane().add(btn_rdv);
		
		
	}

	public static void dispose() {
		// TODO Auto-generated method stub
		
	}
}
