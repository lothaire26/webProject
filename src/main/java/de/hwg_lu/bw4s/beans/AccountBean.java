package de.hwg_lu.bw4s.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import de.hwg_lu.bw.jdbc.NoConnectionException;
import de.hwg_lu.bw.jdbc.PostgreSQLAccess;

/**
 * zu verwaltung von account und wiedeherstellen der Account
 * 
 * @author frank
 *
 */
public class AccountBean {
	String userid;
	String password;
	String active;
	String admin;
	String username;
	
	String email;
	
	boolean accoutcheck;
	String updat = "";
	Connection dbConn;

	public AccountBean() {
//		this.dbConn = new PostgreSQLAccess().getConnection();
		this.userid = "";
		this.password = "";
		this.active = "";
		this.admin = "";
		
		this.email = "Muster.email@gmail.com";
	}

	/**
	 * @return ob der Account existiert oder nicht
	 */
	public boolean isAccoutcheck() {
		return accoutcheck;
	}

	/**
	 * set true wenn account existiert und nein falls nein
	 * 
	 * @param accoutcheck
	 */
	public void setAccoutcheck(boolean accoutcheck) {
		this.accoutcheck = accoutcheck;

	}

	/**
	 * passwort in den Datenbank akktualisieren , nachden den Account und sicherheit
	 * frage geschekt wurden
	 * 
	 * @param passwd
	 * @throws SQLException
	 */
	public void setUpdatePasswordforgot(String passwd) throws SQLException {
		String sql = "UPDATE bwi520_632134.accounts SET password='" + passwd + "' WHERE userid='" + this.getEmail()
				+ "';";
		System.out.println(sql);
		Connection dbConn = new PostgreSQLAccess().getConnection();
		PreparedStatement prep = dbConn.prepareStatement(sql);

		prep.executeUpdate();
		System.out.println("passwort wurde geändert");

	}

	boolean vorhanden = false;

	/**
	 * true oder false wenn der email adresse in verbindung mit der Sicherheitfrage
	 * existiert.
	 * 
	 * @return true oder false
	 * @throws SQLException
	 */
	
	/**
	 * ein Layout für die login oder das wiederherstellen des passwortes zurükgeben.
	 * 
	 * @return ein Layout für die login oder das wiederherstellen des passwortes.
	 * 
	 * @throws SQLException
	 */
	

	/**
	 * @return true wenn der benuzer eingelegt wurde
	 * @throws SQLException
	 */
	public boolean insertAccountIfNotExists() throws SQLException {
		// true - Datensatz existierte noch nicht und wurde geschrieben
		// false - Datensatz existierte schon und wurde nicht geschrieben
		this.prepareAttributesForDB();
		// erst prüfen, ob ex.
		// wenn ja, dann return false
		// wenn nein, dann insert ohne weitere Prüfung und return true
		boolean accountExists = this.checkAccountExists();
		if (accountExists)
			return false;
		else {
			this.insertAccountNoCheck();
			return true;
		}
	}

	public boolean checkAccountExists3() throws SQLException {
		// true - this.userid wurde in der DB-Tabelle account gefunden
		// false - this.userid wurde in account nicht gefunden
		String sql = "select email from aaa.benutzer";
		this.dbConn = new PostgreSQLAccess().getConnection();
		PreparedStatement prep = this.dbConn.prepareStatement(sql);
		ResultSet dbRes = prep.executeQuery();
		boolean gefunden = false;
		while (dbRes.next()) {
			String currentUserid = dbRes.getString("email").trim();
			if (currentUserid.equals(this.email)) {
				gefunden = true;
				break;
			}
		}
		return gefunden;
	}

	public boolean checkAccountExists2() throws SQLException {
		// true - this.userid wurde in der DB-Tabelle account gefunden
		// false - this.userid wurde in account nicht gefunden
		String sql = "select count(*) from aaa.benutzer where email = ?";
		this.dbConn = new PostgreSQLAccess().getConnection();
		PreparedStatement prep = this.dbConn.prepareStatement(sql);
		prep.setString(1, this.getEmail());
		ResultSet dbRes = prep.executeQuery();
		// dbRes enthält 1 Zeile, 1 Spalte mit Inhalt 0 oder 1
//		boolean gefunden = false;
//		dbRes.next();
//		int anzLines = dbRes.getInt(1);
//		if (anzLines > 0) gefunden = true;
//		return gefunden;
		dbRes.next();
		return (dbRes.getInt(1) > 0);
	}

