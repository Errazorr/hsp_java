package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;

public class rdv {

	public JFrame Rdv;



	/**
	 * Create the application.
	 */
	public rdv() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Rdv = new JFrame();
		Rdv.getContentPane().setForeground(Color.WHITE);
		Rdv.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\GONCALVES_Na\\Downloads\\face.png"));
		Rdv.getContentPane().setBackground(Color.DARK_GRAY);
		Rdv.setBounds(100, 100, 766, 543);
		Rdv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Rdv.getContentPane().setLayout(null);
		
		
		JLabel lblNewLabel_1_1 = new JLabel("Rendez-vous");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Vladimir Script", Font.PLAIN, 63));
		lblNewLabel_1_1.setBounds(65, 143, 267, 189);
		Rdv.getContentPane().add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("Voir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Rdv.dispose();
				viewRDV window = new viewRDV();
				window.frame.setVisible(true);
			}
		});
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(548, 270, 89, 23);
		Rdv.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cr\u00E9er");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Rdv.dispose();
				addProfil window = new addProfil();
				window.add_profil.setVisible(true);
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.setBounds(548, 348, 89, 23);
		Rdv.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Voir");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Rdv.dispose();
				viewDoc window = new viewDoc();
				window.frame.setVisible(true);
			}
		});
		btnNewButton_2.setBackground(Color.BLACK);
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBounds(548, 106, 89, 23);
		Rdv.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Ajouter");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Rdv.dispose();
					addRDV window = new addRDV();
					window.add_rdv.setVisible(true);
				}

			catch (Exception ex) {

			}
			}
		});
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBackground(Color.BLACK);
		btnNewButton_3.setBounds(548, 192, 89, 23);
		Rdv.getContentPane().add(btnNewButton_3);
		
		JLabel lblNewLabel_1 = new JLabel("Prendre un rendez-vous :");
		lblNewLabel_1.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(511, 161, 209, 33);
		Rdv.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Médecins :");
		lblNewLabel_2.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(557, 82, 101, 23);
		Rdv.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Cr\u00E9er un profil pour patient :");
		lblNewLabel_3.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(499, 323, 209, 23);
		Rdv.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Afficher les rendez-vous :");
		lblNewLabel_4.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(511, 244, 184, 23);
		Rdv.getContentPane().add(lblNewLabel_4);
		
		JButton btnNewButton_5 = new JButton("Retour");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Rdv.dispose();
				index window = new index();
				window.index.setVisible(true);
			}
		});
		btnNewButton_5.setForeground(Color.WHITE);
		btnNewButton_5.setBackground(Color.RED);
		btnNewButton_5.setBounds(137, 443, 107, 23);
		Rdv.getContentPane().add(btnNewButton_5);
		
		JLabel lblNewLabel = new JLabel("New label");
		String chemin = "work.jpg";
		String resource = getClass().getClassLoader().getResource(chemin).getPath();
		lblNewLabel.setIcon(new ImageIcon(resource));
		lblNewLabel.setBounds(0, 0, 409, 504);
		Rdv.getContentPane().add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setBounds(474, 148, 249, 8);
		Rdv.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.WHITE);
		separator_1.setBounds(474, 226, 249, 8);
		Rdv.getContentPane().add(separator_1);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setForeground(Color.WHITE);
		separator_1_1.setBounds(474, 304, 249, 8);
		Rdv.getContentPane().add(separator_1_1);

	}
}
