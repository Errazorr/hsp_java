package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class connexion {

	JFrame connexion;
	private JTextField txt_id;
	private JPasswordField lblPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					connexion window = new connexion();
					window.connexion.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public connexion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		connexion = new JFrame();
		connexion.setTitle("Connexion");
		connexion.setBounds(100, 100, 319, 285);
		connexion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		connexion.getContentPane().setLayout(null);
		
		JLabel lbl_id = new JLabel("Identifiant");
		lbl_id.setBounds(31, 76, 102, 14);
		connexion.getContentPane().add(lbl_id);
		
		JLabel lbl_mdp = new JLabel("Mot de passe");
		lbl_mdp.setBounds(31, 155, 102, 14);
		connexion.getContentPane().add(lbl_mdp);
		
		txt_id = new JTextField();
		txt_id.setBounds(181, 73, 96, 20);
		connexion.getContentPane().add(txt_id);
		txt_id.setColumns(10);
		
		lblPassword = new JPasswordField();
		lblPassword.setBounds(181, 152, 96, 17);
		connexion.getContentPane().add(lblPassword);
		
		JButton btnConnexion = new JButton("Se connecter");
		btnConnexion.setBounds(86, 200, 127, 23);
		connexion.getContentPane().add(btnConnexion);
	}
}
