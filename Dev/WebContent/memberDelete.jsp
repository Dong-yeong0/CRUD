<%@page import="com.dev.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberUpdate.jsp</title>
</head>
<body>
	<form action="memberSearch.do" method="post">
		ID : <input type="text" name="id"><br>
		<input type="hidden" name="job" value="delete"> 
		<input type="submit" value="조회">
	</form>

	<%
		MemberVO member = (MemberVO) request.getAttribute("member");
		if (member != null) { // && member.getId() != null  
		//입력화면
	%>
		<p>ID : <%=member.getId() %></p>
		<p>이름 : <%=member.getName() %></p>
		<p>이메일 : <%=member.getMail() %></p>
		<form action="memberDelete.do" method="post">
			<input type="hidden" name="id" value="<%=member.getId() %>">
			<input type="submit" value="삭제">
		</form>
	<%
		} else {
		// 조회 된 결과
	%>
			<h3>조회결과 없습니다.</h3>
	<%
			}
	%>
</body>
</html>