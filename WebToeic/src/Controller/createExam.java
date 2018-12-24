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
import BEAN.DeThi;
import DAO.CauHoiDAO;
import DAO.DeThiDAO;
import DB.DBConnection;

@WebServlet("/createExam")
public class createExam extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public createExam() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection conn = (Connection) DBConnection.CreateConnection();
		
		String examname = request.getParameter("examname1");
		int countquestion = Integer.parseInt(request.getParameter("numberquestion1"));
		int time = Integer.parseInt(request.getParameter("time1"));
		int easy = Integer.parseInt(request.getParameter("easy1"));
		int medium = Integer.parseInt(request.getParameter("medium1"));
		int hard = Integer.parseInt(request.getParameter("hard1"));
		
		DeThi dt = new DeThi();
		
		dt.setTenDeThi(examname);
		dt.setSoLuongCauHoi(countquestion);
		dt.setThoiGianThi(time);
		
		int id = DeThiDAO.insertDeThi(conn, dt);
		
		List<CauHoi> lsteasy = CauHoiDAO.selectListRandomQuestion(conn, easy, 1);
		DeThiDAO.detThi_cauHoi(conn, lsteasy, id);
		
		List<CauHoi> lstmedium = CauHoiDAO.selectListRandomQuestion(conn, medium, 2);
		DeThiDAO.detThi_cauHoi(conn, lstmedium, id);
		
		List<CauHoi> lsthard = CauHoiDAO.selectListRandomQuestion(conn, hard, 3);
		DeThiDAO.detThi_cauHoi(conn, lsthard, id);
		
		List<DeThi> listdt = DeThiDAO.displayDSDeThi(conn);
		
		request.setAttribute("listexam", listdt);
		
		RequestDispatcher rd = request.getRequestDispatcher("View/admin/exammanager/exammanager.jsp");
		
		rd.forward(request, response);
	}

}
