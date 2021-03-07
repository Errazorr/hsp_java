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
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import com.toedter.calendar.JCalendar;

import db_connexion.DbConnection;

import javax.swing.ImageIcon;
import java.awt.Font;

public class addRDV {

	JFrame frame;
	private JTextField txtName;
	private JTextField txtLastName;
	private JTextField txtMail;

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
		panel.setBounds(0, 0, 426, 502);
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
		
		JButton btnBack = new JButton("Retour");
		btnBack.setBackground(Color.RED);
		btnBack.setBounds(156, 11, 89, 23);
		panel.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				rdv window = new rdv();
				window.Rdv.setVisible(true);
			}
		});
		btnBack.setForeground(Color.WHITE);
		
		JLabel lblError = new JLabel("");
		lblError.setBounds(180, 418, 49, 14);
		panel.add(lblError);
		
		JButton btnNewButton_1 = new JButton("Ajouter un compte");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				addProfil window = new addProfil();
				window.frame.setVisible(true);
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.BLUE);
		btnNewButton_1.setBounds(131, 428, 158, 32);
		panel.add(btnNewButton_1);
		
		txtName = new JTextField();
		txtName.setBounds(549, 36, 283, 27);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nom");
		lblNewLabel.setBounds(549, 11, 49, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Pr\u00E9nom");
		lblNewLabel_1.setBounds(549, 74, 49, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		txtLastName = new JTextField();
		txtLastName.setColumns(10);
		txtLastName.setBounds(549, 93, 283, 27);
		frame.getContentPane().add(txtLastName);
		
		JLabel lblMdecin = new JLabel("M\u00E9decin\r\n");
		lblMdecin.setBounds(549, 190, 49, 14);
		frame.getContentPane().add(lblMdecin);
		
		JLabel lblNewLabel_2_1 = new JLabel("Date");
		lblNewLabel_2_1.setBounds(549, 248, 49, 14);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JComboBox cbMed = new JComboBox();
		
		DbConnection Connect = new DbConnection();
		Connection cnx = Connect.dbConnection();
		String requete = "Select nom from medecin";
		ResultSet result = Connect.Requete(cnx, requete);

		try {
			while(result.next()) {
				cbMed.addItem(result.getString(1).trim());
			}
			result.close();
		}
		catch (Exception ex) {System.out.println(ex);}
		
		cbMed.setBounds(549, 215, 283, 22);
		frame.getContentPane().add(cbMed);
		
		JCalendar date = new JCalendar();
		date.setBounds(585, 262, 205, 121);
		frame.getContentPane().add(date);
		
		JLabel lblHeure = new JLabel("Heure");
		lblHeure.setBounds(549, 384, 49, 14);
		frame.getContentPane().add(lblHeure);
		
		
		JLabel lblNewLabel_1_1 = new JLabel("Mail");
		lblNewLabel_1_1.setBounds(549, 131, 49, 14);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		txtMail = new JTextField();
		txtMail.setColumns(10);
		txtMail.setBounds(549, 152, 283, 27);
		frame.getContentPane().add(txtMail);
		
		JComboBox cbH = new JComboBox();
		cbH.setBounds(549, 409, 283, 22);
		frame.getContentPane().add(cbH);
		frame.setBackground(UIManager.getColor("ToggleButton.highlight"));
		frame.setBounds(100, 100, 936, 526);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		 requete = "Select time from horaire";
		 result = Connect.Requete(cnx, requete);

		try {
			while(result.next()) {
				cbH.addItem(result.getString(1).trim());
			}
			result.close();
		}
		catch (Exception ex) {System.out.println(ex);}
		
		
		
		JButton btnNewButton = new JButton("Valider");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String requete = "Select date from rdv where date='" + date.getDate() + "'";
				ResultSet result = Connect.Requete(cnx, requete);
				try {
					while(result.next()) {
						lblError.setText("Le rendez-vous existe déjà!");
					}
					requete = "INSERT INTO rdv(nom_patient, prenom_patient, mail_patient, nom_medecin, date, heure) VALUES('" + txtName.getText() + "', '" 
							+ txtLastName.getText()  + "', '" + txtMail.getText()  + "', '" + cbMed.getSelectedItem().toString()  + "', '" + date.getDate() + "',"
									+ "'" + cbH.getSelectedItem().toString()  + "')";
					Connect.Requete_prepare(cnx, requete);
					
					JOptionPane.showMessageDialog(null, "Le rendez-vous est confirmé!");
					
					frame.dispose();
					rdv window = new rdv();
					window.Rdv.setVisible(true);

				}
				catch (Exception ex) {

				}
			}
		});
		btnNewButton.setForeground(UIManager.getColor("Button.background"));
		btnNewButton.setBackground(new Color(241, 57, 83));
		btnNewButton.setBounds(549, 442, 283, 36);
		frame.getContentPane().add(btnNewButton);
		
		
	}
}
