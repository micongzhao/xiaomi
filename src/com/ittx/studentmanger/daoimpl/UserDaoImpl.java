package com.ittx.studentmanger.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ittx.studentmanger.dao.UserDao;
import com.ittx.studentmanger.model.User;
import com.ittx.studentmanger.util.ConnectDB;

public abstract class UserDaoImpl extends ConnectDB implements UserDao{

	@Override
	public void addUser(User user) {
		
			String sql = "insert into user (username,password)values(?,?)";
			Connection connect = null;
			PreparedStatement ps = null;

			try {
				connect = getConnection();
				ps = connect.prepareStatement(sql);
				ps.setString(1, user.getUsername());				
				ps.setString(2, user.getPassword());

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
}


