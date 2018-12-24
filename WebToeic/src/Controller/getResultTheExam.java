package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.CauHoi;
import BEAN.Result;
import BEAN.ThongTinTaiKhoan;
import DAO.DeThiDAO;
import DAO.ExamDAO;
import DAO.LoginDAO;
import DAO.ResultDAO;
import DAO.StudentDAO;
import DB.DBConnection;


@WebServlet("/getResultTheExam")
public class getResultTheExam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public getResultTheExam() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = (Connection)DBConnection.CreateConnection();

		String nameexam = request.getParameter("nameexam");
		
		int maDe = Integer.parseInt(request.getParameter("examid"));
		
		int correct = 0;
		
		int answernull = 0;
		
		int incorrect = 0;
		
		int countRow = DeThiDAO.getSoLuongCauHoi(conn, maDe);
		
		List<CauHoi> anwerUser = new ArrayList<CauHoi>();
		
		List<CauHoi> listQuestion = ExamDAO.displayDSCauHoi_byMaDe(conn, maDe);
		
		for(int i = 1; i <= countRow; i++) {
			
			String answer = request.getParameter("ans["+ i +"]");
			
			CauHoi ch = new CauHoi();
				
			ch.setDapAnDung(answer);
			ch.setSoThuTu(i);
			anwerUser.add(ch);
		}
		
		for(int j = 0 ; j < countRow; j++) {
			String ss1 = anwerUser.get(j).getDapAnDung();
			String ss2 = listQuestion.get(j).getDapAnDung();
			
			if(ss1 == null) {
				answernull ++;
			}
			else {
				if(ss1.equals(ss2)) {
					correct ++;
				}
				else {
					incorrect ++;
				}
			}
		}
		
		String username= LoginDAO.userLogin(conn);
		
		List<ThongTinTaiKhoan> listtttk = StudentDAO.getThongTinTK(conn, username);	
		
		request.setAttribute("student", listtttk);
		
		request.setAttribute("correct", correct);
		request.setAttribute("incorrect", incorrect);
		request.setAttribute("answernull", answernull);
		
		request.setAttribute("nameexam", nameexam);		
		
		Result rs = new Result();
		
		rs.setTenDangNhap(username);
		rs.setMaDe(maDe);
		rs.setCorrect(correct);
		rs.setIncorrect(incorrect);
		rs.setAnswernull(answernull);
		
		ResultDAO.insertResult(conn, rs);
		
		RequestDispatcher rd = request.getRequestDispatcher("View/result.jsp");
		rd.forward(request, response);
	}
}
