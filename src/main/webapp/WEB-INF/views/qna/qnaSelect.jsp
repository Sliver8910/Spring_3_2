<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../layout/bootstrap.jsp"/>
</head>
<body>
	<c:import url="../layout/nav.jsp"/>
	<div class="container" >
	<h1 class="title_n">QNA</h1> 
		<table class="table ">
			<thead>
				<tr>
					<th class="th1">Title</th><th class="th1">Writer</th><th class="th1">Date</th><th class="th1">Hit</th>
				</tr>
			</thead> 
			<tbody> 
				<tr>
					<td id="title1">${dto.title}</td><td class="th1">${dto.writer}</td><td class="th1 date">${dto.reg_date}</td><td class="th1 hit">${dto.hit}</td>
				</tr>
				<tr>
					<td colspan="4"><div class="con1">${dto.contents}</div></td>
				</tr>
			</tbody>
		</table>
		<a href="qnaList" class="btn btn-primary">글목록</a>
		<a class="btn btn-primary" href="qnaUpdate?num=${dto.num}">Update</a>
		<a class="btn btn-danger" href="qnaDelete?num=${dto.num}">Delete</a>
		<a class="btn btn-primary" href="qnaReply?num=${dto.num}">답글</a>
	</div>
</body>
</html>