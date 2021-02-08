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

public class stock {

	JFrame Stock;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					stock window = new stock();
					window.Stock.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		Stock.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\FONTAINE_Ry\\Pictures\\zIb0C.jpg"));
		Stock.setTitle("Stock");
		Stock.setBounds(100, 100, 515, 423);
		Stock.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Stock.getContentPane().setLayout(null);
		
		JButton btnAdd = new JButton("Ajouter");
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setBackground(Color.DARK_GRAY);
		btnAdd.setBounds(225, 145, 115, 23);
		Stock.getContentPane().add(btnAdd);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setBackground(Color.DARK_GRAY);
		btnModifier.setForeground(Color.WHITE);
		btnModifier.setBounds(225, 188, 115, 23);
		Stock.getContentPane().add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBackground(Color.RED);
		btnSupprimer.setForeground(Color.WHITE);
		btnSupprimer.setBounds(225, 245, 115, 23);
		Stock.getContentPane().add(btnSupprimer);
		
		JButton btnAfficher = new JButton("Afficher");
		btnAfficher.setBackground(Color.DARK_GRAY);
		btnAfficher.setForeground(Color.WHITE);
		btnAfficher.setBounds(52, 145, 115, 23);
		Stock.getContentPane().add(btnAfficher);
		
		JButton btnCommander = new JButton("Commander");
		btnCommander.setBackground(Color.DARK_GRAY);
		btnCommander.setForeground(Color.WHITE);
		btnCommander.setBounds(52, 188, 115, 23);
		Stock.getContentPane().add(btnCommander);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBackground(Color.DARK_GRAY);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\FONTAINE_Ry\\Pictures\\pexels-photo-2310713.jpeg"));
		lblNewLabel.setBounds(0, 0, 509, 398);
		Stock.getContentPane().add(lblNewLabel);
	}
}
