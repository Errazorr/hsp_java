package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;

public class index {

	private JFrame index;

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
		index.setTitle("Index");
		index.setBounds(100, 100, 320, 250);
		index.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		index.getContentPane().setLayout(null);
		
		JButton btn_stock = new JButton("Stock");
		btn_stock.setBounds(79, 56, 136, 23);
		index.getContentPane().add(btn_stock);
		
		JButton btn_rdv = new JButton("Rendez-vous");
		btn_rdv.setBounds(79, 135, 136, 23);
		index.getContentPane().add(btn_rdv);
	}
}
