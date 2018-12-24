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
import DAO.thongTinTaiKhoanDAO;
import DB.DBConnection;


@WebServlet("/editInfo_byStudent")
public class editInfo_byStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public editInfo_byStudent() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = (Connection)DBConnection.CreateConnection();
		
		String username = request.getParameter("username2");
		String fullname = request.getParameter("fullname2");
		String namsinh = request.getParameter("namsinh2");
		String gioitinh = request.getParameter("sex2");
		String email = request.getParameter("email2");
		
		ThongTinTaiKhoan tttk = new ThongTinTaiKhoan();
		
		tttk.setTenDangNhap(username);
		tttk.setHoVaTen(fullname);
		tttk.setNamSinh(namsinh);
		tttk.setGioiTinh(gioitinh);
		tttk.setEmail(email);
		
		thongTinTaiKhoanDAO.updateThongTinTaiKhoan(conn, tttk);
		
		String username1= LoginDAO.userLogin(conn);
		
		List<ThongTinTaiKhoan> listtttk = StudentDAO.getThongTinTK(conn, username1);	
		
		request.setAttribute("student", listtttk);
		
		List<LopHoc> listlh = StudentDAO.displayDSLopHoc_sinhVien(conn);
		
		request.setAttribute("lophoc", listlh);
		
		RequestDispatcher rd = request.getRequestDispatcher("View/infoAccount.jsp");
		
		rd.forward(request, response);
	}

}
