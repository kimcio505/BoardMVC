package kr.itedu.boardMVC;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.itedu.boardMVC.action.Action;
import kr.itedu.boardMVC.action.BoardDeleteAction;
import kr.itedu.boardMVC.action.BoardDetailAction;
import kr.itedu.boardMVC.action.BoardInsertAction;
import kr.itedu.boardMVC.action.BoardListAction;
import kr.itedu.boardMVC.action.RegModAction;
import kr.itedu.boardMVC.common.BoardDAO;

@WebServlet("*.bo")
public class BoardFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doProc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String reqURI = request.getRequestURI();
		System.out.println("reqURI : " + reqURI);
		String ctxPath = request.getContextPath();
		System.out.println("ctxPath : " + ctxPath);
		String comd = reqURI.substring(ctxPath.length());
		System.out.println("comd : " + comd);
		ActionForward forward = null;
		Action action = null;
		
		
		if(comd.equals("/boardList.bo")) {
			action = new BoardListAction();
			forward = action.execute(request, response);
		} else if(comd.equals("/boardDetail.bo")) {
			action = new BoardDetailAction();
			forward = action.execute(request, response);
		} else if(comd.equals("/boardRegMod.bo")) {
			action = new RegModAction();
			forward = action.execute(request, response);
		} else if(comd.equals("/boardInsert.bo")) {
			action = new BoardInsertAction();
			forward = action.execute(request, response);
		} else if(comd.equals("/boardDelete.bo")) {
			action = new BoardDeleteAction();
			forward = action.execute(request, response);
		}
		
		if(forward != null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher rd = request.getRequestDispatcher(forward.getPath());
				rd.forward(request, response);
			}
		}
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProc(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProc(request,response);
	}

}
