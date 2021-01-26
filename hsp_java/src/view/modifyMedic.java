package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class modifyMedic {

	private JFrame Modify;
	private JTextField textField;

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
		Modify.setBounds(100, 100, 310, 200);
		Modify.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Modify.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("Nom du m\u00E9dicament \u00E0 modifier");
		lblName.setBounds(40, 40, 200, 14);
		Modify.getContentPane().add(lblName);
		
		textField = new JTextField();
		textField.setBounds(40, 65, 200, 20);
		Modify.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnChoix = new JButton("Modifier");
		btnChoix.setBounds(100, 115, 89, 23);
		Modify.getContentPane().add(btnChoix);
	}
}
