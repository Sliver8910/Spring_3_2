<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="../layout/bootstrap.jsp"/>

<title>Insert title here</title>

</head>
<body>
	<c:import url="../layout/nav.jsp"/>
	<div class="container">
	<h1 class="title_n">NOTICE</h1>
		<table class="table ">
			<thead>
				<tr>
					<th class="th1">NUM</th>
					<th class="th1">Title</th>
					<th class="th1">Writer</th>
					<th class="th1">Date</th>
					<th class="th1">Hit</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items = "${list}" var="dto">
					<!-- for문과 같은 효과  -->
					<tr>
						<td class="th1 num">${dto.num}</td>
						<td><a href="noticeSelect?num=${dto.num}">${dto.title}</a></td>
						<td class="th1">${dto.writer}</td>
						<td class="th1 date">${dto.reg_date}</td>
						<td class="th1 hit">${dto.hit}</td>
					</tr>
				</c:forEach>
			</tbody>


		</table>
		
		<div>
		 	<ul class="pagination">
		 		<c:if test="${pager.curBlock > 1}">		 		
		 			<li><a href="./noticeList?curPage=${pager.startNum-1}"><</a></li>
		 		</c:if>
				<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
					<li><a href="./noticeList?curPage=${i}">${i}</a></li>
				</c:forEach>
				<c:if test="${pager.curBlock < pager.totalBlock}">
					<li><a href="./noticeList?curPage=${pager.lastNum+1}">></a></li>
				</c:if>
			</ul>
			
		</div>
		
			<a class="btn btn-primary" href="noticeWrite">Write</a>
	</div>
	
</body>
</html>