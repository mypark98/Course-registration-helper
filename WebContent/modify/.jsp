<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>작성 페이지</title>
<link href="../css/subject.css" rel="stylesheet">
<script type="text/javascript" src="../script/subject.js"></script>
</head>
<body>
	<jsp:include page="../include/header.jsp" />

	<section>
		<h2>교과목 작성</h2>
		<form action="WS" method="post" name="frm">
			<table border=1 class="tbl">
				<tr>
					<td>교과목 코드</td>
					<td><input type="text" name="id" id="id"></td>
				</tr>
				<tr>
					<td>과목명</td>
					<td><input type="text" name="name" id="name"></td>
				</tr>
				<tr>
					<td>담당강사</td>
					<td>
					    <select name="lecturer">
					    <option value="1">김교수</option>
					    <option value="2">이교수</option>
					    <option value="3">박교수</option>
					    <option value="4">우교수</option>
					    <option value="5">최교수</option>
					    <option value="6">강교수</option>
					    <option value="7">황교수</option>
					    </select>
					</td>
				</tr>
				<tr>
					<td>학점</td>
					<td><input type="number" min="0" name="credit" id="credit"></td>
				</tr>
				<tr>
					<td>요일</td>
					<td>
					<label><input type="radio" name="week" value="1">월</label>
					<label><input type="radio" name="week" value="2">화</label>
					<label><input type="radio" name="week" value="3">수</label>
					<label><input type="radio" name="week" value="4">목</label>
					<label><input type="radio" name="week" value="5">금</label>
					<label><input type="radio" name="week" value="6">토</label>
					<label><input type="radio" name="week" value="7">일</label>
					</td>
				</tr>
				<tr>
					<td>시작시간</td>
					<td><input type="number" name="start_hour" id="start_hour"></td>
				</tr>
				<tr>
					<td>종료시간</td>
					<td><input type="number" name="end_end" id="end_end"></td>
				</tr>
			</table>
		</form>
	</section>

	<jsp:include page="../include/footer.jsp" />
</body>
</html>