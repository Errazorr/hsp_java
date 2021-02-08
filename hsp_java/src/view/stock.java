package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;

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
		Stock.setTitle("Stock");
		Stock.setBounds(100, 100, 220, 340);
		Stock.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Stock.getContentPane().setLayout(null);
		
		JButton btnAdd = new JButton("Ajouter");
		btnAdd.setBounds(40, 25, 115, 23);
		Stock.getContentPane().add(btnAdd);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setBounds(40, 76, 115, 23);
		Stock.getContentPane().add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(40, 122, 115, 23);
		Stock.getContentPane().add(btnSupprimer);
		
		JButton btnAfficher = new JButton("Afficher");
		btnAfficher.setBounds(40, 174, 115, 23);
		Stock.getContentPane().add(btnAfficher);
		
		JButton btnCommander = new JButton("Commander");
		btnCommander.setBounds(40, 224, 115, 23);
		Stock.getContentPane().add(btnCommander);
	}
}
