package com.kh.golabora.contents.model.dao;

import static com.kh.golabora.common.JdbcTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.kh.golabora.contents.model.dto.Contents;
import com.kh.golabora.contents.model.dto.ContentsInfo;
import com.kh.golabora.contents.model.exception.ContentsException;
import com.kh.golabora.review.model.dto.Review;
import com.kh.golabora.review.model.exception.ReviewException;


public class ContentsDao {

	private Properties prop = new Properties();
	/**
	 * 주희 코드 시작
	 */
	public ContentsDao() {
		String filename = ContentsDao.class.getResource("/sql/contents/contents-query.properties").getPath();
		try {
			prop.load(new FileReader(filename));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 주희 코드 끝
	 */
	
	/**
	 * 은미 코드 시작
	 */
	public int insertContents(Connection conn, Contents contents) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("insertContents");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, contents.getGenreCode());
			pstmt.setInt(2, contents.getWatchableAge());
			pstmt.setString(3, contents.getContentsTitle());
			pstmt.setString(4, contents.getReleaseDate());
			pstmt.setString(5, contents.getRunningTime());
			pstmt.setString(6, contents.getContentsPlot());
			pstmt.setString(7, contents.getOriginalFilename());
			pstmt.setString(8, contents.getRenamedFilename());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new ContentsException("영화등록 오류", e);
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	/**
	 * 은미 코드 끝
	 */

	/**
	 * 주희 코드 시작
	 */
	public List<ContentsInfo> findOneContents(Connection conn, String contentsNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("findOneContents");
		List<ContentsInfo> detailPage = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, contentsNo);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				ContentsInfo contents = handleContentsInfoRset(rset);
				detailPage.add(contents);
			}
			
		} catch (SQLException e) {
			throw new ContentsException("콘텐츠 상세정보 조회 오류!", e);
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return detailPage;
	}

	private ContentsInfo handleContentsInfoRset(ResultSet rset) throws SQLException{
		String contentsNo = rset.getString("contents_no");
		int watchableAge = rset.getInt("watchable_age");
		String contentsTitle = rset.getString("contents_title");
		String releaseDate = rset.getString("release_date");
		String runningTime = rset.getString("running_time");
		String contentsPlot = rset.getString("contents_plot");
		String originalFilename = rset.getString("original_filename");
		String renamedFilename = rset.getString("renamed_filename");
		String genreName = rset.getString("genre_name");
		String ottName = rset.getString("ott_name");
		String actorName = rset.getString("actor_name");
		String producerName = rset.getString("producer_name");
		
		ContentsInfo contents = new ContentsInfo(contentsNo, watchableAge, 
				contentsTitle, releaseDate, runningTime, contentsPlot, 
				originalFilename, renamedFilename, genreName, ottName, 
				actorName, producerName);
		
		return contents;
	}

	public List<String> findOttNameByContentsTitle(Connection conn, String contentsTitle) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("findOttNameByContentsTitle");
		List<String> ottNames = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, contentsTitle);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				String ottName = rset.getString(1);
				
				ottNames.add(ottName);
			}
		} catch (SQLException e) {
			throw new ContentsException("Ottname 조회 오류!", e);
		} finally {
			close(rset);
			close(pstmt);
		}
		return ottNames;
	}
	
	/**
	 * 주희 코드 끝
	 */
	
	/**
	 * 수아 코드 시작
	 */
	
	//리뷰 resultSet
		private Review handleReviewResultSet(ResultSet rset) throws SQLException {
			String reviewNo = rset.getString("review_no");
			String memberId = rset.getString("member_id");
			String contentsNo = rset.getString("contents_no");
			String reviewContent = rset.getString("review_content");
			int star = rset.getInt("star");
			Date regDate = rset.getDate("reg_date");
			
			return new Review(reviewNo, memberId, contentsNo, reviewContent, star, regDate);
		}
		
	//콘텐츠 별 전체리뷰목록 조회
		public List<Review> findReviewByContentsNo(Connection conn, Map<String, Object> param) {
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			List<Review> reviewList = new ArrayList<>();
			String sql = prop.getProperty("findReviewByContentsNo");
			//select * from(select row_number () over (order by reg_date desc) rnum,  r.*  from  review r  where contents_no =?)r where rnum between ? and ?
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, (String)param.get("contentsNo"));
				pstmt.setInt(2, (int)param.get("start"));
				pstmt.setInt(3, (int)param.get("end"));
				
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					Review review = handleReviewResultSet(rset);
					reviewList.add(review);
				}
			} catch (SQLException e) {
				throw new ReviewException("콘텐츠별 리뷰 조회 오류!", e);
			} finally {
				close(rset);
				close(pstmt);
			}
		
			return reviewList;
		}

		//콘텐츠 별 리뷰 갯수 조회
		public int getTotalReviewByContentsNo(Connection conn, String contentsNo) {
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			int totalReviewByContentsNo = 0;
			String sql = prop.getProperty("getTotalReviewByContentsNo");
			//select count(*) from review where contents_no = ?
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, contentsNo);
				rset = pstmt.executeQuery();
				while(rset.next())
					totalReviewByContentsNo = rset.getInt(1);
			} catch (SQLException e) {
				throw new ReviewException("콘텐츠 별 전체 리뷰 수 조회 오류!", e);
			} finally {
				close(rset);
				close(pstmt);
			}
			
			return totalReviewByContentsNo;
		}
	
	
	/**
	 * 수아 코드 끝
	 */
}
