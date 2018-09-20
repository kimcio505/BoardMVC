package kr.itedu.boardMVC.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.itedu.boardMVC.ActionForward;
import kr.itedu.boardMVC.common.Utils;
import kr.itedu.boardMVC.common.Var;
import kr.itedu.boardMVC.service.BoardListService;

public class BoardDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		int btype = Utils.getParamInt(request.getParameter("btype"));
		forward.setPath("boardList.bo?btype=" + btype);
		forward.setRedirect(true);
		int bid = Integer.parseInt(request.getParameter("bid"));
		BoardListService.DeleteBoard(bid, btype);
		
		
		return forward;
	}

}
