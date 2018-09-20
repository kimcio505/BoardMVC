package kr.itedu.boardMVC.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.itedu.boardMVC.ActionForward;
import kr.itedu.boardMVC.BoardVO;
import kr.itedu.boardMVC.common.Utils;
import kr.itedu.boardMVC.service.BoardListService;

public class BoardInsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		
		int btype = Utils.getParamInt(request.getParameter("btype"));
		int bid = Integer.parseInt(request.getParameter("bid"));
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		BoardListService service = new BoardListService();		
		
		forward.setPath("boardList.bo?btype=" + btype);
		forward.setRedirect(true);
		
		if( bid ==0	) {
			BoardVO vo = new BoardVO();
			vo.setBtitle(btitle);
			vo.setBcontent(bcontent);
			service.insertBoard(vo, btype);
		} else {
			BoardVO vo = new BoardVO();
			vo.setBid(bid);
			vo.setBtitle(btitle);
			vo.setBcontent(bcontent);
			service.UpdateBoard(vo, btype);
		}
		
		return forward;
	}

}
