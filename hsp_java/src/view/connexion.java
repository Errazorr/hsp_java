package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.eclipse.swt.graphics.Image;

import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		connexion.setBounds(100, 100, 422, 402);
		connexion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		connexion.getContentPane().setLayout(null);
		
		txt_id = new JTextField();
		txt_id.setBounds(207, 123, 114, 20);
		connexion.getContentPane().add(txt_id);
		txt_id.setColumns(10);
		
		lblPassword = new JPasswordField();
		lblPassword.setBounds(207, 191, 114, 20);
		connexion.getContentPane().add(lblPassword);
		
		JButton btnConnexion = new JButton("Se connecter");
		btnConnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index.dispose();
				connexion window = new connexion();
				window.connexion.setVisible(true);
			}
		});
		btnConnexion.setBounds(111, 274, 127, 23);
		connexion.getContentPane().add(btnConnexion);
		
		JLabel label = new JLabel("Identifiant");
		java.awt.Image img = new ImageIcon(this.getClass().getResource("/face.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(89, 105, 166, 56);
		connexion.getContentPane().add(label);
		
		JLabel label2 = new JLabel("Mot de passe");
		java.awt.Image img1 = new ImageIcon(this.getClass().getResource("/padlock.png")).getImage();
		label2.setIcon(new ImageIcon(img1));
		label2.setBounds(89, 173, 166, 56);
		connexion.getContentPane().add(label2);
	}
}
