package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class modifyChosenMedic {

	private JFrame ModifyChosen;
	private JTextField txtName;
	private JTextField txtFabriquant;
	private JTextField txtQty;

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
		ModifyChosen.setBounds(100, 100, 338, 306);
		ModifyChosen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ModifyChosen.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("Nom");
		lblName.setBounds(63, 58, 54, 14);
		ModifyChosen.getContentPane().add(lblName);
		
		JLabel lblFabriquant = new JLabel("Fabriquant");
		lblFabriquant.setBounds(32, 100, 85, 14);
		ModifyChosen.getContentPane().add(lblFabriquant);
		
		JLabel lblQty = new JLabel("Quantit\u00E9");
		lblQty.setBounds(43, 141, 74, 14);
		ModifyChosen.getContentPane().add(lblQty);
		
		JLabel lblLots = new JLabel("Lots de 50");
		lblLots.setBounds(228, 141, 70, 14);
		ModifyChosen.getContentPane().add(lblLots);
		
		JLabel lblDangers = new JLabel("Dangers potentiels");
		lblDangers.setBounds(32, 178, 154, 14);
		ModifyChosen.getContentPane().add(lblDangers);
		
		txtName = new JTextField();
		txtName.setBounds(110, 55, 96, 20);
		ModifyChosen.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtFabriquant = new JTextField();
		txtFabriquant.setColumns(10);
		txtFabriquant.setBounds(110, 94, 96, 20);
		ModifyChosen.getContentPane().add(txtFabriquant);
		
		txtQty = new JTextField();
		txtQty.setColumns(10);
		txtQty.setBounds(110, 135, 96, 20);
		ModifyChosen.getContentPane().add(txtQty);
		
		JTextArea txtDangers = new JTextArea();
		txtDangers.setBounds(32, 203, 240, 22);
		ModifyChosen.getContentPane().add(txtDangers);
	}
}
