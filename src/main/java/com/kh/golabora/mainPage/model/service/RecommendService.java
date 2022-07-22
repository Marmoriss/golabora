package com.kh.golabora.mainPage.model.service;

import static com.kh.golabora.common.JdbcTemplate.*;

import java.sql.Connection;
import java.util.List;

import com.kh.golabora.contents.model.dto.Contents;
import com.kh.golabora.mainPage.model.dao.RecommendDao;

public class RecommendService {
	
	private RecommendDao recommendDao = new RecommendDao();

	public List<Contents> recommendContents() {
		Connection conn = getConnection();
		List<Contents> recommend = recommendDao.recommendContents(conn);
		
		close(conn);
		
		return recommend;
	}

}
