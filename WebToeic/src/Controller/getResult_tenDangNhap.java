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

import BEAN.Result;
import BEAN.ThongTinTaiKhoan;
import DAO.LoginDAO;
import DAO.ResultDAO;
import DAO.StudentDAO;
import DB.DBConnection;

@WebServlet("/getResult_tenDangNhap")
public class getResult_tenDangNhap extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public getResult_tenDangNhap() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Connection conn = (Connection)DBConnection.CreateConnection();
		
		String username = LoginDAO.userLogin(conn);
		
		List<Result> listrs = ResultDAO.disPlayResult_byStudent(conn, username);
		
		request.setAttribute("listrs", listrs);
		
		List<ThongTinTaiKhoan> listtttk = StudentDAO.getThongTinTK(conn, username);	
		
		request.setAttribute("student", listtttk);
		
		RequestDispatcher rd = request.getRequestDispatcher("View/resultStudent.jsp");
		
		rd.forward(request, response);
	}

}
