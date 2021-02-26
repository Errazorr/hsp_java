package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.Toolkit;

public class rdv {

	JFrame Rdv;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					rdv window = new rdv();
					window.Rdv.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public rdv() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Rdv = new JFrame();
		Rdv.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\FONTAINE_Ry\\Downloads\\face.png"));
		Rdv.getContentPane().setBackground(Color.GRAY);
		Rdv.setBounds(100, 100, 450, 300);
		Rdv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Rdv.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("RDV");
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(57, 174, 89, 23);
		Rdv.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Patient");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Rdv.dispose();
				addProfil window = new addProfil();
				window.frame.setVisible(true);
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.setBounds(57, 140, 89, 23);
		Rdv.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("M\u00E9decins");
		btnNewButton_2.setBackground(Color.DARK_GRAY);
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBounds(57, 106, 89, 23);
		Rdv.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Add");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Rdv.dispose();
					addRDV window = new addRDV();
					window.frame.setVisible(true);
				}

			catch (Exception ex) {

			}
			}
		});
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBackground(Color.DARK_GRAY);
		btnNewButton_3.setBounds(57, 72, 89, 23);
		Rdv.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Profil");
		btnNewButton_4.setBounds(57, 229, 89, 23);
		Rdv.getContentPane().add(btnNewButton_4);
		
		JLabel lblNewLabel = new JLabel("Espace Rendez-vous");
		lblNewLabel.setFont(new Font("Cambria Math", Font.PLAIN, 13));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(47, 47, 139, 14);
		Rdv.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(": prendre un rendez-vous");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(156, 76, 159, 14);
		Rdv.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(": voir les disponibilit\u00E9s m\u00E9decins");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(156, 110, 230, 14);
		Rdv.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(": cr\u00E9er un profil pour patient");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(156, 144, 212, 14);
		Rdv.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel(": afficher les rendez-vous");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(156, 178, 159, 14);
		Rdv.getContentPane().add(lblNewLabel_4);
		
		JButton btnNewButton_5 = new JButton("Retour");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Rdv.dispose();
				index window = new index();
				window.index.setVisible(true);
			}
		});
		btnNewButton_5.setForeground(Color.RED);
		btnNewButton_5.setBackground(UIManager.getColor("ToolBar.dockingForeground"));
		btnNewButton_5.setBounds(302, 229, 107, 23);
		Rdv.getContentPane().add(btnNewButton_5);
	}

}
