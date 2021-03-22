package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.Font;
import javax.swing.JSeparator;

public class stock {

	public JFrame Stock;



	/**
	 * Create the application.
	 */
	public stock() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Stock = new JFrame();
		Stock.getContentPane().setBackground(Color.DARK_GRAY);
		Stock.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\GONCALVES_Na\\Pictures\\zIb0C.jpg"));
		Stock.setTitle("Stock");
		Stock.setBounds(100, 100, 766, 543);
		Stock.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Stock.getContentPane().setLayout(null);
		
		JButton btnAdd = new JButton("Ajouter");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
						Stock.dispose();
						addMedic window = new addMedic();
						window.Add.setVisible(true);
					}

				catch (Exception ex) {

				}
			}
		});
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setBackground(new Color(153, 51, 255));
		btnAdd.setBounds(520, 97, 115, 23);
		Stock.getContentPane().add(btnAdd);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
						Stock.dispose();
						modifyMedic window = new modifyMedic();
						window.Modify.setVisible(true);
					}

				catch (Exception ex) {

				}
			}
		});
		btnModifier.setBackground(new Color(153, 51, 255));
		btnModifier.setForeground(Color.WHITE);
		btnModifier.setBounds(520, 177, 115, 23);
		Stock.getContentPane().add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
						Stock.dispose();
						deleteMedic window = new deleteMedic();
						window.Delete.setVisible(true);
					}

				catch (Exception ex) {

				}
			}
		});
		btnSupprimer.setBackground(new Color(153, 51, 255));
		btnSupprimer.setForeground(Color.WHITE);
		btnSupprimer.setBounds(520, 334, 115, 23);
		Stock.getContentPane().add(btnSupprimer);
		
		JButton btnBack = new JButton("Retour");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
						Stock.dispose();
						index window = new index();
						window.index.setVisible(true);
					}

				catch (Exception ex) {

				}
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setBackground(Color.RED);
		btnBack.setBounds(133, 455, 115, 23);
		Stock.getContentPane().add(btnBack);
		
		JButton btnAfficher = new JButton("Afficher");
		btnAfficher.setBackground(new Color(153, 51, 255));
		btnAfficher.setForeground(Color.WHITE);
		btnAfficher.setBounds(520, 412, 115, 23);
		Stock.getContentPane().add(btnAfficher);
		btnAfficher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
						Stock.dispose();
						displayMedic window = new displayMedic();
						window.Display.setVisible(true);
					}

				catch (Exception ex) {

				}
			}
		});
		
		JButton btnCommander = new JButton("Commander");
		btnCommander.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
						Stock.dispose();
						orderMedic window = new orderMedic();
						window.order.setVisible(true);
					}

				catch (Exception ex) {

				}
			}
		});
		btnCommander.setBackground(new Color(153, 51, 255));
		btnCommander.setForeground(Color.WHITE);
		btnCommander.setBounds(520, 256, 115, 23);
		Stock.getContentPane().add(btnCommander);
		
		JLabel lblNewLabel_1 = new JLabel("Stock");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Vladimir Script", Font.PLAIN, 63));
		lblNewLabel_1.setBounds(133, 145, 181, 189);
		Stock.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		String chemin = "1.jpg";
		String resource = getClass().getClassLoader().getResource(chemin).getPath();
		lblNewLabel.setIcon(new ImageIcon(resource));
		lblNewLabel.setBounds(0, -27, 391, 564);
		Stock.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Ajouter un m\u00E9dicament :");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(500, 64, 212, 34);
		Stock.getContentPane().add(lblNewLabel_2);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setBounds(450, 131, 262, 2);
		Stock.getContentPane().add(separator);
		
		JLabel lblNewLabel_2_1 = new JLabel("Modifier un m\u00E9dicament :");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(500, 145, 212, 34);
		Stock.getContentPane().add(lblNewLabel_2_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.WHITE);
		separator_1.setBounds(450, 211, 262, 2);
		Stock.getContentPane().add(separator_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Commander un m\u00E9dicament :\r\n");
		lblNewLabel_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		lblNewLabel_2_1_1.setBounds(485, 224, 212, 34);
		Stock.getContentPane().add(lblNewLabel_2_1_1);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setForeground(Color.WHITE);
		separator_1_1.setBounds(450, 290, 262, 2);
		Stock.getContentPane().add(separator_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Supprimer un m\u00E9dicament :");
		lblNewLabel_2_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1_1.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		lblNewLabel_2_1_1_1.setBounds(485, 300, 212, 34);
		Stock.getContentPane().add(lblNewLabel_2_1_1_1);
		
		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setForeground(Color.WHITE);
		separator_1_1_1.setBounds(450, 368, 262, 2);
		Stock.getContentPane().add(separator_1_1_1);
		
		JLabel lblNewLabel_2_1_1_2 = new JLabel("Afficher un m\u00E9dicament :");
		lblNewLabel_2_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_2_1_1_2.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		lblNewLabel_2_1_1_2.setBounds(500, 381, 197, 34);
		Stock.getContentPane().add(lblNewLabel_2_1_1_2);
		
		
		
	}
}
