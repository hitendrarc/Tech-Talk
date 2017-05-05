package dao;

import java.sql.*;

import pojo.Employee;
import util.DBConnection;

public class LoginDao {

	public String validateUser(Employee emp) {
		Connection con = null;
		PreparedStatement preparedStatement = null;

		try {
			con = DBConnection.createConnection();
			String query = "select * from employee where userName=? and password=?;";
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, emp.getUserName());
			preparedStatement.setString(2, emp.getPassword());
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				if (rs.getString("userName").equals(emp.getUserName())
						&& rs.getString("password").equals(emp.getPassword())) {
					System.out.println(rs.getString("userName"));
					return "SUCCESS";
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Oops.. Something went wrong there..!"; // On failure, send a
		// message from here.
	}
}