package com.ittx.studentmanger.daoimpl;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
public class StudentDaoImplTest {

  Logger log=Logger.getLogger(StudentDaoImplTest.class);
private StudentDaoImpl studentdaoimpl=new StudentDaoImpl();
	@Before
	public void setUp() throws Exception {
	}

	@Test
//	public void testAddStudent() {  
//		Student student=new Student("壮壮",1234,12,false,"");
//		studentdaoimpl.addStudent(student);
//	}
	public void testdeleStudent(){
	studentdaoimpl.deleteStudentNumber(123);
	log.debug("efefe");
	log.info("fdfdsf"); 
	log.error("错误");
	}
}
