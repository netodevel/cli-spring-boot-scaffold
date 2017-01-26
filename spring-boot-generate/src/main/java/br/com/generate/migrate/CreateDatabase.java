package br.com.generate.migrate;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.generate.ReadScaffoldInfo;

/**
 * @author NetoDevel
 */
public class CreateDatabase extends ReadScaffoldInfo {
	
	private static String JDBC_MYSQL = "com.mysql.jdbc.Driver";
	private static String JDBC_POSTGRESQL = "org.postgresql.Driver";

	public void createDatabase(String typeDatabase) throws ClassNotFoundException {
		if (typeDatabase.equals("mysql")) {
			Class.forName(JDBC_MYSQL);
		} else if (typeDatabase.equals("postgresql")) {
			Class.forName(JDBC_POSTGRESQL);
		}
		Connection conn;
		try {
			conn = (Connection) DriverManager.getConnection("jdbc:" + typeDatabase + "://localhost/?user=" + getUserDatabase()  + "&password=" + getPassWordDatabase());
			Statement s = conn.createStatement();
			int result = s.executeUpdate("CREATE DATABASE " + getNameDatabase());
			if (result == 1) {
				System.out.println("database " + getNameDatabase() + " created.");
			} else {
				System.out.println("error: create database");
			}
		} catch (SQLException e) {
			System.out.println("error: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("error: " + e.getMessage());
		}
	}
	
}
