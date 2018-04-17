package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexao {
	public static String connectionDriverClass="com.mysql.jdbc.Driver";			
	public static String connectionUrl = "jdbc:mysql://localhost/banco";
	public static String connectionUsername="root";
	public static String connectionPassword="";
	public static Connection conn;				
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException		
	{
		
		if(conexao.conn != null) 
		{
			return conexao.conn;
		}else
		{
			Class.forName(connectionDriverClass);		
			return DriverManager.getConnection(			
					conexao.connectionUrl,
					conexao.connectionUsername,					
					conexao.connectionPassword);
		}
		}
}
