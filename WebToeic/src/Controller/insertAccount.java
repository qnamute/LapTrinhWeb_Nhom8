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


@WebServlet("/insertAccount")
public class insertAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public insertAccount() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		Connection conn = (Connection)DBConnection.CreateConnection();		
		
		TaiKhoan tk = new TaiKhoan();
		
		String username = request.getParameter("username1");
		String passowrd = request.getParameter("password1");
		int roleid =  Integer.parseInt(request.getParameter("roleid1")); 
		
		tk.setTenDangNhap(username);
		tk.setMatKhau(passowrd);
		tk.setMaLoaiTaiKhoan(roleid);
		
		boolean kt = TaiKhoanDAO.insertTaiKhoan(conn, tk);
		
		if(kt) {
			request.setAttribute("TrangThai", "success");

		}
		else {
			request.setAttribute("TrangThai", "failer");

		}
		
		ThongTinTaiKhoan tttk = new ThongTinTaiKhoan();
		
		String fulname = request.getParameter("fullname1");
		String namsinh = request.getParameter("namsinh1");
		String gioitinh = request.getParameter("sex1");
		String email = request.getParameter("email1");
		
		tttk.setTenDangNhap(username);
		tttk.setHoVaTen(fulname);
		tttk.setNamSinh(namsinh);
		tttk.setGioiTinh(gioitinh);
		tttk.setEmail(email);
		

		boolean kt1 = thongTinTaiKhoanDAO.insertThongTinTaiKhoan(conn, tttk);
		
		if(kt1) {
			request.setAttribute("TrangThai", "success");

		}
		else {
			request.setAttribute("TrangThai", "failer");

		}

		
		List<ThongTinTaiKhoan> list = TaiKhoanDAO.DisplayTaiKhoan(conn);
				
		request.setAttribute("taikhoan", list);
		
		List<LopHoc> listlh = LopHocDAO.DisplayLopHoc(conn);
		
		request.setAttribute("listclass", listlh);
		
		RequestDispatcher rd = request.getRequestDispatcher("View/admin/stmanager/student.jsp");
		
		rd.forward(request, response);
	}

}
