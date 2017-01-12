package com.ittx.studentmanger.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;




import com.ittx.studentmanger.dao.AddAdministractorDao;
import com.ittx.studentmanger.model.Administractor;
import com.ittx.studentmanger.model.Student;

import com.ittx.studentmanger.util.AdministractorDB;
import com.ittx.studentmanger.util.ConnectDB;
public  class AddAdministractorDaompl extends ConnectDB implements AddAdministractorDao{

	@Override
	public void AddAdministractor(Administractor administractor) {
	
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

	
	@Override
	public ArrayList<Administractor> getAllUser() {
		
			String sql = "SELECT * FROM administractor";
			Connection connect = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			ArrayList<Administractor> userLists = null;
			try {
				connect = getConnection();
				ps = connect.prepareStatement(sql);
				rs = ps.executeQuery();

				userLists = new ArrayList<>();
				while (rs.next()) {
					String name = rs.getString("name");
					String userName = rs.getString("namename");
					String passWord = rs.getString("password");
					Administractor administractor = new Administractor(name,userName,passWord);
					userLists.add(administractor);
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

			return userLists;
		
	}


	public boolean isExistAddAdministractorByNumber(int name) {
		String sql = "SELECT * FROM administractor WHERE name = ?";
		Connection connect = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean result = false;
		try {
			connect = getConnection();
			ps = connect.prepareStatement(sql);
			ps.setInt(1, name);
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


	@Override
	public ArrayList<Administractor> getAllAdministractor() {
		
		return null;
	}

	
	}


