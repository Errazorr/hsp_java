package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class modifyChosenMedic {

	private JFrame ModifyChosen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					modifyChosenMedic window = new modifyChosenMedic();
					window.ModifyChosen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public modifyChosenMedic() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ModifyChosen = new JFrame();
		ModifyChosen.setTitle("Modifier m\u00E9dicament");
		ModifyChosen.setBounds(100, 100, 630, 420);
		ModifyChosen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ModifyChosen.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("New label");
		lblName.setBounds(33, 27, 49, 14);
		ModifyChosen.getContentPane().add(lblName);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(33, 75, 49, 14);
		ModifyChosen.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(33, 122, 49, 14);
		ModifyChosen.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(266, 122, 49, 14);
		ModifyChosen.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(33, 184, 49, 14);
		ModifyChosen.getContentPane().add(lblNewLabel_4);
	}
}
