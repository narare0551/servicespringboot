<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="layout/header.jsp"%>

<main>
	<h1>BoardList</h1>
	<hr />
	<table border="1">
		<tr>
			<td>ID</td>
			<td>TITLE</td>
			<td>CONTENT</td>
			<td>READCOUNT</td>
			<td>CREATEDATE</td>
		</tr>
		<c:forEach var="board" items="${boards.content}">
			<tr>
				<td>${board.id}</td>
				<td><a href="/board/${board.id}">${board.title}</a></td>
				<td>${board.content}</td>
				<td>${board.readCount}</td>
				<td>${board.createDate}</td>
			</tr>
		</c:forEach>
	</table>


	<ul class="pagination">
	    <c:choose>
	    	<c:when test="${boards.first}">
	    		<li class="page-item disabled">
					<a class="page-link" href="/list?page=${boards.pageable.pageNumber-1}">Previous</a>
				</li>
	    	</c:when>
	    	<c:otherwise>
	    		<li class="page-item">
					<a class="page-link" href="/list?page=${boards.pageable.pageNumber-1}">Previous</a>
				</li>
	    	</c:otherwise>
	    </c:choose>


		<c:choose>
	    	<c:when test="${boards.last}">
	    		<li class="page-item disabled">
					<a class="page-link" href="/list?page=${boards.pageable.pageNumber+1}">Next</a>
				</li>
	    	</c:when>
	    	<c:otherwise>
	    		<li class="page-item">
					<a class="page-link" href="/list?page=${boards.pageable.pageNumber+1}">Next</a>
				</li>
	    	</c:otherwise>
	    </c:choose>
	</ul>

</main>

<%@ include file="layout/footer.jsp"%>

