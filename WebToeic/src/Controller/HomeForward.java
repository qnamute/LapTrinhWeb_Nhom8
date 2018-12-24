package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/HomeForward")
public class HomeForward extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HomeForward() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
/*		Connection conn = (Connection) DB.DBConnection.CreateConnection();
		*/
		RequestDispatcher rd = request.getRequestDispatcher("View/home.jsp");
		rd.forward(request, response);
	}
}
