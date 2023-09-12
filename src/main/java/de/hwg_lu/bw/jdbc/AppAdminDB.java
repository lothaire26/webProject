package de.hwg_lu.bw.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import de.hwg_lu.bw4s.beans.AccountBean;

public class AppAdminDB {
	
	Connection dbConn;
	String dbDriverName = "org.postgresql.Driver";
	String dbURL = "jdbc:postgresql://143.93.200.243:5432/BWUEBDB";
	String dbUserid = "user1";
	String dbPassword = "pgusers";

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		AppAdminDB myApp = new AppAdminDB();
		myApp.doSomething();
	}

	public void doSomething() throws SQLException, ClassNotFoundException{
		this.createConnection();
		this.dropTableAccount();
		this.createTableAccount();
//		this.insertFirstAccount();
//		this.insertSecondAccount();
//		this.insertThirdAndFourthAccount();
//		this.insertFifthAndSixthAccount();
		this.insertSeventhAccountWithBean();
//		this.checkAccountExists("testus7");
//		this.insertAccountUnsicherUndVeraltet();
//		this.showAllAccounts();
	}
	
	public void checkAccountExists(String userid) throws SQLException{
		AccountBean newBean = new AccountBean();
		newBean.setUserid(userid);
		boolean gefunden = newBean.checkAccountExists();
		if (gefunden) System.out.println("Account " + userid + " existiert");
		else System.out.println("Account " + userid + " existiert nicht");
	}
	public void insertSeventhAccountWithBean() throws NoConnectionException, SQLException{
		AccountBean newBean = new AccountBean();
		newBean.setUserid("testus7testus7testus7");
		newBean.setPassword("geheim");
		newBean.setActive("Y");
		newBean.setAdmin("N");
		newBean.setAlter(999);
		newBean.setEmail("testus7@abc.de");
		newBean.insertAccountNoCheck();
	}
	public void showAllAccounts() throws SQLException{
		//erst aus der DB-Tabelle account in ein ResultSet lesen,
		//dann die gelesenen Datensätze in die Konsole schreiben
		String sql = "Select userid, password, active, admin, alter, email "
				+ "from account";
		System.out.println(sql);
		PreparedStatement prep = this.dbConn.prepareStatement(sql);
		ResultSet dbRes = prep.executeQuery();
		//dbRes hat Pointer zunächst VOR der ersten Zeile
		
		while(dbRes.next()){
			System.out.print(dbRes.getString("userid"));
			System.out.print(dbRes.getString("password"));
			System.out.print(dbRes.getString("active"));
			System.out.print(dbRes.getString("admin"));
			System.out.print(dbRes.getInt("alter"));
			System.out.print(dbRes.getString("email"));
			System.out.println();
		}
	}
	public void insertAccountUnsicherUndVeraltet() throws SQLException{
		//Diese Art zu prgrammieren ist anfällig gegen SQL Injection
		// tun Sie das NICHT!!!
		String myUserid = "testus99";
		String sql = "insert into account (userid, password, active, admin, alter, email) "
				+ "values ('" + myUserid + "', 'geheim', 'Y', 'N', 25, '" + myUserid + "@abc.de')";
		System.out.println(sql);
		PreparedStatement prep = this.dbConn.prepareStatement(sql);
		prep.executeUpdate();
		System.out.println("Account " + myUserid + " eingefügt");
	}
	public void insertFifthAndSixthAccount() throws SQLException{
		String sql = "insert into account (userid, password, active, admin, alter, email) "
				+ "values (?,?,?,?,?,?)";
		System.out.println(sql);
		PreparedStatement prep = this.dbConn.prepareStatement(sql);
		for (int index = 5; index <= 6; index++){
			String myUserid = "testus" + index;
			System.out.println(myUserid);
			prep.setString(1, myUserid);
			prep.setString(2, "geheim");
			prep.setString(3, "Y");
			prep.setString(4, "N");
			prep.setInt(5, 25);
			prep.setString(6, myUserid+"@abc.de");
			prep.executeUpdate();
			System.out.println("Account " + myUserid + " eingefügt");
		}
	}
	public void insertThirdAndFourthAccount() throws SQLException{
		String sql = "insert into account (userid, password, active, admin, alter, email) "
				+ "values (?,?,?,?,?,?)";
		System.out.println(sql);
		PreparedStatement prep = this.dbConn.prepareStatement(sql);
		prep.setString(1, "testus3");
		prep.setString(2, "geheim");
		prep.setString(3, "Y");
		prep.setString(4, "N");
		prep.setInt(5, 25);
		prep.setString(6, "testus3@abc.de");
		prep.executeUpdate();
		System.out.println("Account testus3 eingefügt");
		//PreparedStatement noch mal verwenden
		prep.setString(1, "testus4");
		prep.setString(2, "geheim");
		prep.setString(3, "Y");
		prep.setString(4, "N");
		prep.setInt(5, 25);
		prep.setString(6, "testus4@abc.de");
		prep.executeUpdate();
		System.out.println("Account testus4 eingefügt");
	}
	public void insertSecondAccount() throws SQLException{
		String sql = "insert into account (userid, password, active, admin, alter, email) "
				+ "values (?,?,?,?,?,?)";
		System.out.println(sql);
		PreparedStatement prep = this.dbConn.prepareStatement(sql);
		prep.setString(1, "testus2");
		prep.setString(2, "geheim");
		prep.setString(3, "Y");
		prep.setString(4, "N");
		prep.setInt(5, 25);
		prep.setString(6, "testus2@abc.de");
		prep.executeUpdate();
		System.out.println("Account testus2 eingefügt");
	}
	public void insertFirstAccount() throws SQLException{
		String sql = "insert into account (userid, password, active, admin, alter, email) "
				+ "values ('testus1', 'geheim', 'Y', 'N', 25, 'testus1@abc.de')";
		System.out.println(sql);
		PreparedStatement prep = this.dbConn.prepareStatement(sql);
		prep.executeUpdate();
		System.out.println("Account testus1 eingefügt");
		//alternativ (ältere Version)
		//Statement stat = this.dbConn.createStatement();
		//stat.executeUpdate(sql);
	}
	public void createConnection() throws ClassNotFoundException, SQLException{
		this.dbConn = new PostgreSQLAccess().getConnection();
//		Class.forName("com.mysql.jdbc.Driver"); 
/*		Class.forName(dbDriverName); 
		System.out.println("JDBC-Treiber geladen");
		
		this.dbConn = 
		DriverManager.getConnection(dbURL, dbUserid, dbPassword);
		System.out.println("Verbindung hergestellt");
*/	}
	public void dropTableAccount() throws SQLException{
		//dirty JDBC
		this.dbConn.createStatement().executeUpdate("DROP TABLE IF EXISTS bwi420_654321.account");
	}
	public void createTableAccount() throws SQLException{
		//JDBC einfach: 3 Schritte
		//1. SQL-Befehl (Statement) als String im Java
		//2. PreparedStatement Objekt im JDBC passend zu dem SQL-String
		//3. Statement ausführen: execute...
		
		String sql = "CREATE TABLE account ("
				+ 		"userid char(16)     not null primary key     ,"
				+ 		"password char(32)   not null                 ,"
				+		"active char(1)      not null default 'Y'     ,"
				+ 		"admin  char(1)      not null default 'N'     ,"
				+		"alter  integer                               ,"
				+ 		"email  varchar(256)                           "
				+ 	")";
		System.out.println(sql);
		PreparedStatement prep = this.dbConn.prepareStatement(sql);
		prep.executeUpdate();
		System.out.println("Tabelle account angelegt");
		
	}
	

}
