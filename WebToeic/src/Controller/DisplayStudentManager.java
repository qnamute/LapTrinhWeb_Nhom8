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


@WebServlet("/DisplayStudentManager")
public class DisplayStudentManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DisplayStudentManager() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Connection conn = (Connection)DB.DBConnection.CreateConnection();
		
		List<ThongTinTaiKhoan> listtk = TaiKhoanDAO.DisplayTaiKhoan(conn);
				
		request.setAttribute("taikhoan", listtk);
		
		List<LopHoc> listlh = LopHocDAO.DisplayLopHoc(conn);
		
		request.setAttribute("listclass", listlh);
		
		RequestDispatcher rd = request.getRequestDispatcher("View/admin/stmanager/student.jsp");
		
		rd.forward(request, response);
	}

}
