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

import BEAN.BaiThi;
import BEAN.DeThi;
import BEAN.LopHoc;
import DAO.BaiThiDAO;
import DAO.DeThiDAO;
import DAO.LopHocDAO;
import DB.DBConnection;

@WebServlet("/insertBaiThi")
public class insertBaiThi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public insertBaiThi() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = (Connection)DBConnection.CreateConnection();
		
		int idlophoc = Integer.parseInt(request.getParameter("class1"));
		int idexam = Integer.parseInt(request.getParameter("exam1"));
		String starttime = request.getParameter("starttime1");
		String endtime = request.getParameter("endtime1");
		
		BaiThi bt = new BaiThi();
		
		bt.setMaDeThi(idexam);
		bt.setMaLopHoc(idlophoc);
		bt.setThoiGianBatDau(starttime);
		bt.setThoiGianKetThuc(endtime);
		
		BaiThiDAO.insertBaiThi(conn, bt);
		
		List<BaiThi> listbt = BaiThiDAO.displayDSBaiThi(conn);
		
		request.setAttribute("listbt", listbt);
		
		List<LopHoc> listlh = LopHocDAO.DisplayLopHoc(conn);
		
		request.setAttribute("listclass", listlh);
		
		List<DeThi> listdt = DeThiDAO.displayDSDeThi(conn);
		
		request.setAttribute("listexam", listdt);
		
		RequestDispatcher rd = request.getRequestDispatcher("View/admin/exammanager/examforclass.jsp");
		
		rd.forward(request, response);
	}

}
