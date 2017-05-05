package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojo.Users;
import util.DBConnection;

public class RegisterUserDao {

	public String registerUser(String email, String title) {

		Connection con = null;
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatement2 = null;

		try {
			con = DBConnection.createConnection();
			String query = "insert into registeredUsers(email,name) values (?,?)";
			String query2 = "select email from registeredUsers where email=? and name=?";
			preparedStatement2 = con.prepareStatement(query2);
			preparedStatement2.setString(1, email);
			preparedStatement2.setString(2, title);
			if (!preparedStatement2.executeQuery().next()) {
				preparedStatement = con.prepareStatement(query);
				preparedStatement.setString(1, email);
				preparedStatement.setString(2, title);

				int i = preparedStatement.executeUpdate();

				if (i != 0)
					return "SUCCESS";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Oops.. Something went wrong there..!";
	}

	public List<Users> getUsers() {
		Connection con = null;
		PreparedStatement preparedStatement = null;

		try {
			con = DBConnection.createConnection();
			String query = "select * from registeredUsers";
			preparedStatement = con.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			List<Users> list = new ArrayList<>();
			while (rs.next())
				list.add(new Users(rs.getString("email"), rs.getString("name")));
			System.out.println(list);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}