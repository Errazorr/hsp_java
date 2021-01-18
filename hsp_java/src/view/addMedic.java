package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class addMedic {

	private JFrame frmAjouterUnMdicament;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addMedic window = new addMedic();
					window.frmAjouterUnMdicament.setVisible(true);
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
		frmAjouterUnMdicament = new JFrame();
		frmAjouterUnMdicament.setTitle("Ajouter un m\u00E9dicament");
		frmAjouterUnMdicament.setBounds(100, 100, 338, 306);
		frmAjouterUnMdicament.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAjouterUnMdicament.getContentPane().setLayout(null);
		
		JLabel lblMedicName = new JLabel("Nom");
		lblMedicName.setBounds(63, 58, 23, 14);
		frmAjouterUnMdicament.getContentPane().add(lblMedicName);
		
		JLabel lblSupplier = new JLabel("Fabriquant");
		lblSupplier.setBounds(32, 100, 70, 14);
		frmAjouterUnMdicament.getContentPane().add(lblSupplier);
		
		JLabel lblQuantity = new JLabel("Quantit\u00E9");
		lblQuantity.setBounds(43, 141, 49, 14);
		frmAjouterUnMdicament.getContentPane().add(lblQuantity);
		
		JLabel lblPack = new JLabel("Lots de 50");
		lblPack.setBounds(197, 141, 70, 14);
		frmAjouterUnMdicament.getContentPane().add(lblPack);
		
		JLabel lblPotentialDangers = new JLabel("Dangers potentiels");
		lblPotentialDangers.setBounds(32, 178, 96, 14);
		frmAjouterUnMdicament.getContentPane().add(lblPotentialDangers);
		
		textField = new JTextField();
		textField.setBounds(91, 55, 96, 20);
		frmAjouterUnMdicament.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(91, 94, 96, 20);
		frmAjouterUnMdicament.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(91, 135, 96, 20);
		frmAjouterUnMdicament.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(32, 199, 235, 20);
		frmAjouterUnMdicament.getContentPane().add(textField_3);
	}
}
