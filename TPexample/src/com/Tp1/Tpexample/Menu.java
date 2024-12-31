package com.Tp1.Tpexample;

import java.sql.Statement;
import java.util.Iterator;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Menu {
	static String userName = "root";
	static String password = "";
	static String url = "jdbc:mysql://localhost/test";
	static Connection Con;
	public static void main(String[] args) throws  SQLException {
		// TODO Auto-generated method stub
	
		try {
			//Class.forName("com.mysql.cj.jdbc.Driver");
			Con = DriverManager.getConnection(url,userName,password);
		      Statement st = Con.createStatement();
		     String queString = "Select * from person";
			ResultSet rs= st.executeQuery(queString);
			while (rs.next()) {
				String id = rs.getString(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				String Age = rs.getString(4);
				//System.out.printf(" myId : "+id+ " , my firstName : "+firstName+", my lastName :" + lastName+" my Age :" +Age);
			}
			
			ResultSetMetaData resultSetMetaData = rs.getMetaData();
			for(int i=0 ; i< resultSetMetaData.getColumnCount(); i++) {
				System.out.println(resultSetMetaData.getColumnName(i));
				System.out.println(resultSetMetaData.getColumnDisplaySize(i));
				System.out.println(resultSetMetaData.getColumnTypeName(i));
			}
			while (rs.next()) {
				for(int i=0 ; i< resultSetMetaData.getColumnCount(); i++) {
					System.out.println(rs.getString(i));
				}
			}
			//System.out.println("is Open in Succcess !!");
		//Con.close();
		}
		catch (SQLException ex) {
			// TODO: handle exception
		
			System.out.println("Connection falied :" + ex.getMessage());
		}
	
		
	}

}
