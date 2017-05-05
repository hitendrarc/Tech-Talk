package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DeleteDao;
import dao.RegisterUserDao;
import dao.TechTalkDao;
import pojo.TechTalk;

@WebServlet("/adminHome")
public class AdminHomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminHomeController() {
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/adminHome.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("username").equals(null)) {
			System.out.println("equals");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		if (request.getParameter("logout") != null) {
			session.invalidate();
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		if (session != null) {
			if (request.getParameter("delete") != null) {
				String title = request.getParameter("delete");
				System.out.println(title);
				DeleteDao dd = new DeleteDao();
				TechTalkDao tt = new TechTalkDao();
				dd.deleteTechTalk(title);
				List<TechTalk> techTalk = tt.getList();
				session.setAttribute("tt", techTalk);
				request.getRequestDispatcher("/adminHome.jsp").forward(request, response);
			}
			if (request.getParameter("add") != null) {
				request.getRequestDispatcher("/addTechTalk.jsp").forward(request, response);
			}
			if (request.getParameter("update") != null) {
				System.out.println(request.getParameter("update"));

				TechTalkDao ttd2 = new TechTalkDao();
				int id = Integer.parseInt(request.getParameter("update"));
				System.out.println("id=" + id + " " + request.getParameter("update"));
				session.setAttribute("tt", ttd2.getTechTalk(id));
				request.getRequestDispatcher("/updateTechTalk.jsp").forward(request, response);
			}
			if (request.getParameter("users") != null) {
				RegisterUserDao users = new RegisterUserDao();
				session.setAttribute("users", users.getUsers());
				request.getRequestDispatcher("/users.jsp").forward(request, response);
			}

			request.getRequestDispatcher("/adminHome.jsp").forward(request, response);
		}
	}
}