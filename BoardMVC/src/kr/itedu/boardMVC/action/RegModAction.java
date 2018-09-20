package kr.itedu.boardMVC.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.itedu.boardMVC.ActionForward;
import kr.itedu.boardMVC.BoardVO;
import kr.itedu.boardMVC.common.BoardDAO;
import kr.itedu.boardMVC.common.Utils;
import kr.itedu.boardMVC.common.Var;

public class RegModAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		ActionForward forward = new ActionForward();
		forward.setPath(Var.TEMPLATE_1);
		
		int btype = Utils.getParamInt(request.getParameter("btype"));
		int bid = Integer.parseInt(request.getParameter("bid"));
		
		BoardVO vo = new BoardVO();
		BoardDAO dao = BoardDAO.getInstance();
		vo = dao.getBoardList(bid, btype);
		
		request.setAttribute("vo", vo);
		request.setAttribute("content", "boardRegMod");
		request.setAttribute("btype", btype);
		
		return forward;
	}

}
