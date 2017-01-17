package br.com.dbmigrate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author NetoDevel
 */
public class CreateDatabase {
	
	private static String JDBC_MYSQL = "com.mysql.jdbc.Driver";
	private static String JDBC_POSTGRESQL = "org.postgresql.Driver";

	public static void createDatabase(String dataBaseName, String typeDatabase) throws SQLException, ClassNotFoundException {
		if (typeDatabase.equals("mysql")) {
			Class.forName(JDBC_MYSQL);
		} else if (typeDatabase.equals("postgresql")) {
			Class.forName(JDBC_POSTGRESQL);
		}
		Connection conn = (Connection) DriverManager.getConnection("jdbc:" + typeDatabase + "://localhost/?user=root&password=root");
		Statement s = conn.createStatement();
		int result = s.executeUpdate("CREATE DATABASE " + dataBaseName);
		
		if (result == 1) {
			System.out.println("database " + dataBaseName + " created");
		} else {
			System.out.println("error create database");
		}
	}
	
}
