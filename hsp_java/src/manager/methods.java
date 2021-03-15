package manager;

import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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
				//System.out.println("Connect� !");
				
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
				lblError.setText("Ce m�dicament est d�j� enregistr�");
				return;
			}
			requete = "INSERT INTO stock(nom, fabricant, qte, danger) VALUES('" + name + "', '" 
					+ supplier  + "', '" + qty  + "', '" + dangers + "')";
			Connect.Requete_prepare(cnx, requete);
			lblError.setForeground(Color.GREEN);
			lblError.setText("M�dicament bien enregistr�");

		}
		catch (Exception ex) {

		}
	}
	
	//METHODE POUR AJOUTE UN PROFIL
	public void ajouter_profil(String Name, JLabel lblError, String nom, String nom_famille, String mail, String phone, String mutuelle, String secu, JFrame frame) {
		String requete = "Select * from patient where nom='" + Name + "'";
		ResultSet result = Connect.Requete(cnx, requete);
		try {
			while(result.next()) {
				lblError.setText("Ce compte existe d�j�.");
				return;
			}
			requete = "INSERT INTO patient(nom, prenom, mail, tel, mutuelle, secu) VALUES('" + nom + "', '" 
					+ nom_famille  + "', '" + mail  + "', '" + phone  + "', '" + mutuelle + "', '" + secu + "')";
			Connect.Requete_prepare(cnx, requete);
			
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
				lblError.setText("Le rendez-vous existe d�j�!");
				return;
			}
			requete = "INSERT INTO rdv(nom_patient, prenom_patient, mail_patient, nom_medecin, date, heure) VALUES('" + name + "', '" 
					+ lastname  + "', '" + mail  + "', '" + medic  + "', '" + date + "',"
							+ "'" + heure  + "')";
			Connect.Requete_prepare(cnx, requete);
			
			JOptionPane.showMessageDialog(null, "Le rendez-vous est confirm�!");
			
			add_rdv.dispose();
			rdv window = new rdv();
			window.Rdv.setVisible(true);

		}
		catch (Exception ex) {

		}
	}
	
	
	//METHODE DE CONFIRMATION DE SUPPRESSION D'UN MEDICAMENT
	public void confirm_delete(boolean success, JLabel lblSuccess) {
		String requete = "Delete from stock where nom='" + medic + "'";
		success = Connect.Requete_prepare(cnx, requete);
		
		if (success == true) {
			lblSuccess.setForeground(Color.GREEN);
			lblSuccess.setText("M�dicament supprim� avec succ�s");
		}
		else {
			lblSuccess.setForeground(Color.RED);
			lblSuccess.setText("Suppression �chou�e");
		}
	}
	
	
	
	public void disp_medic(String medic, JLabel name, JLabel manuf, JLabel qty, JLabel dangers) {
		String requete = "Select * from stock where nom = '" + medic + "'";
		ResultSet result = Connect.Requete(cnx, requete);
		try {
			while(result.next()) {
				name.setText(result.getString("nom"));
				manuf.setText(result.getString("fabricant"));
				qty.setText(result.getString("qte"));
				dangers.setText(result.getString("danger"));
			}
			result.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}
