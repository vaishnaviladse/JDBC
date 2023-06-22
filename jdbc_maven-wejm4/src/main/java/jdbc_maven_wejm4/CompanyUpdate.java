package jdbc_maven_wejm4;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class CompanyUpdate {
public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
	Scanner scanner=new Scanner(System.in);
	System.out.println("Enter the id");
	int id=scanner.nextInt();
	System.out.println("Enter the name");
	String name=scanner.next();
	System.out.println("Enter the gst");
	String gst=scanner.next();
	System.out.println("Enter the address");
	String address=scanner.next();
	System.out.println("Enter the phone");
	long phone=scanner.nextLong();
	FileInputStream fileInputStream=new FileInputStream("companydb.properties");
	Properties properties=new Properties();
	properties.load(fileInputStream);
	
	Class.forName(properties.getProperty("className"));
	Connection connection=DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("user"),properties.getProperty("password"));
	CallableStatement callableStatement=connection.prepareCall("call companydb.company_update(?,?,?,?,?)");
	
	callableStatement.setInt(1,id);
	callableStatement.setString(2, name);
	callableStatement.setString(3, gst);
	callableStatement.setString(4, address);
	callableStatement.setLong(5, phone);
	
	int count=callableStatement.executeUpdate();
	if (count==1) {
		System.out.println("Updated Successfully..!!!");
	}else {
		System.out.println("Not Updated");
	}
	connection.close();
	scanner.close();
	
}
}
