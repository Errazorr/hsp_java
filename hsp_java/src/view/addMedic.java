package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class addMedic {

	private JFrame Add;
	private JTextField textName;
	private JTextField textSupplier;
	private JTextField textQuantity;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addMedic window = new addMedic();
					window.Add.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public addMedic() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Add = new JFrame();
		Add.setTitle("Ajouter un m\u00E9dicament");
		Add.setBounds(100, 100, 338, 306);
		Add.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Add.getContentPane().setLayout(null);
		
		JLabel lblMedicName = new JLabel("Nom");
		lblMedicName.setBounds(63, 58, 54, 14);
		Add.getContentPane().add(lblMedicName);
		
		JLabel lblSupplier = new JLabel("Fabriquant");
		lblSupplier.setBounds(32, 100, 85, 14);
		Add.getContentPane().add(lblSupplier);
		
		JLabel lblQuantity = new JLabel("Quantit\u00E9");
		lblQuantity.setBounds(43, 141, 74, 14);
		Add.getContentPane().add(lblQuantity);
		
		JLabel lblPack = new JLabel("Lots de 50");
		lblPack.setBounds(228, 141, 70, 14);
		Add.getContentPane().add(lblPack);
		
		JLabel lblPotentialDangers = new JLabel("Dangers potentiels");
		lblPotentialDangers.setBounds(32, 178, 154, 14);
		Add.getContentPane().add(lblPotentialDangers);
		
		textName = new JTextField();
		textName.setBounds(110, 55, 96, 20);
		Add.getContentPane().add(textName);
		textName.setColumns(10);
		
		textSupplier = new JTextField();
		textSupplier.setColumns(10);
		textSupplier.setBounds(110, 94, 96, 20);
		Add.getContentPane().add(textSupplier);
		
		textQuantity = new JTextField();
		textQuantity.setColumns(10);
		textQuantity.setBounds(110, 135, 96, 20);
		Add.getContentPane().add(textQuantity);
		
		JTextArea textPotentialDangers = new JTextArea();
		textPotentialDangers.setBounds(28, 205, 239, 53);
		Add.getContentPane().add(textPotentialDangers);
	}
}
