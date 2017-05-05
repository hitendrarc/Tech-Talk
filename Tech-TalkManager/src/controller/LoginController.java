package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoginDao;
import dao.TechTalkDao;
import pojo.Employee;
import pojo.TechTalk;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginController() {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String userRegistered = null;
		HttpSession session = request.getSession();
		if (userName.equals("admin") && password.equals("admin")) {
			TechTalkDao tt = new TechTalkDao();
			List<TechTalk> techTalk = tt.getList();
			session.setAttribute("tt", techTalk);
			session.setAttribute("username", userName);
			request.getRequestDispatcher("/adminHome.jsp").forward(request, response);
		} else {
			Employee emp = new Employee(userName, password);

			LoginDao login = new LoginDao();
			userRegistered = login.validateUser(emp);

			if (userRegistered.equals("SUCCESS")) {
				TechTalkDao tt = new TechTalkDao();
				List<TechTalk> techTalk = tt.getList();
				session.setAttribute("tt", techTalk);
				session.setAttribute("username", userName);
				request.getRequestDispatcher("/home.jsp").forward(request, response);
				System.out.println("Success");
			} else {
				request.setAttribute("errMessage", userRegistered);
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		}
	}
}