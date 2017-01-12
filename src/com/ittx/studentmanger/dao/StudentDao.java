package com.ittx.studentmanger.dao;
import java.util.ArrayList;

import com.ittx.studentmanger.model.Student;



public abstract interface StudentDao {
 void addStudent(Student student);//添加学生；  
 void deleteStudentNumber(int number);//根据学号查找学生
 void updateStudent(Student student);//修改学生信息
 Student findStudentByNumber(int number);//根据学号查找学生
 public ArrayList<Student> getAllStudent();//显示学生
 
}
