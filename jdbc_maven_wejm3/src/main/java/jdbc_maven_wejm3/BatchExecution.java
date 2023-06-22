package jdbc_maven_wejm3;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class BatchExecution {
	public static void main(String[] args) throws Exception {
		Product product1 = new Product();
		product1.setId(11);
		product1.setName("TV");
		product1.setCost(15000);
		product1.setManufacture("sony");

		Product product2 = new Product();
		product2.setId(2);
		product2.setName("laptop");
		product2.setCost(25000);
		product2.setManufacture("HP");

		Product product3 = new Product();
		product3.setId(3);
		product3.setName("AC");
		product3.setCost(34000);
		product3.setManufacture("bulestar");

		Product product4 = new Product();
		product4.setId(4);
		product4.setName("Kayboard");
		product4.setCost(800);
		product4.setManufacture("Logitic");

		Product product5 = new Product();
		product5.setId(5);
		product5.setName("Mobile");
		product5.setCost(25000);
		product5.setManufacture("iphone");

		List<Product> list = new ArrayList<Product>();
		list.add(product1);
		list.add(product2);
		list.add(product3);
		list.add(product4);
		list.add(product5);

		Driver driver = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);

		FileInputStream fileInputStream = new FileInputStream("productdb.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);

		Connection connection = DriverManager.getConnection(properties.getProperty("url"),
				properties.getProperty("user"), properties.getProperty("password"));
		PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO PRODUCT VALUES(?,?,?,?)");
		for (Product product : list) {
			preparedStatement.setInt(1, product.getId());
			preparedStatement.setString(2, product.getName());
			preparedStatement.setInt(3, product.getCost());
			preparedStatement.setString(4, product.getManufacture());
			preparedStatement.addBatch();
		}

		preparedStatement.executeBatch();
		System.out.println("Batch execution is Done");
		connection.close();

	}
}
