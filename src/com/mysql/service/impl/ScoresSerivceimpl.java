package com.mysql.service.impl;

import java.util.List;
import java.util.Vector;

import com.mysql.dao.ScoresDao;
import com.mysql.dao.impl.ScoresDaoimpl;
import com.mysql.module.Scores;
import com.mysql.service.ScoresService;

public class ScoresSerivceimpl implements ScoresService {
	ScoresDao dao = (ScoresDao) new ScoresDaoimpl();

	@SuppressWarnings("rawtypes")
	@Override
	public List<Vector> selectAllScores(Scores sco) {
		// TODO Auto-generated method stub
		return dao.selectAllScores(sco);
	}

	@Override
	public int deleteStudent(int result) {
		// TODO Auto-generated method stub
		return dao.deleteStudent(result);
	}

	@Override
	public int updateAdmin(Scores sco) {
		// TODO Auto-generated method stub
		return dao.updateAdmin(sco);
	}

	@Override
	public int register(Scores stu) {
		// TODO Auto-generated method stub
		return dao.register(stu);
	}

}
