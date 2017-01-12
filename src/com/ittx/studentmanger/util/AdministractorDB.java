package com.ittx.studentmanger.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ittx.studentmanger.model.Administractor;
import com.ittx.studentmanger.model.Student;


public class AdministractorDB<Strimg> extends ConnectDB {
	private static AdministractorDB DB = null;

	public static AdministractorDB getInstance() {
		if (DB == null) {
			DB = new AdministractorDB();
		}
		return DB;
	}

	private AdministractorDB() {
	}
	public void addAdministractorDB(Administractor administractor) {
		String sql = "insert into administractor (name,username,password)values(?,?,?)";
		Connection connect = null;
		PreparedStatement ps = null;

		try {
			connect = getConnection();
			ps = connect.prepareStatement(sql);
			ps.setString(1,administractor.getName());
			ps.setString(2,administractor.getUserName());
			ps.setString(3,administractor.getPassWord());
			

			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			closeConnection(connect);
		}
	}

	public boolean isExistAddAdministractorByNumber(String name) {
		String sql = "SELECT * FROM administractor WHERE name = ?";
		Connection connect = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean result = false;
		try {
			connect = getConnection();
			ps = connect.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			if (rs.next()) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			closeConnection(connect);
		}

		return result;
	}

	public ArrayList<Administractor> getAllAdministractor() {
		String sql = "SELECT * FROM administractor";
		Connection connect = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Administractor> studentList = null;
		try {
			connect = getConnection();
			ps = connect.prepareStatement(sql);
			rs = ps.executeQuery();

			studentList = new ArrayList<>();
			while (rs.next()) {
				String name = rs.getString("name");
				String userName = rs.getString("userName");
				String passWord = rs.getString("passWord");

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			closeConnection(connect);
		}

		return studentList;
	}

}
