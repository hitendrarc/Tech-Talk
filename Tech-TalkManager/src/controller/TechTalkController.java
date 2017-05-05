package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TechTalkDao;
import dao.addTechTalkDao;
import pojo.TechTalk;

@WebServlet("/TechTalkController")
public class TechTalkController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TechTalkController() {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String presentor = request.getParameter("presenter");
		String date = request.getParameter("date");

		TechTalk tt = new TechTalk(date, title, description, presentor);
		String add = null;
		addTechTalkDao ttd = new addTechTalkDao();
		if (request.getParameter("update") != null) {

			add = ttd.updateTechTalk(tt);
		}

		if (request.getParameter("add") != null) {
			add = ttd.addTechTalk(tt);
		}
		if (add.equals("SUCCESS")) {
			TechTalkDao ttd2 = new TechTalkDao();
			List<TechTalk> techTalk = ttd2.getList();
			session.setAttribute("tt", techTalk);
			request.getRequestDispatcher("/adminHome.jsp").forward(request, response);
		} else {
			request.setAttribute("errMessage", add);
			request.getRequestDispatcher("/addTechTalk.jsp").forward(request, response);
		}
	}

}