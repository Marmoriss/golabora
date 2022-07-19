package com.kh.golabora.contents.model.service;

import static com.kh.golabora.common.JdbcTemplate.close;
import static com.kh.golabora.common.JdbcTemplate.commit;
import static com.kh.golabora.common.JdbcTemplate.getConnection;
import static com.kh.golabora.common.JdbcTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.kh.golabora.contents.model.dao.ContentsDao;
import com.kh.golabora.contents.model.dto.Contents;


public class ContentsService {
	private ContentsDao ContentsDao = new ContentsDao();

	
	public int insertContents(Contents contents) {
		Connection conn = getConnection();
		int result = 0;
		try {
			result = ContentsDao.insertContents(conn, contents);
			commit(conn);
		} catch(Exception e) {
			
		} finally {
			close(conn);
		}
		return result;
	}
}
