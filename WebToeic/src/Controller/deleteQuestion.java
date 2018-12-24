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
import BEAN.LoaiCauHoi;
import DAO.CauHoiDAO;
import DAO.LoaiCauHoiDAO;
import DB.DBConnection;


@WebServlet("/deleteQuestion")
public class deleteQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public deleteQuestion() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Connection conn = (Connection)DBConnection.CreateConnection();
		
		int mach = Integer.parseInt(request.getParameter("id3"));
		
		CauHoiDAO.deleteCauHoi(conn, mach);
		
		List<CauHoi> listch = CauHoiDAO.displayCauHoi(conn);
		
		request.setAttribute("questionlist", listch);
		
		List<LoaiCauHoi> listlch = LoaiCauHoiDAO.displayLoaiCauHoi(conn);
		
		request.setAttribute("typequestion", listlch);
		
		RequestDispatcher rd = request.getRequestDispatcher("View/admin/questionmanager/questionmanager.jsp");
		
		rd.forward(request, response);
	}

}
