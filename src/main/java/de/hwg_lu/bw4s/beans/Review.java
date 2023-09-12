package de.hwg_lu.bw4s.beans;

public class Review {
	String name;
	int sterne;
	String comment;
	String mail;
	int id;

	public Review() {
		// TODO Auto-generated constructor stub
	}

	

	/**
	 * @param name
	 * @param sterne
	 * @param comment
	 * @param mail
	 * @param id
	 */
	public Review(String name, int sterne, String comment, String mail, int id) {
		super();
		this.name = name;
		this.sterne = sterne;
		this.comment = comment;
		this.mail = mail;
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
	 * @return the sterne
	 */
	public int getSterne() {
		return sterne;
	}

	/**
	 * @param sterne the sterne to set
	 */
	public void setSterne(int sterne) {
		this.sterne = sterne;
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
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
