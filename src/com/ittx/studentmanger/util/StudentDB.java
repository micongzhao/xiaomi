package com.ittx.studentmanger.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.ittx.studentmanger.model.Student;

public class StudentDB extends ConnectDB {

	private static StudentDB DB = null;

	public static StudentDB getInstance() {
		if (DB == null) {
			DB = new StudentDB();
		}
		return DB;
	}

	private StudentDB() {
	}

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

	/**
	 * 显示学生列表
	 */
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

	/**
	 * 删除学生
	 */
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
	/**
	 * 删除学生
	 */
	public void deleteStudent(Student student) {
		String sql = "DELETE FROM student WHERE number = ?";
		Connection connect = null;
		PreparedStatement ps = null;
		try {
			connect = getConnection();
			ps = connect.prepareStatement(sql);
			ps.setInt(1, student.getNumber());
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
	/*
	 * 修改学生信息
	 */
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

	public boolean isExistStudent() {
		String sql = "SELECT COUNT(*) FROM student";
		Connection connect = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean result = false;
		try {
			connect = getConnection();
			ps = connect.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				if (rs.getInt(1) > 0) {
					result = true;
				}
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

	public boolean isExistStudentByNumber(int number) {
		String sql = "SELECT * FROM student WHERE number = ?";
		Connection connect = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean result = false;
		try {
			connect = getConnection();
			ps = connect.prepareStatement(sql);
			ps.setInt(1, number);
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

	public static void main(String args[]) {
		StudentDB db = StudentDB.getInstance();
		Student student = db.findStudentByNumber(1003);
		System.out.println(student);
		// System.err.println("姓名" + "\t" + "学号" + "\t" + "年龄" + "\t" + "性别");
		// Student student = db.findStudentByNumber(2002);
		// System.out.println(student.getName() + "\t" + student.getNumber()
		// + "\t" + student.getAge() + "\t"
		// + (student.isSex() ? "男" : "女"));

//		 db.addStudent(new Student("张三",1001,23,true));
//		db.testDelete(db, "");
//		db.printAllStudent(db.getAllStudent());
//		db.isExistStudent();
	}

	/**
	 * 打印List中数据s
	 * 
	 * @param studentList
	 */
	public void printAllStudent(ArrayList<Student> studentList) {
		System.err.println("姓名" + "\t" + "学号" + "\t" + "年龄" + "\t" + "性别");
		for (Student student : studentList) {
			System.out.println(student.getName() + "\t" + student.getNumber()
					+ "\t" + student.getAge() + "\t"
					+ (student.isSex() ? "男" : "女"));
		}
	}

	@SuppressWarnings("unused")
	private void testDelete(StudentDB db, String name) {
		ArrayList<Student> studentList = db.getAllStudent();
		for (Student student : studentList) {
			// if (student.getName().equals(name)) {
			db.getAllStudent();
			// }
		}
	}

}
