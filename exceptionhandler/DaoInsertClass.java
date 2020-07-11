package com.my.exceptionhandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class DaoInsertClass implements ExceptionHandler{

	@Override
	public void handleException(String str) {
		String exceptionCategory= str.split("\n")[0].split(": ")[1]; 
		String fullMethodString = str.split("Caused by: ")[1].split("\n")[1].split("at ")[1];
		String method = fullMethodString.split("\\(")[1];  
		String url = "DatabaseURL"; 
        String user = "DatabaseUserName"; 
        String pass = "DatabasePassword";
        Connection con =null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			con = DriverManager.getConnection(url,user,pass); 
			
			statement = con.createStatement();
			StringBuilder query =new StringBuilder();
			query.append("INSERT INTO TABLE_NAME VALUES (1,'"+exceptionCategory.trim()+"'");
			query.append(",'"+method.trim()+"'");
			query.append(",'"+fullMethodString.trim()+"'");
			query.append(",'"+str.trim().toString()+"'");
			query.append(","+1);
			query.append(","+null);
			query.append(")");
			System.out.println(query);
			statement = con.createStatement();
			resultSet = statement.executeQuery(query.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        finally {

			try
			{
				if(resultSet != null)
				{
					resultSet.close();
				}
				if(statement != null)
				{
					statement.close();
				}
				if(con != null)
				{
					con.close();
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}

		
        }
        
		
		
	}
}
