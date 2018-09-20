<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="kr.itedu.boardMVC.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	int bid = Integer.parseInt(request.getParameter("bid"));
	int btype = Integer.parseInt(request.getParameter("btype"));
	BoardVO vo = (BoardVO)request.getAttribute("vo");
%>
<% request.setCharacterEncoding("UTF-8"); %>
<script language = "javascript">

function writeCheck()
  {
   var form = document.writeform;
   
  if( !form.btitle.value )
   {
    alert( "제목을 적어주세요" );
    form.btitle.focus();
    return;
   }
 
  if( !form.bcontent.value )
   {
    alert( "내용을 적어주세요" );
    form.bcontent.focus();
    return;
   }
 
  form.submit();
  }
 </script>
<body>
	<form name="writeform" method="post" action="boardInsert.bo">
		<table>
			<tr>
				<td>
					<table width="100%" cellpadding="0" cellspacing="0" border="0">
						<tr>
							<td>글쓰기</td>
						</tr>
					</table>
					<table>
						<tr>
							<td>&nbsp;</td>
							<td align="center">제목</td>
							<td><input name="btitle" size="50" maxlength="100" value="<%if(bid!=0){%><%=vo.getBtitle() %><%} %>" ></td>
							<td>&nbsp;</td>
						</tr>
						<tr height="1" bgcolor="#dddddd">
							<td colspan="4"></td>
						</tr>
						
						<tr height="1" bgcolor="#dddddd">
							<td colspan="4"></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td align="center">내용</td>
							<td><textarea name="bcontent" cols="50" rows="13"><%if(bid!=0){%><%=vo.getBcontent()%><%} %></textarea></td>
							<td>&nbsp;</td>
						</tr>
						<tr height="1" bgcolor="#dddddd">
							<td colspan="4"></td>
						</tr>
						<tr height="1" bgcolor="#82B5DF">
							<td colspan="4"></td>
						</tr>
						<tr align="center">
							<td>&nbsp;</td>
							<td colspan="2">
							<input type="submit" value="등록" > 
							<input type="button" value="취소" OnClick="javascript:history.back(-1)">
							<input type="hidden" name="bid" value="<%=request.getParameter("bid") %>">
							<input type="hidden" name="btype" value="<%=btype%>">
							<td>&nbsp;</td>
						</tr>
					</table>
				</td>
			</tr>
			</table>
		</form>
	
</body>
</html>