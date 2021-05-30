package com.mysql.dao;

import java.util.List;
import java.util.Vector;

import com.mysql.module.Scores;

public interface ScoresDao {

	@SuppressWarnings("rawtypes")
	List<Vector> selectAllScores(Scores sco);

	int deleteStudent(int result);

	int updateAdmin(Scores sco);

	int register(Scores stu);

}
