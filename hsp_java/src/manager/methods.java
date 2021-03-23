package manager;

import javahsp.javamail.*;
import net.proteanit.sql.DbUtils;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import global_variable.*;
import javax.swing.*;
import com.toedter.calendar.JCalendar;

import db_connexion.DbConnection;
import view.addRDV;
import view.index;
import view.rdv;
import view.stock;

public class methods extends global {

	// CONNEXION A LA BDD
	DbConnection Connect = new DbConnection();
	Connection cnx = Connect.dbConnection();

	// METHODE POUR SE CONNECTER
	public void se_connecter(String txt_id, String password, JLabel lblError, JFrame connexion_page) {
		String requete = "Select * from compte where mail='" + txt_id + "' and mdp='" + password + "'";
		ResultSet result = Connect.Requete(cnx, requete);

		try {
			while (result.next()) { // va parcourir chaque ligne du result
				// System.out.println("Connecté !");

				requete = "Select id from compte where mail='" + txt_id + "'";
				ResultSet result_id = Connect.Requete(cnx, requete);
				while (result_id.next()) {
					id = result_id.getInt(1);
					result_id.close();
					connexion_page.dispose();
					index window = new index();
					window.index.setVisible(true);
					result.close();
				}
			}

			lblError.setText("Mail ou mot de passe incorrect");
		} catch (Exception ex) {
			// System.out.println(ex);
		}
	}

	// METHODE POUR AJOUTER UN MEDICAMENT DANS LA BDD
	public void ajouter_medic(String name, JLabel lblError, String supplier, String qty, String dangers) {
		String requete = "Select * from stock where nom='" + name + "'";
		ResultSet result = Connect.Requete(cnx, requete);
		try {
			while (result.next()) {
				lblError.setForeground(Color.RED);
				lblError.setText("Ce médicament est déjà enregistré");
				return;
			}
			requete = "INSERT INTO stock(nom, fabricant, qte, danger) VALUES('" + name + "', '" + supplier + "', '"
					+ qty + "', '" + dangers + "')";
			Connect.Requete_prepare(cnx, requete);
			lblError.setForeground(Color.GREEN);
			lblError.setText("Médicament bien enregistré");

		} catch (Exception ex) {

		}
	}

	// METHODE POUR AJOUTE UN PROFIL
	public void ajouter_profil(String Name, JLabel lblError, String nom, String nom_famille, String mail, String phone,
			String mutuelle, String secu, JFrame frame) {
		String requete = "Select * from patient where mail='" + mail + "'";
		ResultSet result = Connect.Requete(cnx, requete);
		try {
			while (result.next()) {
				lblError.setText("Ce compte existe déjà.");
				return;
			}
			requete = "INSERT INTO patient(nom, prenom, mail, tel, mutuelle, secu) VALUES('" + nom + "', '"
					+ nom_famille + "', '" + mail + "', '" + phone + "', '" + mutuelle + "', '" + secu + "')";
			Connect.Requete_prepare(cnx, requete);

			JavaMail Mail = new JavaMail();
			Mail.send_mail(mail);
			frame.dispose();
			addRDV window = new addRDV();
			window.add_rdv.setVisible(true);

		} catch (Exception ex) {

		}
	}

	// METHODE POUR AJOUTER UN RDV
	public void ajouter_rdv(Date date, JLabel lblError, String name, String lastname, String mail, String medic,
			String heure, JFrame add_rdv) {
		String requete = "Select date from rdv where date='" + date + "'";
		ResultSet result = Connect.Requete(cnx, requete);
		try {
			while (result.next()) {
				lblError.setText("Le rendez-vous existe déjà!");
				return;
			}
			requete = "INSERT INTO rdv(nom_patient, prenom_patient, mail_patient, nom_medecin, date, heure) VALUES('"
					+ name + "', '" + lastname + "', '" + mail + "', '" + medic + "', '" + date + "'," + "'" + heure
					+ "')";
			Connect.Requete_prepare(cnx, requete);

			JOptionPane.showMessageDialog(null, "Le rendez-vous est confirmé!");

			add_rdv.dispose();
			rdv window = new rdv();
			window.Rdv.setVisible(true);

		} catch (Exception ex) {

		}
	}

