package de.hwg_lu.bw4s.beans;

public class Reservation {
	String name = "";
	String mail = "";
	String date = "";
	String heur ="";
	String nb_personne = "";
	String message = "";
	int  id  ;
	
	public Reservation() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param name
	 * @param date
	 * @param heur
	 * @param nb_personne
	 * @param message
	 * @param id
	 */
	public Reservation(String name,String mail, String date, String heur, String nb_personne, String message, int id) {
		super();
		this.name = name;
		this.mail = mail;
		this.date = date;
		this.heur = heur;
		this.nb_personne = nb_personne;
		this.message = message;
		this.id = id;
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
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

}
