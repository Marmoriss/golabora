package com.kh.golabora.contents.model.service;

import static com.kh.golabora.common.JdbcTemplate.*;

import java.sql.Connection;
import java.util.List;

import com.kh.golabora.contents.model.dao.ContentsDao;
import com.kh.golabora.contents.model.dto.Contents;
import com.kh.golabora.contents.model.dto.ContentsInfo;


public class ContentsService {
	private ContentsDao contentsDao = new ContentsDao();

	
	public int insertContents(Contents contents) {
		Connection conn = getConnection();
		int result = 0;
		try {
			result = contentsDao.insertContents(conn, contents);
			commit(conn);
		} catch(Exception e) {
			
		} finally {
			close(conn);
		}
		return result;
	}

/**
 * 주희 코드 시작
 */
	
	public List<ContentsInfo> findOneContents(String contentsNo) {
		Connection conn = getConnection();
		List<ContentsInfo> detailPage = contentsDao.findOneContents(conn, contentsNo);
		close(conn);
		return detailPage;
	}
	
/**
 * 주희 코드 끝
 */
}
