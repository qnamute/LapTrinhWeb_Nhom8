package Controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.LoginDAO;
import DB.DBConnection;


@WebServlet("/logOut")
public class logOut extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public logOut() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = (Connection)DBConnection.CreateConnection();
		
		boolean kt = LoginDAO.setLogout(conn);
		
		if(kt) {
			RequestDispatcher rd = request.getRequestDispatcher("View/home.jsp");
			rd.forward(request, response);
		}
	}

}
