<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 목록</h1>
	<hr />
	<table border="1">
		<tr>
				<td>ID</td>
				<td>TITLE</td>
				<td>CONTENT</td>
				<td>READCOUNT</td>
				<td>CREATEDATE</td>
			</tr>
		<c:forEach var="board" items="${boards}">

			<tr>
				<td>${board.id}</td>
				<td>${board.title}</td>
				<td>${board.content}</td>
				<td>${board.readCount}</td>
				<td>${board.createDate}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>