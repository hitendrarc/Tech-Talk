package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RegisterDao;
import pojo.Employee;

public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegistrationController() {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String fullName = request.getParameter("name");
		String userName = request.getParameter("username");
		String password = request.getParameter("password");

		Employee emp = new Employee(userName, fullName, password);

		RegisterDao registerDao = new RegisterDao();
		String userRegistered = registerDao.registerUser(emp);

		if (userRegistered.equals("SUCCESS")) {
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} else {
			request.setAttribute("errMessage", userRegistered);
			request.getRequestDispatcher("/signup.jsp").forward(request, response);
		}
	}

}