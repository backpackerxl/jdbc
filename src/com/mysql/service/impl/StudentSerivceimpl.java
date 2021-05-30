package com.mysql.service.impl;

import java.util.List;
import java.util.Vector;

import com.mysql.dao.StudentDao;
import com.mysql.dao.impl.StudentDaoimpl;
import com.mysql.module.Student;
import com.mysql.service.StudentSerivce;

public class StudentSerivceimpl implements StudentSerivce {
	StudentDao dao = new StudentDaoimpl();

	@SuppressWarnings("rawtypes")
	@Override
	public List<Vector> selectAllStudents(Student stu) {
		// TODO Auto-generated method stub
		return dao.selectAllStudents(stu);
	}

	public int deleteStudent(int result) {
		// TODO Auto-generated method stub
		return dao.deleteStudent(result);
	}

	@Override
	public int updateStudent(Student stu) {
		// TODO Auto-generated method stub
		return dao.updateStudent(stu);
	}

	@Override
	public int register(Student stu) {
		// TODO Auto-generated method stub
		return dao.register(stu);
	}

}
