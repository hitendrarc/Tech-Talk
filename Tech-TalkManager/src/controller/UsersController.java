package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/users")
public class UsersController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UsersController() {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		System.out.println("username: " + session.getAttribute("username"));
		request.getRequestDispatcher("/adminHome.jsp").forward(request, response);

	}

}