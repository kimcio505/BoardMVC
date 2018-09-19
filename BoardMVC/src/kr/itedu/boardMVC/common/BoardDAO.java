package kr.itedu.boardMVC.common;

import static kr.itedu.boardMVC.common.DBConnector.*;
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
	public ArrayList<BoardVO> getBoardList(int btype){
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
}
