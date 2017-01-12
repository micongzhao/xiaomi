package com.ittx.studentmanger.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ittx.studentmanger.dao.StudentDao;
import com.ittx.studentmanger.model.Student;
import com.ittx.studentmanger.util.ConnectDB;



public   class StudentDaoImpl extends ConnectDB implements StudentDao {

	@Override
	public void addStudent(Student student) {
		String sql = "insert into student (name,number,age,sex,img)values(?,?,?,?,?)";
		Connection connect = null;
		PreparedStatement ps = null;

		try {
			connect = getConnection();
			ps = connect.prepareStatement(sql);
			ps.setString(1, student.getName());
			ps.setInt(2, student.getNumber());
			ps.setInt(3, student.getAge());
			ps.setBoolean(4, student.isSex());
			ps.setString(5, student.getImg());

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
	
	public void deleteStudentNumber(int number) {
		String sql = "DELETE FROM student WHERE number = ?";
		Connection connect = null;
		PreparedStatement ps = null;
		try {
			connect = getConnection();
			ps = connect.prepareStatement(sql);
			ps.setInt(1, number);
			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			closeConnection(connect);
		}
	}
		
	

	@Override
	public void updateStudent(Student student){
		String sql = "UPDATE student SET name=?,age=?,sex=? where number=?";
		Connection connect = null;
		PreparedStatement ps = null;

		try {
			connect = getConnection();
			ps = connect.prepareStatement(sql);

			ps.setString(1, student.getName());
			ps.setInt(2, student.getAge());
			ps.setBoolean(3, student.isSex());
			ps.setInt(4, student.getNumber());

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
	public Student findStudentByNumber(int number) {
		String sql = "SELECT * FROM student WHERE number = ?";
		Connection connect = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Student student = null;
		try {
			connect = getConnection();
			ps = connect.prepareStatement(sql);
			ps.setInt(1, number);
			rs = ps.executeQuery();
			if (rs.next()) {
				String name = rs.getString("name");
				int nums = rs.getInt("number");
				int age = rs.getInt("age");
				boolean sex = rs.getBoolean("sex");
				String img=rs.getString("img");
				student = new Student( name, nums, age, sex,img);
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

		return student;
	}

	@Override
	public ArrayList<Student> getAllStudent() {
		String sql = "SELECT * FROM student";
		Connection connect = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Student> studentList = null;
		try {
			connect = getConnection();
			ps = connect.prepareStatement(sql);
			rs = ps.executeQuery();

			studentList = new ArrayList<>();
			while (rs.next()) {
				String name = rs.getString("name");
				int number = rs.getInt("number");
				int age = rs.getInt("age");
				boolean sex = rs.getBoolean("sex");
				String img = rs.getString("img");

				Student student = new Student(name, number, age, sex,img);
				studentList.add(student);
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
