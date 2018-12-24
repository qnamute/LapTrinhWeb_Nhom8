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
import DB.DBConnection;


@WebServlet("/DisplayClassManager")
public class DisplayClassManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DisplayClassManager() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		Connection conn = (Connection) DBConnection.CreateConnection();
		
		List<LopHoc> list = LopHocDAO.DisplayDanhSachLopHoc(conn);
		
		request.setAttribute("lophoc", list);
		
		List<ThongTinTaiKhoan> listtk = TaiKhoanDAO.DisplayTaiKhoan(conn);
		
		request.setAttribute("taikhoan", listtk);
		
		RequestDispatcher rd = request.getRequestDispatcher("View/admin/stmanager/classes.jsp");
		
		rd.forward(request, response);
	}

}
