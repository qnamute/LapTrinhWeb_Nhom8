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

import BEAN.LopHoc;
import BEAN.ThongTinTaiKhoan;
import DAO.LoginDAO;
import DAO.StudentDAO;
import DB.DBConnection;

@WebServlet("/inforAccount")
public class inforAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public inforAccount() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		Connection conn = (Connection) DBConnection.CreateConnection();
		
		String username= LoginDAO.userLogin(conn);
		
		List<ThongTinTaiKhoan> listtttk = StudentDAO.getThongTinTK(conn, username);	
		
		request.setAttribute("student", listtttk);
		
		List<LopHoc> listlh = StudentDAO.displayDSLopHoc_sinhVien(conn);
		
		request.setAttribute("lophoc", listlh);
		
		RequestDispatcher rd = request.getRequestDispatcher("View/infoAccount.jsp");
		
		rd.forward(request, response);
	}

}
