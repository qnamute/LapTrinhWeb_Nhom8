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
import BEAN.TaiKhoan;
import BEAN.ThongTinTaiKhoan;
import DAO.LopHocDAO;
import DAO.TaiKhoanDAO;
import DAO.thongTinTaiKhoanDAO;
import DB.DBConnection;

@WebServlet("/editAccount")
public class editAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public editAccount() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		Connection conn = (Connection)DBConnection.CreateConnection();		
		
		TaiKhoan tk = new TaiKhoan();
		
		String username = request.getParameter("username2");
		int roleid =  Integer.parseInt(request.getParameter("roleid2")); 
		
		tk.setTenDangNhap(username);
		tk.setMaLoaiTaiKhoan(roleid);
		
		TaiKhoanDAO.updateTaiKhoan(conn, tk);
		
		
		ThongTinTaiKhoan tttk = new ThongTinTaiKhoan();
		
		String fulname = request.getParameter("fullname2");
		String namsinh = request.getParameter("namsinh2");
		String gioitinh = request.getParameter("sex2");
		String email = request.getParameter("email2");
		
		tttk.setTenDangNhap(username);
		tttk.setHoVaTen(fulname);
		tttk.setNamSinh(namsinh);
		tttk.setGioiTinh(gioitinh);
		tttk.setEmail(email);
		
		thongTinTaiKhoanDAO.updateThongTinTaiKhoan(conn, tttk);
	
		List<ThongTinTaiKhoan> list = TaiKhoanDAO.DisplayTaiKhoan(conn);
				
		request.setAttribute("taikhoan", list);
		
		List<LopHoc> listlh = LopHocDAO.DisplayDanhSachLopHoc(conn);
		
		request.setAttribute("lophoc", listlh);
		
		RequestDispatcher rd = request.getRequestDispatcher("View/admin/stmanager/student.jsp");
		
		rd.forward(request, response);
	}

}
