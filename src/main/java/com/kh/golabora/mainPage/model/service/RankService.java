package com.kh.golabora.mainPage.model.service;

import static com.kh.golabora.common.JdbcTemplate.*;

import java.sql.Connection;
import java.util.List;

import com.kh.golabora.contents.model.dto.Contents;
import com.kh.golabora.mainPage.model.dao.RankDao;

public class RankService {

	private RankDao rankDao = new RankDao();
	
	public List<Contents> rankNet() {
		Connection conn = getConnection();
		List<Contents> rank = rankDao.rankNet(conn);
		
		close(conn);
		
		return rank;
	}
	
	public List<Contents> rankWav() {
		Connection conn = getConnection();
		List<Contents> rank = rankDao.rankWav(conn);
		
		close(conn);
		
		return rank;
	}

	public List<Contents> rankWat() {
		Connection conn = getConnection();
		List<Contents> rank = rankDao.rankWat(conn);
		
		close(conn);
		
		return rank;
	}
	
}
