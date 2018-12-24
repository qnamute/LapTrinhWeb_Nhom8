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
import DAO.LopHocDAO;
import DB.DBConnection;

@WebServlet("/deleteClass")
public class deleteClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public deleteClass() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = (Connection) DBConnection.CreateConnection();
		
		String classid = request.getParameter("classid3");
		
		System.out.println(classid);
		
		LopHoc lh = new LopHoc();
		
		lh.setMaLopHoc(classid);
		
		LopHocDAO.deleteLopHoc(conn, lh);
		
		List<LopHoc> list = LopHocDAO.DisplayDanhSachLopHoc(conn);
		
		request.setAttribute("lophoc", list);
		
		List<LopHoc> listlh = LopHocDAO.DisplayLopHoc(conn);
		
		request.setAttribute("listclass", listlh);
		
		RequestDispatcher rd = request.getRequestDispatcher("View/admin/stmanager/classes.jsp");
		
		rd.forward(request, response);
	}

}
