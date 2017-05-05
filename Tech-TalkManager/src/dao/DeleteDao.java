package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.DBConnection;

public class DeleteDao {

	public String deleteTechTalk(String title) {

		Connection con = null;
		PreparedStatement preparedStatement = null;

		try {
			con = DBConnection.createConnection();
			String query = "delete from techtalk where title=?;";
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, title);

			int i = preparedStatement.executeUpdate();

			if (i != 0) // Just to ensure data has been inserted into the
				// database
				return "SUCCESS";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Oops.. Something went wrong there..!"; // On failure, send a
		// message from here.
	}
}