	// METHODE DE CONFIRMATION DE SUPPRESSION D'UN MEDICAMENT
	public void confirm_delete(boolean success, JLabel lblSuccess) {
		String requete3 = "delete from stock where nom = '" + medic + "'";
		success = Connect.Requete_prepare(cnx, requete3);
		System.out.println(requete3);

		if (success) {
			lblSuccess.setForeground(Color.GREEN);
			lblSuccess.setText("Médicament supprimé avec succès");
		} else {
			lblSuccess.setForeground(Color.RED);
			lblSuccess.setText("Suppression échouée");
		}
	}

	// METHODE POUR AFFICHER LES DONNEES D'UN MEDICAMENT
	public void disp_medic(String medic, JLabel name, JLabel manuf, JLabel qty, JLabel dangers) {
		String requete = "Select * from stock where nom = '" + medic + "'";
		ResultSet result = Connect.Requete(cnx, requete);
		try {
			while (result.next()) {
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

	// METHODE POUR AFFICHER LES COMMANDES DE MEDICAMENT
	public void disp_order(String medic, JLabel manuf, JLabel qty, JLabel date) {
		String requete = "Select * from commande where nom_medicament = '" + medic + "'";
		ResultSet result = Connect.Requete(cnx, requete);
		try {
			while (result.next()) {
				manuf.setText(result.getString("fabricant"));
				qty.setText(result.getString("qte"));
				date.setText(result.getString("date"));
			}
			result.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public void go_to_rdv(JLabel lblError) {
		String requete = "Select * from compte where id='" + id + "' and acces_rdv= '1'";
		ResultSet result = Connect.Requete(cnx, requete);
		try {
			while (result.next()) {
				index.dispose();
				rdv window = new rdv();
				window.Rdv.setVisible(true);
			}
			lblError.setText("Accès aux rdv refusé");
		} catch (Exception ex) {

		}
	}

	public void go_to_stock(JLabel lblError) {
		String requete = "Select * from compte where id='" + id + "' and acces_stock= '1'";
		ResultSet result = Connect.Requete(cnx, requete);
		try {
			while (result.next()) {
				index.dispose();
				stock window = new stock();
				window.Stock.setVisible(true);
			}

			lblError.setText("Accès au stock refusé");
		} catch (Exception ex) {

		}
	}

	public void validate_order(String Selected_item, boolean success, JLabel lblError) {
		String medic = Selected_item;
		String requete = "Select qte from commande where nom_medicament = '" + medic + "'";
		ResultSet result = Connect.Requete(cnx, requete);
		try {
			while (result.next()) {
				int Order_Qte = result.getInt("qte");
				requete = "Select qte from stock where nom = '" + medic + "'";
				result = Connect.Requete(cnx, requete);
				try {
					while (result.next()) {
						int Actual_Qte = result.getInt("qte");
						int total_qte = Order_Qte + Actual_Qte;
						requete = "Update stock set qte = '" + total_qte + "' where nom = '" + medic + "'";
						success = Connect.Requete_prepare(cnx, requete);

						if (success == true) {
							lblError.setForeground(Color.GREEN);
							lblError.setText("Commande validée");
							requete = "delete from commande where nom_medicament = '" + medic + "'";
							Connect.Requete_prepare(cnx, requete);
						} else {
							lblError.setForeground(Color.RED);
							lblError.setText("Erreur");
						}

					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			result.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public void delete_order(String Selecte_item, JLabel lblError) {
		String medic = Selecte_item;
		String requete = "delete from commande where nom_medicament = '" + medic + "'";
		Connect.Requete_prepare(cnx, requete);
		lblError.setForeground(Color.GREEN);
		lblError.setText("Commande annulée");
	}

	public void modify_medic(String txtName, String txtFabriquant, String txtQty, String txtDangers, boolean success,
			JLabel lblSuccess) {
		String requete = "update stock set nom = '" + txtName + "', fabricant = '" + txtFabriquant + "', qte = '"
				+ txtQty + "', danger = '" + txtDangers + "' where id='" + id + "'";
		success = Connect.Requete_prepare(cnx, requete);

		if (success == true) {
			lblSuccess.setForeground(Color.GREEN);
			lblSuccess.setText("Modifications enregistrées");
		} else {
			lblSuccess.setForeground(Color.RED);
			lblSuccess.setText("Modifications échouées");
		}
	}

	public void display_medic_info(String Selected_item, JLabel lblManufacturerName, JLabel lblActualQty,
			JTextField txtOrderQty, JLabel lblNewQty) {
		String medic = Selected_item;
		String requete = "Select * from stock where nom = '" + medic + "'";
		ResultSet result = Connect.Requete(cnx, requete);
		try {
			while (result.next()) {
				lblManufacturerName.setText(result.getString("fabricant"));
				lblActualQty.setText(result.getString("qte"));
				int acutalQty = Integer.parseInt(result.getString("qte"));

				txtOrderQty.addKeyListener(new KeyAdapter() {
					public void keyReleased(KeyEvent e) {
						try {
							int orderQty = Integer.parseInt(txtOrderQty.getText());
							int newQty = acutalQty + orderQty;
							lblNewQty.setText("-> " + newQty);
						} catch (Exception ex) {

						}
					}
				});
			}
			result.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public void order(String Selected_item, JLabel lblManufacturerName, JTextField txtOrderQty, JLabel lblError) {
		try {
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String actualDate = formatter.format(date);
			String requete = "INSERT INTO commande(nom_medicament, fabricant, qte, date) VALUES('" + Selected_item
					+ "', '" + lblManufacturerName.getText() + "', '" + txtOrderQty.getText() + "', '" + actualDate
					+ "')";
			boolean success = Connect.Requete_prepare(cnx, requete);
			if (success) {
				lblError.setForeground(Color.GREEN);
				lblError.setText("Commande passée avec succès");
			} else {
				lblError.setForeground(Color.RED);
				lblError.setText("Erreur, commande annulée");
			}

		} catch (Exception ex) {

		}
	}

	public void table_load_medecin(JTable table) {
		DbConnection Connect = new DbConnection();
		Connection cnx = Connect.dbConnection();
		String requete = "Select * from medecin";
		ResultSet result = Connect.Requete(cnx, requete);

		table.setModel(DbUtils.resultSetToTableModel(result));

	}

	public void table_load_rdv(JTable table) {
		DbConnection Connect = new DbConnection();
		Connection cnx = Connect.dbConnection();
		String requete = "Select * from rdv";
		ResultSet result = Connect.Requete(cnx, requete);

		table.setModel(DbUtils.resultSetToTableModel(result));

	}

	public void add_medecin(JTextField txtname, JTextField txtlastname, JTextField txtspeciality, JTable table) {
		String name, lastname, speciality;

		name = txtname.getText();
		lastname = txtlastname.getText();
		speciality = txtspeciality.getText();

		try {

			String requete = "INSERT INTO medecin(nom, prenom, specialite) VALUES('" + txtname.getText() + "', '"
					+ txtlastname.getText() + "' , '" + txtspeciality.getText() + "')";
			Connect.Requete_prepare(cnx, requete);

			JOptionPane.showMessageDialog(null, "Médecin ajouté !");
			table_load_medecin(table);

			txtname.setText("");
			txtlastname.setText("");
			txtspeciality.setText("");
			txtname.requestFocus();
		}

		catch (Exception ex) {

		}
	}

	public void display_medecin_info(JTextField txtid, JTextField txtname, JTextField txtlastname, JTextField txtspeciality) {
		try {

			DbConnection Connect = new DbConnection();
			Connection cnx = Connect.dbConnection();

			String id = txtid.getText();

			String requetes = "select nom, prenom, specialite from medecin where id = '" + id + "'";

			ResultSet resultat = Connect.Requete(cnx, requetes);

			// resultat.updateString(1, id);

			if (resultat.next() == true) {

				String name = resultat.getString(1);
				String lastname = resultat.getString(2);
				String speciality = resultat.getString(3);

				txtname.setText(name);
				txtlastname.setText(lastname);
				txtspeciality.setText(speciality);

			} else {
				txtname.setText("");
				txtlastname.setText("");
				txtspeciality.setText("");

			}

		}

		catch (SQLException ex) {

		}
	}
	
	
	public void update_medecin_info(JTextField txtid, JTextField txtname, JTextField txtlastname, JTextField txtspeciality, JTable table) {
		String name, lastname, speciality, id;

		name = txtname.getText();
		lastname = txtlastname.getText();
		speciality = txtspeciality.getText();
		id = txtid.getText();

		try {

			String requetes2 = "update medecin set nom = '" + name + "', prenom = '" + lastname
					+ "', specialite = '" + speciality + "' where id = '" + id + "'";

			Connect.Requete_prepare(cnx, requetes2);

			JOptionPane.showMessageDialog(null, "Compte mis à jour!");
			methods Methode = new methods();
			Methode.table_load_medecin(table);

			txtname.setText("");
			txtlastname.setText("");
			txtspeciality.setText("");
			txtname.requestFocus();
		}

		catch (Exception ex) {

		}
	}
	
	
	public void delete_medecin(JTextField txtid, JTextField txtname, JTextField txtlastname, JTextField txtspeciality, JTable table) {
		String bid;
		bid = txtid.getText();

		try {

			String requetes3 = "delete from medecin where id = '" + bid + "'";
			Connect.Requete_prepare(cnx, requetes3);
			JOptionPane.showMessageDialog(null, "Compte supprimé !");
			methods Methode = new methods();
			Methode.table_load_medecin(table);

			txtname.setText("");
			txtlastname.setText("");
			txtspeciality.setText("");
			txtname.requestFocus();
		}

		catch (Exception e1) {

			e1.printStackTrace();
		}
	}
	
	
	public void display_rdv_info(JTextField txtid, JTextField txtname, JTextField txtlastname, JTextField txtspeciality) {
		try {

			DbConnection Connect = new DbConnection();
			Connection cnx = Connect.dbConnection();

			String id = txtid.getText();

			String requetes = "select nom_patient, prenom_patient, nom_medecin from rdv where id = '" + id
					+ "'";

			ResultSet resultat = Connect.Requete(cnx, requetes);

			// resultat.updateString(1, id);

			if (resultat.next() == true) {

				String name = resultat.getString(1);
				String lastname = resultat.getString(2);
				String speciality = resultat.getString(3);

				txtname.setText(name);
				txtlastname.setText(lastname);
				txtspeciality.setText(speciality);

			} else {
				txtname.setText("");
				txtlastname.setText("");
				txtspeciality.setText("");

			}

		}

		catch (SQLException ex) {

		}
	}

	public void delete_rdv(JTextField txtid, JTextField txtname, JTextField txtlastname, JTextField txtspeciality, JTable table) {
		String bid;
		bid = txtid.getText();

		try {

			String requetes3 = "delete from rdv where id = '" + bid + "'";
			Connect.Requete_prepare(cnx, requetes3);
			JOptionPane.showMessageDialog(null, "Compte supprimé !");
			methods Methode = new methods();
			Methode.table_load_rdv(table);

			txtname.setText("");
			txtlastname.setText("");
			txtspeciality.setText("");
			txtname.requestFocus();
		}

		catch (Exception e1) {

			e1.printStackTrace();
		}
	}
}
