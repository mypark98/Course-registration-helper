<%@ page language="java" contentType="text/html;"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>작성 페이지</title>
<link href="css/subject.css" rel="stylesheet">
<script type="text/javascript" src="script/subject.js"></script>
</head>
<body>
	<jsp:include page="../include/header.jsp" />
	<section>
		<h2>교과목 작성</h2>
	
		<form action="WS" method="POST" name="frm">
		<table border='1' class="tbl">
			<tr>
				<td>교과목 코드</td>
				<td><input type="text" name="id" id="id"></td>
			</tr>
			<tr>
				<td>과목명</td>
				<td><input type="text" name="name" id="name"></td>
			</tr>
			<tr>
				<td>학점</td>
				<td><input type="number" name="credit" id="credit"></td>
			</tr>
			<tr>
				<td>담당강사</td>
				<td><select name="lecturer" id="lecturer">
                    <option selected>담당강사선택</option>				
                    <option value="1">김교수</option>				
                    <option value="2">이교수</option>				
                    <option value="3">박교수</option>				
                    <option value="4">우교수</option>				
                    <option value="5">최교수</option>				
                    <option value="6">강교수</option>				
                    <option value="7">황교수</option>				
				    </select></td>
			</tr>
			<tr>
				<td>요일</td>
				<td><input type="radio" name="week" value="1">월 
				    <input type="radio" name="week" value="2">화 
				    <input type="radio" name="week" value="3">수 
				    <input type="radio" name="week" value="4">목 
				    <input type="radio" name="week" value="5">금 
				    <input type="radio" name="week" value="6">토 
				    <input type="radio" name="week" value="7">일 </td>
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
		
		<a href="../index.jsp" class="update">목록</a>
		<input type="submit" value="완료" class="update" onclick="return chkValue()">
		
		</form>
		
	</section>
	<jsp:include page="../include/footer.jsp" />
</body>
</html>