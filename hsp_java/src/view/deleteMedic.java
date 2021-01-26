package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class deleteMedic {

	private JFrame Delete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deleteMedic window = new deleteMedic();
					window.Delete.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public deleteMedic() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Delete = new JFrame();
		Delete.setTitle("Supprimer m\u00E9dicament");
		Delete.setBounds(100, 100, 450, 300);
		Delete.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Delete.getContentPane().setLayout(null);
	}

}
