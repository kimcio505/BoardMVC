package kr.itedu.boardMVC.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.itedu.boardMVC.ActionForward;
import kr.itedu.boardMVC.BoardVO;
import kr.itedu.boardMVC.common.Utils;
import kr.itedu.boardMVC.common.Var;
import kr.itedu.boardMVC.service.BoardListService;

public class BoardDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		
		forward.setPath(Var.TEMPLATE_1);
		
		BoardListService service = new BoardListService();
		
		int btype = Utils.getParamInt(request.getParameter("btype"));
		int bid = Utils.getParamInt(request.getParameter("bid"));
		BoardVO vo = service.getBoardList(bid, btype);
		
		
		request.setAttribute("vo", vo);
		request.setAttribute("title", Var.TITLES[btype-1]);
		request.setAttribute("content", "boardDetail");
		request.setAttribute("btype", btype);
		return forward;
	}

}
