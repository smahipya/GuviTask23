package GuviTask23;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Ans_01 {

	public static void main(String[] args) throws SQLException {
		
		String URL = "jdbc:mysql://localhost"+":"+3306+"/guvitasks ";
		String username = "root";
		String password = "Testuser@123";
		
		Connection conn = DriverManager.getConnection(URL, username, password) ;
		

		String createTableSQL = "CREATE TABLE IF NOT EXISTS employee (" + "empcode INT PRIMARY KEY,"
				+ "empname VARCHAR(255) NOT NULL,"
				+ "empage INT NOT NULL,"
				+ "esalary DECIMAL(10,2) NOT NULL"
				+ ")";

		String insertRecords = "INSERT INTO employee (empcode, empname, empage, esalary) VALUES (?, ?, ?, ?)";

			Statement statement = conn.createStatement();
			statement.execute(createTableSQL);
			System.out.println("Table 'employee' created (if it didn't exist).");

		
			PreparedStatement preparedStatement = conn.prepareStatement(insertRecords);

			
			int[] empCodes = { 101, 102, 103, 104, 105 };
			String[] empNames = { "Jenny", "Jacky", "Joe", "John", "Shameer" };
			int[] empAges = { 25, 30, 20, 40, 25 };
			double[] empSalaries = { 10000.00, 20000.00, 40000.00, 80000.00, 90000.00 };

			for (int i = 0; i < empCodes.length; i++) {
				preparedStatement.setInt(1, empCodes[i]);
				preparedStatement.setString(2, empNames[i]);
				preparedStatement.setInt(3, empAges[i]);
				preparedStatement.setDouble(4, empSalaries[i]);
				preparedStatement.executeUpdate();
			}

			System.out.println("Records inserted successfully!");
    }
		}

