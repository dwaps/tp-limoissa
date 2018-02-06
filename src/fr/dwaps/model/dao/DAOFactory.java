package fr.dwaps.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DAOFactory {
	private DAOFactory() {}
	
	static {
		try { Class.forName("com.mysql.jdbc.Driver"); }
		catch (Exception e) { e.printStackTrace(); }
	}
	
	private static String host = "localhost";
	private static String port = "3306";
	private static String dbname = "tp_library";
	private static String user = "dwaps";
	private static String password = "123456";
	
	private static String url = "jdbc:mysql://"+host+":"+port+"/"+dbname;
	
	public static Connection getConnection() {
		Connection cnx = null;
		
		try { cnx = DriverManager.getConnection(url, user, password); }
		catch (SQLException e) { e.printStackTrace(); }
		
		return cnx;
	}
	
	public static void closeConnection(Connection cnx) {
		try { cnx.close(); }
		catch (Exception e) { e.printStackTrace(); }
	}
	
	
}
