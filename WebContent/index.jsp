<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="DAO.subjectDao"%>
<%@ page import="DTO.subjectDto"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="./css/subject.css" rel="stylesheet">
<title>수강신청 도우미 사이트</title>
</head>
<body>
	<jsp:include page="./include/header.jsp" />
	<section>
		<div>총 
		<%
		subjectDao sDao = subjectDao.getInstance();
		int count = sDao.allSubjectCnt();
		request.setAttribute("count", count); %>
		${count}개의 교과목이 있습니다.</div>
		<table border=1 class="tbl">
			<tr>
				<th>과목코드</th>
				<th>과목명</th>
				<th>학점</th>
				<th>담당강사</th>
				<th>요일</th>
				<th>시작시간</th>
				<th>종료시간</th>
				<th>관리</th>
			</tr>
			<%
			List<subjectDto> list = sDao.selectSubject();
			for(subjectDto subject:list){
			%>
			<tr>
				<td><%= subject.getId()%></td>
				<td><%= subject.getSname()%></td>
				<td><%= subject.getCredit()%></td>
				<td><%= subject.getName()%></td>
			<%
			    String day = "";
			    switch(subject.getWeek()){
			    	case 1: day = "월";
			    	break;
			    	case 2: day = "화";
	    	        break;
			    	case 3: day = "수";
	    	        break;
			    	case 4: day = "목";
	    	        break;
			    	case 5: day = "금";
	    	        break;
			    	case 6: day = "토";
	    	        break;
			    	case 7: day = "일";
	    	        break;
			    }
			%>
				<td><%= day%></td>
				<td><%= subject.getStart_hour()%></td>
				<td><%= subject.getEnd_end()%></td>
				<td>
				    <a href="US?id=<%=subject.getId()%>">수정</a>
				    /
				    <a href="DS?id=<%=subject.getId()%>">삭제</a>
			    </td>
			    </tr>
			<%
			}
			%>
		</table>
		<div class="input"><a href="WS">작성</a></div>
	</section>
	
	<jsp:include page="./include/footer.jsp" />
</body>
</html>