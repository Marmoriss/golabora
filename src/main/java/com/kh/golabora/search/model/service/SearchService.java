package com.kh.golabora.search.model.service;

import static com.kh.golabora.common.JdbcTemplate.close;
import static com.kh.golabora.common.JdbcTemplate.getConnection;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.kh.golabora.contents.model.dto.Contents;
import com.kh.golabora.contents.model.dto.ContentsWithActor;
import com.kh.golabora.contents.model.dto.ContentsWithProducer;
import com.kh.golabora.search.model.dao.SearchDao;

public class SearchService {
	private SearchDao searchDao = new SearchDao();

	public List<Contents> findContentsByOttNo(String[] ottNo) {
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

	public List<Contents> findContentsbyContentsTitle(Map<String, Object> param) {
		Connection conn = getConnection();
		List<Contents> list = searchDao.findContentsbyContentsTitle(conn, param);
		close(conn);
		return list;
	}

	public List<ContentsWithProducer> findContentsbyProducerName(Map<String, Object> param) {
		Connection conn = getConnection();
		List<ContentsWithProducer> list = searchDao.findContentsbyProducerName(conn, param);
		close(conn);
		return list;
	}

	public List<ContentsWithActor> findContentsbyActorName(Map<String, Object> param) {
		Connection conn = getConnection();
		List<ContentsWithActor> list = searchDao.findContentsbyActorName(conn, param);
		close(conn);
		return list;
	}

}
