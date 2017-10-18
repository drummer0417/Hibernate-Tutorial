package nl.adroidappfactory.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {

		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String user = "hbstudent";
		String pw = "hbstudent";

		try {
			System.out.println("Connecting to mySql database: " + jdbcUrl);

			Connection connection = DriverManager.getConnection(jdbcUrl, user, pw);

			System.out.println("Connected successful");

		} catch (Exception e) {
			System.out.println("Connection failed: " + e.getMessage());

		}

	}

}
