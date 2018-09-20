package kr.itedu.boardMVC.service;

import java.util.ArrayList;
import kr.itedu.boardMVC.BoardVO;
import kr.itedu.boardMVC.common.BoardDAO;

public class BoardListService {
	public ArrayList<BoardVO> getAllBoardList(int btype){
		ArrayList<BoardVO> result = null;
		BoardDAO dao = BoardDAO.getInstance();
		result = dao.getAllBoardList(btype);
		
/*		System.out.printf("btype : %d\n" , btype);
		for(BoardVO vo : result) {
			System.out.printf("bid : %d\n" , vo.getBid());
			System.out.printf("btitle : %s\n" , vo.getBtitle());
			System.out.printf("bcontent : %s\n" , vo.getBcontent());
			System.out.printf("bregdate : %s\n" , vo.getBregdate());
			System.out.println("--------------");
		}
*/		return result;
	}
	public BoardVO getBoardList(int bid ,int btype) {
		BoardVO vo = new BoardVO();
		BoardDAO dao = BoardDAO.getInstance();
		
		vo = dao.getBoardList(bid,btype);
		return vo;
	}
	public void insertBoard(BoardVO vo , int btype) {
		BoardDAO dao = BoardDAO.getInstance();
		dao.insertList(vo, btype);
	}
	public void UpdateBoard(BoardVO vo , int btype) {
		BoardDAO dao = BoardDAO.getInstance();
		dao.updateList(vo, btype);
	}
	public static void DeleteBoard(int bid, int btype) {
		BoardDAO dao = BoardDAO.getInstance();
		dao.deleteList(bid, btype);
	}
	
}
