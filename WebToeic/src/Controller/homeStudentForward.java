package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/homeStudentForward")
public class homeStudentForward extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public homeStudentForward() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {		
		doPost(request, response);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		Connection conn = (Connection) DBConnection.CreateConnection();
		
		RequestDispatcher rd = request.getRequestDispatcher("View/homestudent.jsp");
		rd.forward(request, response);
	}

}
