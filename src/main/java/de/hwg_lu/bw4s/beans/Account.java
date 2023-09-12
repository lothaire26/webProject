package de.hwg_lu.bw4s.beans;


/**
 * class account  wird zum abspechen der Account in Der collection genutzt
 * @author frank
 *
 */
public class Account {

	String userid;   
	String password;
	String active;
	String admin;
	String username;
	String email;
	/**
	 * @param userid
	 * @param password
	 * @param active
	 * @param admin
	 * @param username
	 * @param email
	 */
	public Account(String userid, String password, String active, String admin, String username, String email) {
		super();
		this.userid = userid;
		this.password = password;
		this.active = active;
		this.admin = admin;
		this.username = username;
		this.email = email;
	}
	/**
	 * @return the userid
	 */
	public String getUserid() {
		return userid;
	}
	/**
	 * @param userid the userid to set
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the active
	 */
	public String getActive() {
		return active;
	}
	/**
	 * @param active the active to set
	 */
	public void setActive(String active) {
		this.active = active;
	}
	/**
	 * @return the admin
	 */
	public String getAdmin() {
		return admin;
	}
	/**
	 * @param admin the admin to set
	 */
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