	/**
	 * @return true or false je nachdem ob der account berit vorhanden ist.
	 * @throws NoConnectionException
	 * @throws SQLException
	 */
	public boolean checkAccountExists() throws NoConnectionException, SQLException {
		// true - this.userid wurde in der DB-Tabelle account gefunden
		// false - this.userid wurde in account nicht gefunden
		String sql = "select email from benutzer where email = ?";
		this.dbConn = new PostgreSQLAccess().getConnection();
		PreparedStatement prep = this.dbConn.prepareStatement(sql);
		prep.setString(1, this.email);
		ResultSet dbRes = prep.executeQuery();
		boolean gefunden = dbRes.next();
		return gefunden;
	}

	/**
	 * Vorbereitung der Werte bevor sie in der Datenbank geschreiben werden wir
	 * schneiden ab, in der Praxis würde man eine Exception werfen
	 */
	public void prepareAttributesForDB() {
		if (this.userid == null)
			this.userid = "";
		if (this.password == null)
			this.password = "";
		
		if (this.email == null)
			this.email = "";
		if (this.active == null)
			this.active = "";
		if (this.admin == null)
			this.admin = "";
		// wir schneiden ab, in der Praxis würde man eine Exception werfen
		if (this.userid.length() > 56)
			this.userid = this.userid.substring(0, 56);
		if (this.password.length() > 32)
			this.password = this.password.substring(0, 32);
		
		if (this.email.length() > 256)
			this.email = this.email.substring(0, 256);
		if (this.active.toLowerCase().equals("yes") || this.active.equalsIgnoreCase("y")
				|| this.active.equalsIgnoreCase("ja") || this.active.equalsIgnoreCase("j"))
			this.active = "Y";
		else
			this.active = "N";
		if (this.admin.toLowerCase().equals("yes") || this.admin.equalsIgnoreCase("y")
				|| this.admin.equalsIgnoreCase("ja") || this.admin.equalsIgnoreCase("j"))
			this.admin = "Y";
		else
			this.admin = "N";
	}

	public void insertAccountNoCheck() throws NoConnectionException, SQLException {
		String sql = "insert into benutzer ( email, passwort, vorname, nachname) values (?, ?, ?, ?)";
		System.out.println(sql);
		this.dbConn = new PostgreSQLAccess().getConnection();
		PreparedStatement prep = this.dbConn.prepareStatement(sql);
		
		prep.setString(1, this.email);
		prep.setString(2, this.password);
		prep.setString(3, this.username);		
		prep.setString(4, this.username);
		
		prep.executeUpdate();
		System.out.println("Account " + this.userid + " erfolgreich angelegt");
	}

	public String toString() {
		String s = "AccountBean mit ";
		
		s += "password: " + this.getPassword() + ", ";
		s += "active: " + this.getActive() + ", ";
		s += "admin: " + this.getAdmin() + ", ";
	
		s += "email: " + this.getEmail();
		return s;
	}

	
	/**
	 * @return the updat
	 */
	public String getUpdat() {
		return updat;
	}

	/**
	 * @param updat the updat to set
	 */
	public void setUpdat(String updat) {
		this.updat = updat;
	}

	/**
	 * @return the dbConn
	 */
	public Connection getDbConn() {
		return dbConn;
	}

	/**
	 * @param dbConn the dbConn to set
	 */
	public void setDbConn(Connection dbConn) {
		this.dbConn = dbConn;
	}

	/**
	 * @return the vorhanden
	 */
	public boolean isVorhanden() {
		return vorhanden;
	}

	/**
	 * @param vorhanden the vorhanden to set
	 */
	public void setVorhanden(boolean vorhanden) {
		this.vorhanden = vorhanden;
	}

	/**
	 * @return the userid
	 */
	public String getUserid() {
		return userid;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsername() {
		return username;
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
