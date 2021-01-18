package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JPasswordField;

public class modifyMedic {

	private JFrame frmModifierMdicament;
	private JTable tableModifyMedic;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					modifyMedic window = new modifyMedic();
					window.frmModifierMdicament.setVisible(true);
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
		frmModifierMdicament = new JFrame();
		frmModifierMdicament.setTitle("Modifier m\u00E9dicament");
		frmModifierMdicament.setBounds(100, 100, 714, 417);
		frmModifierMdicament.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmModifierMdicament.getContentPane().setLayout(null);
		
		tableModifyMedic = new JTable();
		tableModifyMedic.setBounds(25, 28, 646, 341);
		frmModifierMdicament.getContentPane().add(tableModifyMedic);
	}
}
