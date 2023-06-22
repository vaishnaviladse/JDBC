package com.jspiders.jdbc1.project1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDelete {
	 public static void main(String[] args) throws ClassNotFoundException, SQLException {
			
	    	String className="com.mysql.cj.jdbc.Driver";
	    	
	    	String url="jdbc:mysql://localhost:3306/employeedb?user=root&password=root";
	    	String query="DELETE FROM EMPLOYEE WHERE ID=3";
	    	
	    	Class.forName(className);
	    	Connection  connection=DriverManager.getConnection(url);
	    	Statement statement=connection.createStatement();
	    	int res=statement.executeUpdate(query);
	    	if(res==1) {
	    		System.out.println("STATEMENT IS DELETED");
	    	}else {
	    		System.out.println("STATEMENT IS NOT DELETED ");
	    	}
	    	
	    	connection.close();
}
}
