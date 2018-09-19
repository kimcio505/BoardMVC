package kr.itedu.boardMVC.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.itedu.boardMVC.ActionForward;

public interface Action {
	ActionForward execute(HttpServletRequest request, HttpServletResponse response);
	
}
