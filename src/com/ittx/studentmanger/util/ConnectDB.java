package com.ittx.studentmanger.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ittx.studentmanger.dao.AddAdministractorDao;

/**
 * ��ݿ⸸��
 * 
 * 1.������ݿ���
 * 2.��������
 * 3.�ر�����
 * @author scxh
 *
 */
public class ConnectDB {
	private static final String URL = "jdbc:mysql://localhost:3306/xiaomi";
	private static final String USER = "root";
	private static final String PASSWORD = "xiaomi";

	static{
		try {
			Class.forName("com.mysql.jdbc.Driver"); //
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ������ݿ�����
	 */
	public Connection getConnection() {
		Connection connect = null;
		try {
			connect = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			System.out.println("����ʧ�ܣ�");
		}

		return connect;
	}

	/**
	 * �ر���ݿ�����
	 */
	public void closeConnection(Connection connect) {
		try {
			if (connect != null)
				connect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
