package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import pojo.Employee;
import util.DBConnection;

public class RegisterDao {

	public String registerUser(Employee emp) {
		String fullName = emp.getName();
		String userName = emp.getUserName();
		String password = emp.getPassword();

		Connection con = null;
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatement2 = null;

		try {
			con = DBConnection.createConnection();
			String query = "insert into employee(name,userName,password) values (?,?,?)";
			String query2 = "select userName from employee where userName=?";
			preparedStatement2 = con.prepareStatement(query2);
			preparedStatement2.setString(1, userName);
			if (!preparedStatement2.executeQuery().next()) {
				preparedStatement = con.prepareStatement(query);
				preparedStatement.setString(1, fullName);
				preparedStatement.setString(2, userName);
				preparedStatement.setString(3, password);

				int i = preparedStatement.executeUpdate();

				if (i != 0)
					return "SUCCESS";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "User already exists..!";
	}
}