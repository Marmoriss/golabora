package com.kh.golabora.search.model.service;

import static com.kh.golabora.common.JdbcTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.kh.golabora.contents.model.dto.Contents;
import com.kh.golabora.search.model.dao.SearchDao;

public class SearchService {
	private SearchDao searchDao = new SearchDao();

	public List<Contents> findContentsByOttNo(String ottNo) {
		Connection conn = getConnection();
		List<Contents> list = searchDao.findContentsByOttNo(conn, ottNo);
		close(conn);
		
		return list;
	}

	public List<Contents> findContentsByGenreCode(String[] genreCode) {
		Connection conn = getConnection();
		List<Contents> list = searchDao.findContentsByGenreCode(conn, genreCode);
		close(conn);
		return list;
	}

}
