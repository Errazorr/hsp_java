package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import com.toedter.calendar.JCalendar;
import javax.swing.ImageIcon;
import java.awt.Font;

public class addRDV {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addRDV window = new addRDV();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public addRDV() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(UIManager.getColor("ToggleButton.highlight"));
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 426, 487);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\FONTAINE_Ry\\Pictures\\rendez-vous.jpg"));
		lblNewLabel_2.setBounds(0, 0, 426, 336);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Prise de rendez-vous...");
		lblNewLabel_3.setBackground(UIManager.getColor("CheckBox.highlight"));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setForeground(new Color(240, 255, 240));
		lblNewLabel_3.setBounds(121, 373, 202, 59);
		panel.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Valider");
		btnNewButton.setForeground(UIManager.getColor("Button.background"));
		btnNewButton.setBackground(new Color(241, 57, 83));
		btnNewButton.setBounds(549, 425, 283, 36);
		frame.getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(549, 36, 283, 36);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nom");
		lblNewLabel.setBounds(549, 11, 49, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nom");
		lblNewLabel_1.setBounds(549, 83, 49, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(549, 105, 283, 36);
		frame.getContentPane().add(textField_1);
		
		JLabel lblMdecin = new JLabel("M\u00E9decin\r\n");
		lblMdecin.setBounds(549, 152, 49, 14);
		frame.getContentPane().add(lblMdecin);
		
		JLabel lblNewLabel_2_1 = new JLabel("Date");
		lblNewLabel_2_1.setBounds(549, 212, 49, 14);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(549, 177, 283, 22);
		frame.getContentPane().add(comboBox);
		
		JCalendar calendar = new JCalendar();
		calendar.setBounds(586, 229, 205, 121);
		frame.getContentPane().add(calendar);
		
		JLabel lblHeure = new JLabel("Heure");
		lblHeure.setBounds(549, 361, 49, 14);
		frame.getContentPane().add(lblHeure);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(549, 386, 283, 22);
		frame.getContentPane().add(comboBox_1);
		frame.setBackground(UIManager.getColor("ToggleButton.highlight"));
		frame.setBounds(100, 100, 933, 524);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
