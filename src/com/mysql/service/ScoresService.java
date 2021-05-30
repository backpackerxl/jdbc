package com.mysql.service;

import java.util.List;
import java.util.Vector;

import com.mysql.module.Scores;

public interface ScoresService {

	@SuppressWarnings("rawtypes")
	List<Vector> selectAllScores(Scores sco);

	int deleteStudent(int result);

	int updateAdmin(Scores sco);

	int register(Scores stu);

}
