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

import BEAN.DeThi;
import DAO.DeThiDAO;
import DB.DBConnection;


@WebServlet("/deleteExam")
public class deleteExam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public deleteExam() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = (Connection) DBConnection.CreateConnection();
		
		int idexam = Integer.parseInt(request.getParameter("examid1"));
		
		DeThiDAO.deleteDeThi_CauHoi(conn, idexam);
		
		DeThiDAO.deleteDeThi(conn, idexam);
		
		List<DeThi> listdt = DeThiDAO.displayDSDeThi(conn);
		
		request.setAttribute("listexam", listdt);
		
		RequestDispatcher rd = request.getRequestDispatcher("View/admin/exammanager/exammanager.jsp");
		
		rd.forward(request, response);
	}

}
