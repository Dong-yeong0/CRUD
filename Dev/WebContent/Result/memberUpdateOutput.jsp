<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>${member.id } 회원님 수정결과</h3>
	<p>비밀번호 : ${member.passwd}</p>
	 <p>이름 : ${member.name }</p>
	 <p>이메일 : ${member.mail }</p>
	<a href="index.jsp">첫 페이지로</a>
</body>
</html>