package javahsp.javamail;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.PasswordAuthentication;


public class JavaMailUtil {
	
	public static void sendMail(String recepient) throws Exception {
		System.out.println("Préparation à l'envoi de mail!");
		
		Properties properties = new Properties();
		
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		
		String MyAccountEmail = "ryannathanslam@gmail.com";
		String password = "TrafalgarLaw404";
		
		Session session = Session.getInstance(properties, new Authenticator() {
			
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(MyAccountEmail, password);
			}
		});
		
		Message message = prepareMessage(session, MyAccountEmail, recepient);
		
		Transport.send(message);
		System.out.println("Message envoyé avec succès!");

	}
	
	private static Message prepareMessage(Session session, String MyAccountEmail, String recepient) {
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(MyAccountEmail));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
			message.setSubject("Corazon App - Inscription");
			message.setText("Votre inscription a bien été enregistrée");
			return message;
		} catch (Exception ex) {
			Logger.getLogger(JavaMailUtil.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

}
