<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="layout/header.jsp"%>
<main>
<h1>글쓰기 페이지</h1>
<hr>
<form action="/save" method="post">
	<input type="text" name="title" />
	<input type="text" name="content" />
	<button>글쓰기완료</button>
</form>
</main>

<%@ include file ="layout/footer.jsp"%>

