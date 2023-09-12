package de.hwg_lu.bw4s.beans;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class EmailSender {
	
	 String to = "franktsidie@gmail.com";
     String from = "franktsidie@gmail.com";
     String cc = "sophiealida21@gmail.com";
     String host = "smtp.gmail.com";
     String username = "franktsidie@gmail.com";
     String password = "xqhzmyltnsxebvsw";
     String sujet = "Reservirungsbestätigung";
     String bodyMail = "Frank Ceci est un test d'envoi de mail depuis Java. \n\nBesten Dank \nKamerDelice";
     Session session;
     
    public EmailSender()  {
       
        // Définir les propriétés du serveur SMTP
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

        // Créer une session d'authentification avec le serveur SMTP
         session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        
    }
    
   // pour les testes du programme..
    public static void main(String[] args) {
    	EmailSender es= new EmailSender();
    	 es.sendMail();
	}
    public void sendMail() {
        try {
            // Créer un message MIME
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(getFrom()));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(getTo()));
            message.setRecipients(Message.RecipientType.CC,
                    InternetAddress.parse(getCc()));
            message.setSubject(getSujet());
            message.setText(getBodyMail());

            // Envoyer le message
            Transport.send(message);

            System.out.println("Le message a été envoyé avec succès.");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

	/**
	 * @return the to
	 */
	public String getTo() {
		return to;
	}

	/**
	 * @param to the to to set
	 */
	public void setTo(String to) {
		this.to = to;
	}
public String getCc() {
	return cc;
}
	/**
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}

	/**
	 * @param from the from to set
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	/**
	 * @return the sujet
	 */
	public String getSujet() {
		return sujet;
	}

	public void setBodyMail(String bodyMail) {
		this.bodyMail = bodyMail;
	}
	
	public String getBodyMail() {
		return bodyMail;
	}
	/**
	 * @param sujet the sujet to set
	 */
	public void setSujet(String sujet) {
		this.sujet = sujet;
	}
    
    
}
