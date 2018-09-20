<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "java.util.ArrayList" %>
<%@page import="kr.itedu.boardMVC.*"%>
<%
	BoardVO vo = (BoardVO)request.getAttribute("vo");
%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/common.css?ver=3">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<header>
			<h4><a href="boardList.bo?btype=${btype }">메인으로 가기</a></h4>
		</header>
			<table>
				<tr>
					<th>글제목</th>
					<th>글내용</th>
					<th>등록일시</th>
					<th>수정일시</th>
				</tr>
				<tr>
					<td><%=vo.getBtitle() %></td>
					<td><%=vo.getBcontent() %></td>
					<td><%=vo.getBregdate() %></td>
					<%if(vo.getBmodidate()!=null){ %>
						<td><%=vo.getBmodidate() %></td>
					<%} else{ %>
						<td></td>
					<%} %>
				</tr>
			</table>
			<a href="boardRegMod.bo?bid=<%=request.getParameter("bid")%>&btype=<%=request.getParameter("btype")%>"><input type="submit" value="수정"></a>
			<a href="boardDelete.bo?bid=<%=request.getParameter("bid") %>&btype=<%=request.getParameter("btype")%>"><input type="button" value="삭제"></a>
</body>
</html>