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
import BEAN.DeThi;
import BEAN.LoaiCauHoi;
import BEAN.LopHoc;
import BEAN.ThongTinTaiKhoan;
import DAO.CauHoiDAO;
import DAO.DeThiDAO;
import DAO.LoaiCauHoiDAO;
import DAO.LoginDAO;
import DAO.LopHocDAO;
import DAO.TaiKhoanDAO;


@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = (Connection)DB.DBConnection.CreateConnection();
		
		String username = request.getParameter("username");
		String password = request.getParameter("pass");
		
		boolean kt = LoginDAO.Validate(username, password, conn);
		if(kt) {
			int role = LoginDAO.CheckRole(username, conn);
			if(role == 1) {
				boolean check = LoginDAO.setLogin(conn, username);
				if(check) {				
					RequestDispatcher rd = request.getRequestDispatcher("View/homestudent.jsp");
					rd.forward(request, response);
				}
			}
			else {
				if(role == 2) {
					List<CauHoi> listch = CauHoiDAO.displayCauHoi(conn);
					
					request.setAttribute("questionlist", listch);
					
					List<LoaiCauHoi> listlch = LoaiCauHoiDAO.displayLoaiCauHoi(conn);
					
					request.setAttribute("typequestion", listlch);
					
					RequestDispatcher rd = request.getRequestDispatcher("View/admin/questionmanager/questionmanager.jsp");
					
					rd.forward(request, response);
				}
				else {
					if(role == 3) {

						List<DeThi> listdt = DeThiDAO.displayDSDeThi(conn);
						
						request.setAttribute("listexam", listdt);
						
						RequestDispatcher rd = request.getRequestDispatcher("View/admin/exammanager/exammanager.jsp");
						
						rd.forward(request, response);
					}
					else {
						
						List<ThongTinTaiKhoan> listtk = TaiKhoanDAO.DisplayTaiKhoan(conn);
						
						request.setAttribute("taikhoan", listtk);
						
						List<LopHoc> listlh = LopHocDAO.DisplayLopHoc(conn);
						
						request.setAttribute("listclass", listlh);
						
						RequestDispatcher rd = request.getRequestDispatcher("View/admin/stmanager/student.jsp");
						
						rd.forward(request, response);
					}
				}
			}
		}
		else {		
			request.setAttribute("error", "Delete Account Failer");
			RequestDispatcher rd = request.getRequestDispatcher("LoginForward");
			rd.forward(request, response);
		}
	}

}
