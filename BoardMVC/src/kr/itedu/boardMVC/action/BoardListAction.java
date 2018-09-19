package kr.itedu.boardMVC.action;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.itedu.boardMVC.ActionForward;
import kr.itedu.boardMVC.BoardVO;
import kr.itedu.boardMVC.common.Utils;
import kr.itedu.boardMVC.common.Var;
import kr.itedu.boardMVC.service.BoardListService;

public class BoardListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		
		forward.setPath(Var.TEMPLATE_1);
		
		BoardListService service = new BoardListService();
		
		int btype = Utils.getParamInt(request.getParameter("btype"));
		ArrayList<BoardVO> data = service.getBoardList(btype);
		request.setAttribute("content", "boardList");
		//request.setAttribute("title", Var.TITLES[btype]);
		request.setAttribute("btype", btype);
		request.setAttribute("data", data);
		
		return forward;
	}

}
