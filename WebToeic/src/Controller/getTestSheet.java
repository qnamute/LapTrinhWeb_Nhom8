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

import BEAN.CauHoi;
import DAO.DeThiDAO;
import DAO.ExamDAO;
import DB.DBConnection;


@WebServlet("/getTestSheet")
public class getTestSheet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public getTestSheet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int maDeThi = Integer.parseInt(request.getParameter("examid"));
		
		String tendeThi = request.getParameter("nameexamid");
		
		request.setAttribute("nameexam", tendeThi);
		
		Connection conn = (Connection)DBConnection.CreateConnection();
		
		List<CauHoi> listch = ExamDAO.displayDSCauHoi_byMaDe(conn, maDeThi);
		
		request.setAttribute("examid", maDeThi);
		
		request.setAttribute("lch", listch);
		
		int count = listch.size();

		request.setAttribute("total", count);
		
		int time = DeThiDAO.getThoiGianLamBai(conn, maDeThi);
		
		request.setAttribute("time", time);
		
		RequestDispatcher rd = request.getRequestDispatcher("View/testsheet.jsp");
		
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("View/home.jsp");
		
		rd.forward(request, response);
	}

}
