package com.jspiders.jdbc1.project1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Employee {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
    	String className="com.mysql.cj.jdbc.Driver";
    
    	String url="jdbc:mysql://localhost:3306/employeedb?user=root&password=root";
    	String query="INSERT INTO EMPLOYEE VALUE"
//    			+ "(1,'KUNAL',781921054,'KUNAL@GMAIL.COM',1122,'AMRAVATI'),"
//    			+ "(2,'MRUNAL',781921854,'MRUUNAL@GMAIL.COM',1144,'AMRAVATI')"
    			+ "(9z,'SHIVA',7822111223,'SHIVA2.5@GMAIL.COM',1124,'DELHI')";
    	
    	Class.forName(className);
    	Connection connection=DriverManager.getConnection(url);
    	Statement statement=connection.createStatement();
    	statement.execute(query);
    	connection.close();  	
	}
}
