package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class connexion {

	private JFrame connexion;
	private JTextField txt_id;
	private JTextField txt_mdp;

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
		
		txt_mdp = new JTextField();
		txt_mdp.setColumns(10);
		txt_mdp.setBounds(181, 152, 96, 20);
		connexion.getContentPane().add(txt_mdp);
	}
}
