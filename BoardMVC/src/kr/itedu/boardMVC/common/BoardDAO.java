package kr.itedu.boardMVC.common;

import static kr.itedu.boardMVC.common.DBConnector.close;
import static kr.itedu.boardMVC.common.DBConnector.getConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import kr.itedu.boardMVC.BoardVO;

public class BoardDAO {
	
	private static BoardDAO dao;
	
	private BoardDAO() {}	//외부에서 쓸려면 getInstance()로만 쓸수있다

	public static BoardDAO getInstance() { //싱글톤 패턴
		if(dao == null) {
			dao = new BoardDAO();
		}
		return dao;
	}
	public ArrayList<BoardVO> getAllBoardList(int btype){
		ArrayList<BoardVO> result = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = getConn();
			String tName = "";
			if(btype==1) {
				tName = "t_board";
			} else if(btype==2 || btype==3) {
				tName= "t_board"+btype;
			} 
			String query = String.format("select bid, btitle ,to_char(bregdate," +
							"  'YYYY-MM-DD hh24:mi') as bregdate from %s ORDER BY bid desc", tName);
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setBid(rs.getInt("bid"));
				vo.setBregdate(rs.getString("bregdate"));
				vo.setBtitle(rs.getString("btitle"));
				result.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn,ps,rs);
		}
		return result;
	}
	//BoardDAO dao = BoardDAO.getInstance(); -- 항상 같은 주소값이 넘어옴
	public void deleteList(int bid,int btype) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			String tName = "";
			if(btype==1) {
				tName = "t_board";
			} else if(btype==2 || btype==3) {
				tName= "t_board"+btype;
			} 
			conn = DBConnector.getConn();
			String query = String.format(" delete from %s where bid = " + bid,tName);
			ps = conn.prepareStatement(query);
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBConnector.close(conn, ps, null);
		}
		
	}
	
	public BoardVO getBoardList(int bid,int btype) {
		BoardVO vo = new BoardVO();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String tName = "";
			if(btype==1) {
				tName = "t_board";
			} else if(btype==2 || btype==3) {
				tName= "t_board"+btype;
			} 
			 conn = DBConnector.getConn();
			String query = String.format("select  btitle, bcontent, to_char(bregdate,"
							+ "  'YYYY-MM-DD hh24:mi') as bregdate, "
							+ "  to_char(bmodidate, 'YYYY-MM-DD hh24:mi') as bmodidate "
							+ " from %s where bid = " + bid,tName);
			 ps = conn.prepareStatement(query);
			 rs = ps.executeQuery();
			while(rs.next()) {
				vo.setBtitle(rs.getString("btitle"));
				vo.setBcontent(rs.getString("bcontent"));
				vo.setBregdate(rs.getString("bregdate"));
				vo.setBmodidate(rs.getString("bmodidate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.close(conn,  ps, rs);
		}
		return vo;
	}
	public void insertList(BoardVO vo,int btype) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			String tName = "";
			if(btype==1) {
				tName = "t_board";
			} else if(btype==2 || btype==3) {
				tName= "t_board"+btype;
			} 
			conn = DBConnector.getConn();
			String query = String.format("insert into %s (bid, btitle, bcontent) values ((select nvl(max(bid),0)+1 from %s), ?, ?) ",tName,tName);
			ps = conn.prepareStatement(query);
			ps.setString(1, vo.getBtitle());
			ps.setString(2, vo.getBcontent());
			ps.execute();
		}catch(Exception e){
			e.printStackTrace();
		} finally {
			DBConnector.close(conn,  ps, null);
		}
	}
	public void updateList(BoardVO vo ,int btype) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			String tName = "";
			if(btype==1) {
				tName = "t_board";
			} else if(btype==2 || btype==3) {
				tName= "t_board"+btype;
			} 
			conn = DBConnector.getConn();
			String query = String.format("update %s set btitle = ?, bcontent = ?, "
					+ " bmodidate = SYSDATE" 
					+ " where bid = " + vo.getBid(),tName);
			ps = conn.prepareStatement(query);
			ps.setString(1, vo.getBtitle());
			ps.setString(2, vo.getBcontent());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBConnector.close(conn, ps, null);
		}
		
	}
	
	
	
}
