package de.hwg_lu.bw.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class AppInstallTables {

	Connection dbConn;
	
	public static void main(String[] args) throws SQLException {
		AppInstallTables myApp = new AppInstallTables();
		myApp.dbConn = new PostgreSQLAccess().getConnection();
		myApp.doSomething();
	}

	public void doSomething() throws SQLException {
		createTableBenutzer();
	}
	
	public void createTableBenutzer() throws SQLException {

		String sql;
		sql = "CREATE TABLE aaa.BENUTZER (\r\n"
				+ "	email VARCHAR(100) NOT NULL PRIMARY KEY,\r\n"
				+ "	passwort VARCHAR(100) NOT NULL,\r\n"
				+ "	vorname VARCHAR(50) NOT NULL,\r\n"
				+ "	nachname VARCHAR(50) NOT NULL\r\n"
				+ ");";
		
		System.out.println(sql);	
		this.dbConn.createStatement().executeUpdate(sql);
		
	}
}