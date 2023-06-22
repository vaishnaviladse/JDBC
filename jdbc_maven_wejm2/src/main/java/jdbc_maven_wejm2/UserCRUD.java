package jdbc_maven_wejm2;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class UserCRUD {
	public Connection getConnection() throws Exception {
		FileInputStream fileInputStream = new FileInputStream("dbuser.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);

		Class.forName(properties.getProperty("className"));
		Connection connection = DriverManager.getConnection(properties.getProperty("url"),
				properties.getProperty("user"), properties.getProperty("password"));
		return connection;

	}

	public void signupUser(User user) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("INSERT INTO USER(ID,NAME,EMAIL,PASSWORD,ADDRESS)VALUES(?,?,?,?,?)");
		preparedStatement.setInt(1, user.getId());
		preparedStatement.setString(2, user.getName());
		preparedStatement.setString(3, user.getEmail());
		preparedStatement.setString(4, user.getPassword());
		preparedStatement.setString(5, user.getAddress());

		int count = preparedStatement.executeUpdate();
		if (count == 1) {
			System.out.println("Signed Up Successfully");
		} else {
			System.out.println("Failed to Sign Up");
		}
		connection.close();
	}

	public boolean loginUser(String email, String password) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT PASSWORD FROM USER WHERE EMAIL=?");
		preparedStatement.setString(1, email);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			String dbpassword = resultSet.getString(1);

			if (dbpassword.equals(password)) {
				return true;

			} else {
				return false;
			}
		} else {
			return false;

		}
	}

	public void updateFacebookPassword(String password, String email) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("UPDATE USER SET FACEBOOK=? WHERE EMAIL=?");
		preparedStatement.setString(1, password);
		preparedStatement.setString(2, email);
		int count = preparedStatement.executeUpdate();
		if (count == 1) {
			System.out.println("Password added successfully...!!!!");
		} else {
			System.out.println("Failed to add password.......try again later.!!");
		}
		connection.close();
	}

	public void updateWhatappPassword(String password, String email) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("UPDATE USER SET WHATAPP=? WHERE EMAIL=?");
		preparedStatement.setString(1, password);
		preparedStatement.setString(2, email);
		int count = preparedStatement.executeUpdate();
		if (count == 1) {
			System.out.println("Password added successfully...!!!!");
		} else {
			System.out.println("Failed to add password.......try again later.!!");
		}
		connection.close();
	}

	public void updateSnapchatPassword(String password, String email) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("UPDATE USER SET SNAPCHAT=? WHERE EMAIL=?");
		preparedStatement.setString(1, password);
		preparedStatement.setString(2, email);
		int count = preparedStatement.executeUpdate();
		if (count == 1) {
			System.out.println("Password added successfully...!!!!");
		} else {
			System.out.println("Failed to add password.......try again later.!!");
		}
		connection.close();
	}

	public void updateTwitterPassword(String password, String email) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("UPDATE USER SET TWITER=? WHERE EMAIL=?");
		preparedStatement.setString(1, password);
		preparedStatement.setString(2, email);
		int count = preparedStatement.executeUpdate();
		if (count == 1) {
			System.out.println("Password added successfully...!!!!");
		} else {
			System.out.println("Failed to add password.......try again later.!!");
		}
		connection.close();
	}

	public void updateInstagramPassword(String password, String email) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("UPDATE USER SET INSTAGRAM=? WHERE EMAIL=?");
		preparedStatement.setString(1, password);
		preparedStatement.setString(2, email);
		int count = preparedStatement.executeUpdate();
		if (count == 1) {
			System.out.println("Password added successfully...!!!!");
		} else {
			System.out.println("Failed to add password.......try again later.!!");
		}
		connection.close();
	}

}
