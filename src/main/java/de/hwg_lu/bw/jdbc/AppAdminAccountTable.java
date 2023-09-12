package de.hwg_lu.bw.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AppAdminAccountTable {

	Connection dbConn; // ist erst mal null
	
	public static void main(String[] args) throws SQLException {
		AppAdminAccountTable aaat = new AppAdminAccountTable();//erzeuge Anwendungsobjekt
		aaat.dbConn = new PostgreSQLAccess().getConnection();//setze dbConn
		aaat.doSomething();//springe nach doSomething()
	}

	public void doSomething() throws SQLException{//kann auf this.dbConn zugreifen
//		this.dropTableAccount();
//		this.createTableAccount();
//		this.insertFirstAccount();
//		this.insertSecondAccountPrepared();
//		this.insertThirdAccountFromVariables();
//		this.insertFourthAccountFromVariablesRetro();
//		this.insertSeveralAccounts();
//		this.showAllAccounts();
		
	}
	public void dropTableAccount() throws SQLException{
		String sql = "DROP table if exists account";
		System.out.println(sql);
		PreparedStatement prep = this.dbConn.prepareStatement(sql);
		prep.executeUpdate();
		System.out.println("Tabelle account gedropped");
	}
	public void createTableAccount() throws SQLException{
		String sql = "create table account("
				+ "				userid   CHAR(16) NOT NULL PRIMARY KEY,"
				+ "				password CHAR(32) NOT NULL            ,"
				+ "				active   CHAR(1)  NOT NULL DEFAULT 'Y',"
				+ "				admin    CHAR(1)  NOT NULL DEFAULT 'N',"
				+ "				age      INT                          ,"
				+ "				email    VARCHAR(256)                 )";
		System.out.println(sql);
		PreparedStatement prep = this.dbConn.prepareStatement(sql);
		prep.executeUpdate();
		System.out.println("Tabelle account angelegt");
	}
	public void insertFirstAccount() throws SQLException{
		String sql = "insert into account "
				+ "(userid, password, active, admin, age, email) "
				+ "values "
				+ "('testus1', 'geheim', 'Y', 'N', 25, 'testus1@abc.de')";
		System.out.println(sql);
		PreparedStatement prep = this.dbConn.prepareStatement(sql);
		prep.executeUpdate();
		System.out.println("testus1 inserted");
	}
	public void insertSecondAccountPrepared() throws SQLException{
		String sql = "insert into account "
				+ "(userid, password, active, admin, age, email) "
				+ "values "
				+ "(?,?,?,?,?,?)";
		System.out.println(sql);
		PreparedStatement prep = this.dbConn.prepareStatement(sql);
		prep.setString(1, "testus2");
		prep.setString(2, "geheim");
		prep.setString(3, "Y");
		prep.setString(4, "N");
		prep.setInt(5, 25);
		prep.setString(6, "testus2@abc.de");
		prep.executeUpdate();
		System.out.println("testus2 inserted");
	}
	public void insertThirdAccountFromVariables() throws SQLException{
		String sql = "insert into account "
				+ "(userid, password, active, admin, age, email) "
				+ "values "
				+ "(?,?,?,?,?,?)";
		System.out.println(sql);
		
		PreparedStatement prep = this.dbConn.prepareStatement(sql);
		
		String userid = "testus3";
		String password = "geheim";
		String active = "Y";
		String admin = "N";
		int age = 25;
		String email = "testus3@abc.de";
		
		prep.setString(1, userid);
		prep.setString(2, password);
		prep.setString(3, active);
		prep.setString(4, admin);
		prep.setInt(5, age);
		prep.setString(6, email);
		
		prep.executeUpdate();
		System.out.println("testus3 inserted");
	}
	public void insertFourthAccountFromVariablesRetro() throws SQLException{
//bitte verwenden Sie das niemals!
		String userid = "testus4";
		String password = "geheim";
		String active = "Y";
		String admin = "N";
		int age = 25;
		String email = "testus4@abc.de";

		String sql = "insert into account "
				+ "(userid, password, active, admin, age, email) "
				+ "values "
				+ "('" + userid + "','" + password + "','" + active +
					"','" + admin + "'," + age + ",'" + email + "')";
		System.out.println(sql);
		
		Statement stat = this.dbConn.createStatement();
		stat.executeUpdate(sql);
		//this.dbConn.createStatement().executeUpdate(sql);
		System.out.println("testus4 inserted");
	}
	public void insertSeveralAccounts() throws SQLException{
		String sql = "insert into account "
				+ "(userid, password, active, admin, age, email) "
				+ "values "
				+ "(?,?,?,?,?,?)";
		System.out.println(sql);
		
		PreparedStatement prep = this.dbConn.prepareStatement(sql);
		
		String userid = "testus";
		String password = "geheim";
		String active = "Y";
		String admin = "N";
		int age = 25;
		String email = "testus";

		prep.setString(2, password);
		prep.setString(3, active);
		prep.setString(4, admin);
		prep.setInt(5, age);

		for (int index = 5; index <= 8; index++){
			prep.setString(1, userid + index);
			prep.setString(6, email + index + "@abc.de");
			prep.executeUpdate();
		}
		System.out.println("testus5 - testus8 inserted");
	}
	public void showAllAccounts() throws SQLException{
		String sql = "select userid, password, active, "
					+ "admin, age, email from account";
		System.out.println(sql);
		
		PreparedStatement prep = this.dbConn.prepareStatement(sql);
		ResultSet dbResult = prep.executeQuery();
		
		while(dbResult.next()){
			System.out.println(
				dbResult.getString("userid") +
				dbResult.getString("password") +
				dbResult.getString("active") +
				dbResult.getString("admin") +
				dbResult.getInt("age") +
				dbResult.getString("email")
			);
		}
		System.out.println("while-Schleife beendet");
		
		
	}

	
}
