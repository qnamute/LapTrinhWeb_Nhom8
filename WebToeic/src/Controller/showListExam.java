package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.Exam;
import DAO.ExamDAO;
import DB.DBConnection;


@WebServlet("/showListExam")
public class showListExam extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public showListExam() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Connection conn = (Connection)DBConnection.CreateConnection();
		
		List<Exam> listexam = ExamDAO.displayListExam(conn);		
		
		request.setAttribute("listexam", listexam);
			
		RequestDispatcher rd = request.getRequestDispatcher("View/listexam.jsp");
		
		rd.forward(request, response);
		
	}

}
