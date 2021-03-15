package manager;

import javahsp.javamail.*;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Date;

import global_variable.*;
import javax.swing.*;
import com.toedter.calendar.JCalendar;

import db_connexion.DbConnection;
import view.addRDV;
import view.index;
import view.rdv;

public class methods extends global{
	
	//CONNEXION A LA BDD
	DbConnection Connect = new DbConnection();
    Connection cnx = Connect.dbConnection();
	
    //METHODE POUR SE CONNECTER
	public void se_connecter(String txt_id, String password, JLabel lblError, JFrame connexion_page) {
		String requete = "Select * from compte where mail='" + txt_id + "' and mdp='" + password + "'";
		ResultSet result = Connect.Requete(cnx, requete);
		
		try {
			while(result.next()) { // va parcourir chaque ligne du result
				//System.out.println("Connecté !");
				
				requete = "Select id from compte where mail='" + txt_id + "'";
				ResultSet result_id = Connect.Requete(cnx, requete);
				while(result_id.next()) {
					id = result_id.getInt(1);
					result_id.close();
					connexion_page.dispose();
					index window = new index();
					window.index.setVisible(true);
					result.close();
				}
			}
			
			lblError.setText("Mail ou mot de passe incorrect");
		} 
		catch (Exception ex) {
			//System.out.println(ex);
		}
	}
	
	
	//METHODE POUR AJOUTER UN MEDICAMENT DANS LA BDD
	public void ajouter_medic(String name, JLabel lblError, String supplier, String qty, String dangers) {
		String requete = "Select * from stock where nom='" + name + "'";
		ResultSet result = Connect.Requete(cnx, requete);
		try {
			while(result.next()) {
				lblError.setForeground(Color.RED);
				lblError.setText("Ce médicament est déjà enregistré");
				return;
			}
			requete = "INSERT INTO stock(nom, fabricant, qte, danger) VALUES('" + name + "', '" 
					+ supplier  + "', '" + qty  + "', '" + dangers + "')";
			Connect.Requete_prepare(cnx, requete);
			lblError.setForeground(Color.GREEN);
			lblError.setText("Médicament bien enregistré");

		}
		catch (Exception ex) {

		}
	}
	
	//METHODE POUR AJOUTE UN PROFIL
	public void ajouter_profil(String Name, JLabel lblError, String nom, String nom_famille, String mail, String phone, String mutuelle, String secu, JFrame frame) {
		String requete = "Select * from patient where mail='" + mail + "'";
		ResultSet result = Connect.Requete(cnx, requete);
		try {
			while(result.next()) {
				lblError.setText("Ce compte existe déjà.");
				return;
			}
			requete = "INSERT INTO patient(nom, prenom, mail, tel, mutuelle, secu) VALUES('" + nom + "', '" 
					+ nom_famille  + "', '" + mail  + "', '" + phone  + "', '" + mutuelle + "', '" + secu + "')";
			Connect.Requete_prepare(cnx, requete);
			
			JavaMail Mail = new JavaMail();
			Mail.send_mail(mail);
			frame.dispose();
			addRDV window = new addRDV();
			window.add_rdv.setVisible(true);

		}
		catch (Exception ex) {

		}
	}
	
	
	//METHODE POUR AJOUTER UN RDV
	public void ajouter_rdv(Date date, JLabel lblError, String name, String lastname, String mail, String medic, String heure, JFrame add_rdv) {
		String requete = "Select date from rdv where date='" + date + "'";
		ResultSet result = Connect.Requete(cnx, requete);
		try {
			while(result.next()) {
				lblError.setText("Le rendez-vous existe déjà!");
				return;
			}
			requete = "INSERT INTO rdv(nom_patient, prenom_patient, mail_patient, nom_medecin, date, heure) VALUES('" + name + "', '" 
					+ lastname  + "', '" + mail  + "', '" + medic  + "', '" + date + "',"
							+ "'" + heure  + "')";
			Connect.Requete_prepare(cnx, requete);
			
			JOptionPane.showMessageDialog(null, "Le rendez-vous est confirmé!");
			
			add_rdv.dispose();
			rdv window = new rdv();
			window.Rdv.setVisible(true);

		}
		catch (Exception ex) {

		}
	}
}
