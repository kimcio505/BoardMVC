<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kr.itedu.boardMVC.*"%>
<%@page errorPage="boardListError.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	ArrayList<BoardVO> result = (ArrayList<BoardVO>) request.getAttribute("boardList");
	/* 	int bid = Integer.parseInt(request.getParameter("bid")); */
	//result.clear();
%>

	
<div class="table">
	<%
		if (result.size() > 0) {
	%>
	<table>
		<tr>
			<th>번호</th>
			<th style="width: 70%">제목</th>
			<th class="date">등록일시</th>
		</tr>

		<c:forEach var="vo" items="${data}">
			<tr>
			<td class="center"><a href="#">${vo.bid }</a></td>
			<td class="title">${vo.btitle }</td>
			<td class="center">${vo.bregdate }</td>
		</tr>
		</c:forEach>
		
	</table>
	<%
		} else {
	%>
	<h4>게시글이 없습니다</h4>
	<%
		}
	%>
	<div class="btn">
		<form action="boardRegMod" method="get">
			<input type="hidden" name="bid" value="0">
			<input type="hidden" name="num" value="<%=request.getParameter("num") %>">
			 <input	type="submit" value="글쓰기">
		</form>
	</div>
</div>
	
