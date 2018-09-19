<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/common.css?ver=3">
<link rel="stylesheet" href="./css/${content}.css?ver=1">
</head>
<body>
	<%-- <h1>안녕하세요</h1>
	<h1>${content}</h1>
	<h1>${btype}</h1>
	<h1>${title}</h1>
	<c:forEach var="vo" items="${data }">
		번호 : ${vo.bid}
		제목 : ${vo.btitle}
	</c:forEach> --%>
	${param.btype}
	<div class="main">
		<jsp:include page="menu.jsp" />
		<jsp:include page="${content}.jsp" />
	</div>
</body>
</html>