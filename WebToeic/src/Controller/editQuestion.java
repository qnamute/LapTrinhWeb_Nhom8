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


@WebServlet("/editQuestion")
public class editQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public editQuestion() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		Connection conn = (Connection)DBConnection.CreateConnection();
		
		int maCauHoi = Integer.parseInt(request.getParameter("id2"));
		int malch = Integer.parseInt(request.getParameter("typequestion2"));
		String content = request.getParameter("content2");
		String option1 = request.getParameter("option12");
		String option2 = request.getParameter("option22");
		String option3 = request.getParameter("option32");
		String option4 = request.getParameter("option42");
		String answer = request.getParameter("correct2");
		
		CauHoi ch = new CauHoi();
		
		ch.setMaCauHoi(maCauHoi);
		ch.setMaLoaiCauHoi(malch);
		ch.setNoiDung(content);
		ch.setOption1(option1);
		ch.setOption2(option2);
		ch.setOption3(option3);
		ch.setOption4(option4);
		ch.setDapAnDung(answer);
		
		CauHoiDAO.editCauHoi(conn, ch);
		
		List<CauHoi> listch = CauHoiDAO.displayCauHoi(conn);
		
		request.setAttribute("questionlist", listch);
		
		List<LoaiCauHoi> listlch = LoaiCauHoiDAO.displayLoaiCauHoi(conn);
		
		request.setAttribute("typequestion", listlch);
		
		RequestDispatcher rd = request.getRequestDispatcher("View/admin/questionmanager/questionmanager.jsp");
		
		rd.forward(request, response);
	}

}
