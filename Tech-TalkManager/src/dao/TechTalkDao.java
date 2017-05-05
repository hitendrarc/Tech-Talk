package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import pojo.TechTalk;
import util.DBConnection;

public class TechTalkDao {

	public List<TechTalk> getList() {
		Connection con = null;
		PreparedStatement preparedStatement = null;
		List<TechTalk> list = new ArrayList<>();
		try {
			con = DBConnection.createConnection();
			String query = "select * from techtalk;";
			preparedStatement = con.prepareStatement(query);

			ResultSet rs = preparedStatement.executeQuery();
			System.out.println(rs);
			while (rs.next()) {
				list.add(new TechTalk(rs.getInt("id"), rs.getString("date"), rs.getString("title"),
						rs.getString("description"), rs.getString("presentor")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public TechTalk getTechTalk(int id) {
		Connection con = null;
		PreparedStatement preparedStatement = null;

		try {
			con = DBConnection.createConnection();
			String query = "select * from techtalk where id=?;";
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			TechTalk tt = null;
			while (rs.next()) {
				tt = new TechTalk(rs.getString("date"), rs.getString("title"), rs.getString("description"),
						rs.getString("presentor"));

			}
			return tt;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
}