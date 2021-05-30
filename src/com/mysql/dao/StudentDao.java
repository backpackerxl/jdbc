package com.mysql.dao;

import java.util.List;
import java.util.Vector;

import com.mysql.module.Student;

public interface StudentDao {

	@SuppressWarnings("rawtypes")
	List<Vector> selectAllStudents(Student stu);

	int deleteStudent(int result);

	int updateStudent(Student stu);

	int register(Student stu);

}
