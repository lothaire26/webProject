package de.hwg_lu.bw4s.beans;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.ArrayList;




public class ReservationBean {

	String name = "K.A.";
	String mail ="K.A.";
	String date = "K.A.";
	String heur ="K.A.";
	String nb_personne = "K.A.";
	String message = "K.A.";
	int zaehler=0;
	int id=0;
	int SuchUndfound=0;
	//recherche des reservation
	String emailRecher ="";
	int idRecher=-1;
	String nomRecher="";
	
	Reservation  reservZeiger;
	int modifAnnullID;
	// mail senden
	 String to = "franktsidie@gmail.com";
     String from = "franktsidie@gmail.com";
     String cc = "sophiealida21@gmail.com";
     String host = "smtp.gmail.com";
     String username = "franktsidie@gmail.com";
     String password = "xqhzmyltnsxebvsw";
     String sujet = "Reservirungsbestätigung";
     String bodyMail = "Frank Ceci est un test d'envoi de mail depuis Java. \n\nBesten Dank \nKamerDelice";
     Session session;

	ArrayList<Reservation> reservations = new ArrayList<Reservation>();
	ArrayList<Reservation> rechercheList = new ArrayList<Reservation>();
	
//	// pour les testes du programme..
//    public static void main(String[] args) {
//    	ReservationBean rb =new ReservationBean();
//    	EmailSender es= new EmailSender();
//    	
//    	 es.sendMail();
//	}
	public ReservationBean() {
		Review r=new Review("Anna Müller", 5, "Das Essen war fantastisch und der Service war ausgezeichnet! Ich kann es kaum erwarten, wiederzukommen!","sophie@mail.com", 1 );
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
        
         
		reservations.add(new Reservation( "Sophie Alida", "Sophie@mail.com",  "06.05.2023",  "22:30",  "2",  " Wir möchten ... essen!",  0));
		rechercheList.add(new Reservation( "Sophie Jonfang","Sophie@mail.com",  "06.03.2023",  "22:30",  "1",  " okok",  1));
		reservations.add(new Reservation( "Sophie Alida", "Sophie@mail.com",  "05.03.2023",  "22:30",  "2",  " Wir möchten ... essen!",  2));
		reservations.add(new Reservation( "Sophie Alida", "Sophie@mail.com",  "07.03.2023",  "22:30",  "8",  " Wir möchten ... essen!",  3));
		reservations.add(new Reservation( "Sophie Alida", "Sophie@mail.com",  "06.03.2023",  "22:30",  "2",  " Wir möchten ... essen!",  4));
		reservations.add(new Reservation( "Sophie Alida", "Sophie@mail.com",  "02.08.2023",  "22:30",  "2",  " Wir möchten ... essen!",  123));
		reservations.add(new Reservation( "Sophie Alida", "Sophie@mail.com",  "06.03.2023",  "22:30",  "2",  " Wir möchten ... essen!",  789));
		reservations.add(new Reservation( "Sophie Alida", "Sophie@mail.com",  "06.07.2023",  "22:30",  "12",  " Wir möchten ... essen!",  456));

	}

	public void createReservation() {
		id=zaehler;
		reservations.add(new Reservation( name, mail,  date,  heur,  nb_personne,  message,  id));

		confirmReservationSendMail("Bestätigung Ihrer Reservierung");
		 zaehler++;
	}
	public void confirmReservationSendMail(String subjet) {
		
		
		EmailSender es= new EmailSender();
		es.setBodyMail("Sehr geehrte Damen und Herren,\r\n"
				+ "\r\n"
				+ "wir freuen uns, Ihre Reservierung im Restaurant KamerDelices zu bestätigen. Die Details Ihrer Reservierung lauten wie folgt:\r\n"
				+ "\r\n"
				+ "Reservirungsnummer: "+reservZeiger.getId()+"\r\n"
				+ "Name: "+reservZeiger.getName()+"\r\n"
				+ "Datum: "+reservZeiger.getDate()+"\r\n"
				+ "Uhrzeit: "+ reservZeiger.getHeur()+"\r\n"
				+ "Anzahl der Personen: "+ reservZeiger.getNb_personne()+"\r\n"
				+ "\r\n"
				+ "Wir haben auch Ihre speziellen Wünsche berücksichtigt:\r\n"
				+ "\r\n"
				+ ""+ reservZeiger.getMessage()+"\r\n"
				+ "\r\n"
				+ "Wir bedanken uns für Ihr Vertrauen und freuen uns darauf, Sie in unserem Restaurant begrüßen zu dürfen.\r\n"
				+ "\r\n"
				+ "Mit freundlichen Grüßen,\r\n"
				+ "\r\n"
				+ "Das Team des Restaurants KamerDelices");
		
		es.setSujet(subjet);
		es.setTo(getMail());
		
   	    es.sendMail();
		
   	
	}
	public void recherche() {
		SuchUndfound=1;
		System.out.println("suche");
		for (Reservation reserv : reservations) {
			
			if ((reserv.getId()==getIdRecher()&&reserv.getMail().toUpperCase().equals(getEmailRecher().toUpperCase())) || (reserv.getMail().toUpperCase().equals(getEmailRecher().toUpperCase())&& reserv.getName().toUpperCase().equals(getNomRecher().toUpperCase()))) {
				
				rechercheList.add(reserv);
				System.out.println("1 match");
				SuchUndfound=2;
			}
		}
	}
	
