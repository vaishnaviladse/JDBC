package com.jspiders.jdbc1.project1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertEmployee {
  public static void main(String[] args) throws ClassNotFoundException, SQLException {
	String className="com.mysql.cj.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/employeedb?user=root&password=root";
	String query="INSERT INTO EMPLOYEE VALUES (7,'PRAJAL',4587654510,'PRAJWAL@GMAIL.COM',2331,'PUNE')";
	
	Class.forName(className);
	Connection connection=DriverManager.getConnection(url);
	Statement statement=connection.createStatement();
	
	statement.execute(query);
	connection.close();
}
  
}
