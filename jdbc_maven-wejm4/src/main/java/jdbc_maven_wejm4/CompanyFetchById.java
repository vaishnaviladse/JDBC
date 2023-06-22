package jdbc_maven_wejm4;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class CompanyFetchById {
 public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
	Scanner scanner=new Scanner(System.in);
	System.out.println("Enter the id");
	int id=scanner.nextInt();
	  FileInputStream fileInputStream=new FileInputStream("companydb.properties");
	  Properties properties=new Properties();
	  properties.load(fileInputStream);
	  
	  Class.forName(properties.getProperty("className"));
	  Connection connection=DriverManager.getConnection(properties.getProperty("url"),
			  properties.getProperty("user"),properties.getProperty("password"));
		CallableStatement callableStatement = connection
				.prepareCall("call companydb.company_fetch_by_id(?)");
	  callableStatement.setInt(1,id);
	  ResultSet resultSet=callableStatement.executeQuery();
	  while(resultSet.next()) {
		  System.out.println(resultSet.getInt(1));   
		  System.out.println(resultSet.getString("name"));
		  System.out.println(resultSet.getString(3));
		  System.out.println(resultSet.getString(4));
		  System.out.println(resultSet.getLong(5));
		  
	  }
	 connection.close(); 
	 scanner.close();
}
}
