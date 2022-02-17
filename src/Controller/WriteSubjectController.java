package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.subjectDao;
import DTO.modifyDto;


@WebServlet("/WS")
public class WriteSubjectController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("modify/writeForm.jsp");
		dispatcher.forward(request, response);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		System.out.println("%%: "+name);
		int credit = Integer.parseInt(request.getParameter("credit"));
		String lecturer = request.getParameter("lecturer");
		int week = Integer.parseInt(request.getParameter("week"));
		int start_hour = Integer.parseInt(request.getParameter("start_hour"));
		int end_end = Integer.parseInt(request.getParameter("end_end"));
		
		modifyDto mDto = new modifyDto();
		mDto.setId(id);
		mDto.setName(name);
		mDto.setCredit(credit);
		mDto.setLecturer(lecturer);
		mDto.setWeek(week);
		mDto.setStart_hour(start_hour);
		mDto.setEnd_end(end_end);
		
		subjectDao sDao = subjectDao.getInstance();
		sDao.insertSubject(mDto);
		
		response.sendRedirect("writeSuccess.jsp");
		
	}

}
