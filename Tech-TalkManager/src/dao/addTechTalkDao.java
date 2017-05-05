package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import pojo.TechTalk;
import util.DBConnection;

public class addTechTalkDao {

	public String addTechTalk(TechTalk tt) {

		Connection con = null;
		PreparedStatement preparedStatement = null;

		try {
			con = DBConnection.createConnection();
			String query = "insert into techtalk(date,title,description,presentor) values (?,?,?,?)";
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, tt.getDate());
			preparedStatement.setString(2, tt.getTitle());
			preparedStatement.setString(3, tt.getDescription());
			preparedStatement.setString(4, tt.getPresentor());

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

	public String updateTechTalk(TechTalk tt) {
		Connection con = null;
		PreparedStatement preparedStatement = null;

		try {
			con = DBConnection.createConnection();
			String query = "update techtalk set date=?, title=?,description=?,presentor=? where presentor=?";
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, tt.getDate());
			preparedStatement.setString(2, tt.getTitle());
			preparedStatement.setString(3, tt.getDescription());
			preparedStatement.setString(4, tt.getPresentor());
			preparedStatement.setString(5, tt.getPresentor());
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