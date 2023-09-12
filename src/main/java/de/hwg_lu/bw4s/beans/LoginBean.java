package de.hwg_lu.bw4s.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import de.hwg_lu.bw.jdbc.PostgreSQLAccess;

/**
 * diese klasse dient deint der verwalltung von logging mit den Passwort und E-mail der Benutzern
 * @author sophie
 *
 */
public class LoginBean {

	String email;
	String password;
	String username;
	boolean isLoggedIn;
	boolean isAdmin=false;
	
	/**
	 * set default userId dieferent from a default value
	 */
	public LoginBean() {
		this.email = "nx";
	
	}
	
	/**
	 * @return TRUE OR FALSE  je nachdem ob der benutzer existiert oder nicht
	 * @throws SQLException
	 */
	public boolean checkUseridPassword() throws SQLException {
		String sql = "SELECT  email , passwort  from benutzer where email = ? and passwort = ?";
		System.out.println(sql);
		Connection dbConn = new PostgreSQLAccess().getConnection();
		PreparedStatement prep = dbConn.prepareStatement(sql);
		prep.setString(1, this.email);
		prep.setString(2, this.password);
		ResultSet dbRes = prep.executeQuery();
		 
		 System.out.println(email+"\n"+ password);
		return dbRes.next();
	}
	
	public boolean checkUseridPassword2() throws SQLException {
		String sql = "SELECT email, passwort from benutzer where email = ?";
		System.out.println(sql);
		Connection dbConn = new PostgreSQLAccess().getConnection();
		PreparedStatement prep = dbConn.prepareStatement(sql);
		prep.setString(1, this.email);
		ResultSet dbRes = prep.executeQuery();
		
		boolean recordExists = dbRes.next();
		if (recordExists) {
			String myPassword = dbRes.getString("passwort").trim();
			 this.username    = dbRes.getString("mail");
			if (myPassword.equals(this.password)) return true;
			else return false;
		}else {
			return false;
		}
	}
	
	
	/**
	 * Ist der Aktuelle benutzer ein Administrator, dann wird die Seite um drei weitere buttons erweitert( Account verwaltung , Tutor Verwaltung und Nachrichten Verwaltung)
	 * @author frank tsidie
	 *
	 */
	public String getAdminBtnn() throws SQLException {
		//wenn man eingelogt ist und admin dann kann man tutoren und accounts verwalten
		String sql = "SELECT userid, passwort from accounts where email = ? and passwort = ? and admin= ?";
		System.out.println(sql);
		Connection dbConn = new PostgreSQLAccess().getConnection();
		PreparedStatement prep = dbConn.prepareStatement(sql);
		prep.setString(1, this.getMail());
		prep.setString(2, this.password);
		prep.setString(3, "Y");
		ResultSet dbRes = prep.executeQuery();
		isAdmin= dbRes.next();
		if (isAdmin) {
			
			return "";
		}
		return "";
	}
	
	
	/**
	 * @return return the if Admin
	 */
	public boolean isAdmin() {
		return isAdmin;
	}

	/**
	 * @param isAdmin set admin status
	 */
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	/**
	 * @return userId return the userId
	 */
	public String getMail() {
		return email;
	}
	/**
	 * @param userid set the userId
	 */
	public void setMail(String userid) {
		this.email = userid;
	}
	/**
	 * @return passwort return the pass
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return loggin retun the Status
	 */
	public boolean isLoggedIn() {
		return isLoggedIn;
	}
	/**
	 * @param isLoggedIn set logging status
	 */
	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}

	/**
	 * @return username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username set username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
}
