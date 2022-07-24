package com.kh.golabora.picked.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import static com.kh.golabora.common.JdbcTemplate.*;

import com.kh.golabora.contents.model.dto.PickedActor;
import com.kh.golabora.contents.model.dto.PickedActorExt;
import com.kh.golabora.contents.model.dto.PickedContents;
import com.kh.golabora.contents.model.dto.PickedContentsExt;
import com.kh.golabora.contents.model.dto.PickedProducer;
import com.kh.golabora.contents.model.dto.PickedProducerExt;
import com.kh.golabora.picked.Execption.PickedException;
import com.kh.golabora.picked.model.PickedDao;


public class PickedService {
	private PickedDao pickedDao = new PickedDao();

	
	public List<PickedProducerExt> findProducer() {
		Connection conn = getConnection();
		List<PickedProducerExt> list = pickedDao.findProducer(conn);
		close(conn);
		return list;
	}

	public List<PickedActorExt> findActor() {
		Connection conn = getConnection();
		List<PickedActorExt> list = pickedDao.findActor(conn);
		close(conn);
		return list;
	}
	
	public int getTotalContent() throws SQLException {
		
		Connection conn = getConnection();
		int totalContent = pickedDao.getTotalContent(conn);
		close(conn);
		
		return totalContent;
	}

	public int insertContents(PickedContents pickedContents) {
		Connection conn = getConnection();
		int result = 0;
		try {
			result = pickedDao.insertContents(conn, pickedContents);
			commit(conn);
		} catch(Exception e) {
			rollback(conn);
			throw e; // controller에 예외 던짐.
		} finally {
			close(conn);
		}
		return result;
	}

	public int insertProducer(Map<String, Object> pn) {
		
		Connection conn = getConnection();
		int result = 0;
		try {
			result = pickedDao.insertProducer(conn, pn);
			commit(conn);
		} catch(Exception e) {
			rollback(conn);
			throw e;
		} finally {
			close(conn);
		}
		return result;
		
	}

	public int insertActor(Map<String, Object> an) {
		
		Connection conn = getConnection();
		int result = 0;
		try {
			result = pickedDao.insertMember(conn, an);
			commit(conn);
		} catch(Exception e) {
			rollback(conn);
			throw e;
		} finally {
			close(conn);
		}
		return result;
	}

	
	public int deleteContents(PickedContents pickedContents) {
		Connection conn = null;
		int result = 0;
		try{
			conn = getConnection();
			result = pickedDao.deleteContents(conn, pickedContents);
			if(result == 0)
				throw new PickedException("찜하지 않았음");
			commit(conn);
		} catch (Exception e) {
			rollback(conn);
			throw e;
		} finally {
			close(conn);			
		}
		return result;
	}

	public int deleteProducer(Map<String, Object> pn) {
		Connection conn = null;
		int result = 0;
		try{
			conn = getConnection();
			result = pickedDao.deleteProducer(conn, pn);
			if(result == 0)
				throw new PickedException("찜하지 않았음");
			commit(conn);
		} catch (Exception e) {
			rollback(conn);
			throw e;
		} finally {
			close(conn);			
		}
		return result;
	}

	public int deleteActor(Map<String, Object> an) {
		Connection conn = null;
		int result = 0;
		try{
			conn = getConnection();
			result = pickedDao.deleteActor(conn, an);
			if(result == 0)
				throw new PickedException("찜하지 않았음");
			commit(conn);
		} catch (Exception e) {
			rollback(conn);
			throw e;
		} finally {
			close(conn);			
		}
		return result;
	}

	public List<PickedContentsExt> findContents() {
		Connection conn = getConnection();
		List<PickedContentsExt> list = pickedDao.findContents(conn);
		close(conn);
		return list;
	}
	
}





