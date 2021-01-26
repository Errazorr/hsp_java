package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JPasswordField;

public class modifyMedic {

	private JFrame Modify;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					modifyMedic window = new modifyMedic();
					window.Modify.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public modifyMedic() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Modify = new JFrame();
		Modify.setTitle("Modifier m\u00E9dicament");
		Modify.setBounds(100, 100, 714, 417);
		Modify.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Modify.getContentPane().setLayout(null);
	}
}