	public void annullerReservation(String id) {
		int idInt = Integer.parseInt(id);
		
		System.out.println("annuller id " +idInt);
		
		for (Reservation reservationRemove : reservations) {
			
			if ((reservationRemove.getId()==idInt)){
				reservZeiger=reservationRemove;
				rechercheList.remove(reservationRemove);
				reservations.remove(reservationRemove);
			}	}	
		confirmReservationSendMail("Stornirung Ihrer Reservierung");
	}
	
	public void modificationReservation() {
		
		
		System.out.println("annuller id " +modifAnnullID);
		
		for (Reservation reservationModif : reservations) {
			
			if ((reservationModif.getId()==modifAnnullID)){
				
				reservationModif.setName(getName());
				reservationModif.setDate(getDate());
				reservationModif.setHeur(getHeur());
				reservationModif.setMessage(getMessage());
				reservationModif.setNb_personne(getNb_personne());
				reservZeiger=reservationModif;
				
				confirmReservationSendMail("Änderungsbestätigung Ihrer Reservierung");
			}	}	
	}
	public void setReservationZeiger(String id) {
		int idInt = Integer.parseInt(id);
		
		System.out.println("annuller id " +idInt);
		
		for (Reservation reservationModif : reservations) {
			
			if ((reservationModif.getId()==idInt)){
				
				
				reservZeiger=reservationModif;
				// für die getProperty
				setName( reservZeiger.getName());
				setDate( reservZeiger.getDate());
				setHeur( reservZeiger.getHeur());
				setMessage( reservZeiger.getMessage());
				setNb_personne( reservZeiger.getNb_personne());
				
				confirmReservationSendMail("Änderungsbestätigung Ihrer Reservierung");
			}	}	
	}
	
	public String getResultset(){
		
		String html="";
		for (Reservation currentReservation : rechercheList) {
			
			html+=" <tr>\r\n"
					+ "<td>"+ currentReservation.getId()+"</td>\r\n"
					+ "<td>"+currentReservation.getName()+"</td>\r\n"
					+ "<td>"+currentReservation.getDate()+"</td>\r\n"
					+ "<td>"+currentReservation.getHeur()+"</td>\r\n"
					+ "<td>"+currentReservation.getNb_personne()+"</td>\r\n"
					+ "<td>"+currentReservation.getMessage()+"</td>\r\n"
					+ "<td>\r\n"
					+ "  <a href=\"reservationAppl.jsp?modification=Modifier&idModif="+currentReservation.getId()+"\" class=\"btn btn-sm btn-warning\">Modifier</a>\r\n"
					+ "  <a href=\"reservationAppl.jsp?annullation=Annuller&idAnnul="+currentReservation.getId()+"\"\" class=\"btn btn-sm btn-danger\">Annuler </a>\r\n"
					+ "</td>\r\n"
					+ "</tr>";
		
		}
		
		return html;
	}
	public String getResultNotFound(){
		if (SuchUndfound==2) {
			return "Voila toutes vos reservation";
		}else if (SuchUndfound==1) {
			return "Desolé, accune reservation n a été trouvée";
		}
		return"";
		
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
	    
		public void setModifAnnullID(int modifAnnullID) {
			this.modifAnnullID = modifAnnullID;
		}
		public int getModifAnnullID() {
			return modifAnnullID;
		}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
public int getZaehler() {
	return zaehler;
}
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
public void setMail(String mail) {
	this.mail = mail;
}
public String getMail() {
	return mail;
}
	/**
	 * @return the heur
	 */
	public String getHeur() {
		return heur;
	}

	/**
	 * @param heur the heur to set
	 */
	public void setHeur(String heur) {
		this.heur = heur;
	}

	/**
	 * @return the nb_personne
	 */
	public String getNb_personne() {
		return nb_personne;
	}

	/**
	 * @param nb_personne the nb_personne to set
	 */
	public void setNb_personne(String nb_personne) {
		this.nb_personne = nb_personne;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the emailRecher
	 */
	public String getEmailRecher() {
		return emailRecher;
	}

	/**
	 * @param emailRecher the emailRecher to set
	 */
	public void setEmailRecher(String emailRecher) {
		this.emailRecher = emailRecher;
	}

	/**
	 * @return the idRecher
	 */
	public int getIdRecher() {
		
		return idRecher;
	}

	/**
	 * @param idRecher the idRecher to set
	 */
	public void setIdRecher(int idRecher) {
		this.idRecher = idRecher;
	}

	/**
	 * @return the nomRecher
	 */
	public String getNomRecher() {
		return nomRecher;
	}

	/**
	 * @param nomRecher the nomRecher to set
	 */
	public void setNomRecher(String nomRecher) {
		this.nomRecher = nomRecher;
	}
	

     

}
