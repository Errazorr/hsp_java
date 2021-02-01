package view;

import global_variable.*;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class index extends global{

	public JFrame index;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					index window = new index();
					window.index.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println(id);
			}
		});
	}

	/**
	 * Create the application.
	 */
	public index() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		index = new JFrame();
		/*index.setBackground(new Color(0, 0, 139));
		index.getContentPane().setBackground(new Color(192, 192, 192));*/
		index.setTitle("Index");
		index.setBounds(100, 100, 320, 250);
		index.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		index.getContentPane().setLayout(null);
		
		JButton btn_stock = new JButton("Stock");
		//btn_stock.setBackground(new Color(0, 255, 127));
		btn_stock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index.dispose();
				connexion window = new connexion();
				window.connexion.setVisible(true);
			}
		});
		btn_stock.setBounds(79, 56, 136, 23);
		index.getContentPane().add(btn_stock);
		
		JButton btn_rdv = new JButton("Rendez-vous");
		//btn_rdv.setBackground(new Color(255, 215, 0));
		btn_rdv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*index.dispose();
				connexion window = new connexion();
				window.connexion.setVisible(true);*/
			}
		});
		btn_rdv.setBounds(79, 135, 136, 23);
		index.getContentPane().add(btn_rdv);
		
		
	}

	public static void dispose() {
		// TODO Auto-generated method stub
		
	}
}
