<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QnA List</title>
<c:import url="../layout/bootstrap.jsp" />


</head>
<body>
	<c:import url="../layout/nav.jsp" />
	<div class="container">
		<h1 class="title_n">QNA</h1>

		<div>
			<form id="frm" action="./qnaList">
			<input type="hidden" value="1" id="curPage" name="curPage"> 
				<select name="kind" >
					<option id="kt" value="kt">Title</option>
					<option id="kc" value="kc" >Contents</option>
					<option id="kw" value="kw">Writer</option>
				</select> <input type="text" name="search" value="${pager.search}">
				<button>검색</button>
			</form>
		</div>
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
				<c:forEach items="${list}" var="dto">
					<!-- for문과 같은 효과  -->
					<tr>
						<td class="th1 num">${dto.num}</td>
						<td><a href="qnaSelect?num=${dto.num}">${dto.title}</a></td>
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
					<span id="${pager.startNum-1}" class="list"><</span>
				</c:if>
				<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
					<span id ="${i}" class="list" >${i}</span>
				</c:forEach>
				<c:if test="${pager.curBlock < pager.totalBlock}">
					<span id ="${pager.lastNum+1}" class="list" >></span>
				</c:if>
			</ul>

		</div>

		<a class="btn btn-primary" href="qnaWrite">Write</a>
	</div>
	<script type="text/javascript">  /* jquery로 selected 처리 */
		var kind = '${pager.kind}';
		if(kind==''){
			kind="kt";
		}
		$("#"+kind).prop("selected", true);
		$(".list").click(function() {
			$("#curPage").val($(this).attr("id"));
			$("#frm").submit();
		});
	</script> 

</body>
</html>