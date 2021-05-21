<%@page import="com.dev.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberListOutput.jsp</title>
</head>
<body>
	<h3>회원 목록</h3>
	<c:choose>
		<c:when test="${empty list }">
			<p>조회결과가 없습니다.</p>
		</c:when>
		<c:otherwise>
			<table border="1">
				<tr>
					<th>회원 아이디</th>
					<th>회원 이름</th>
					<th>회원 이메일</th>
				</tr>
				<c:forEach items="${list }" var="member">
					<tr>
						<td>${member.id }</td>
						<td>${member.name }</td>
						<td>${member.mail }</td>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
	<%--
		List<MemberVO> list = (List) request.getAttribute("list");
		if(list.size() == 0){
			--%>
	<!-- 조회결과가 없습니다. -->
	<%--
		}else {
			out.print("<ul>");
			for(MemberVO member : list){
				out.print("<li></li>");
			}
		}
	--%>
</body>
</html>