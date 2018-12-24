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
import DAO.LopHocDAO;
import DAO.TaiKhoanDAO;
import DAO.thongTinTaiKhoanDAO;
import DB.DBConnection;


@WebServlet("/deleteAccount")
public class deleteAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public deleteAccount() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		Connection conn = (Connection) DBConnection.CreateConnection();
		
		List<LopHoc> listlh = LopHocDAO.DisplayDanhSachLopHoc(conn);
		
		request.setAttribute("lophoc", listlh);
		
		String username = request.getParameter("username3");
		
		thongTinTaiKhoanDAO.deleteThongTinTaiKhoan(conn, username);
		
		TaiKhoanDAO.deleteTaiKhoan(conn, username);
		
		List<ThongTinTaiKhoan> listtk = TaiKhoanDAO.DisplayTaiKhoan(conn);
		
		request.setAttribute("taikhoan", listtk);
		
		RequestDispatcher rd = request.getRequestDispatcher("View/admin/stmanager/student.jsp");
		
		rd.forward(request, response);
	}
}
