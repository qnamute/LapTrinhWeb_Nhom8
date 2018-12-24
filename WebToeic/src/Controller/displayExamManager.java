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


@WebServlet("/displayExamManager")
public class displayExamManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public displayExamManager() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		Connection conn = (Connection) DBConnection.CreateConnection();

		List<DeThi> listdt = DeThiDAO.displayDSDeThi(conn);
		
		request.setAttribute("listexam", listdt);
		
		RequestDispatcher rd = request.getRequestDispatcher("View/admin/exammanager/exammanager.jsp");
		
		rd.forward(request, response);
	}

}
