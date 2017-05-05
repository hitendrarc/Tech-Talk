package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RegisterUserDao;

@WebServlet("/home")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.equals(null)) {
			request.getRequestDispatcher("/login.jsp").include(request, response);
		}
		if (session != null) {
			request.setAttribute("username", request.getAttribute("username"));
			if (request.getParameter("register") != null) {
				String userName = request.getParameter("field1");
				String title = request.getParameter("register");
				System.out.println(title);
				RegisterUserDao user = new RegisterUserDao();
				user.registerUser(userName, title);
				request.getRequestDispatcher("/home.jsp").forward(request, response);
			}
		}
		if (request.getParameter("logout") != null) {
			System.out.println("logout");
			session.invalidate();
		}
		request.getRequestDispatcher("/index.jsp").include(request, response);

	}

}