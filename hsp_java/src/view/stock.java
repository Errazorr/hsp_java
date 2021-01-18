package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;

public class stock {

	private JFrame frmStock;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					stock window = new stock();
					window.frmStock.setVisible(true);
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
		frmStock = new JFrame();
		frmStock.setTitle("Stock");
		frmStock.setBounds(100, 100, 220, 340);
		frmStock.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStock.getContentPane().setLayout(null);
		
		JButton btnAdd = new JButton("Ajouter");
		btnAdd.setBounds(40, 25, 115, 23);
		frmStock.getContentPane().add(btnAdd);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setBounds(40, 76, 115, 23);
		frmStock.getContentPane().add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(40, 122, 115, 23);
		frmStock.getContentPane().add(btnSupprimer);
		
		JButton btnAfficher = new JButton("Afficher");
		btnAfficher.setBounds(40, 174, 115, 23);
		frmStock.getContentPane().add(btnAfficher);
		
		JButton btnCommander = new JButton("Commander");
		btnCommander.setBounds(40, 224, 115, 23);
		frmStock.getContentPane().add(btnCommander);
	}
}
