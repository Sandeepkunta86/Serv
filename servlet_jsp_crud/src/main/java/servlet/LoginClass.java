package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dto.User;

@WebServlet("/Login")
public class LoginClass extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String frontendEmail = req.getParameter("email");
		String frontendPassword = req.getParameter("password");

		UserDao userDao = new UserDao();
		User dbUser = userDao.fetchPersonBYEmail(frontendEmail);

		if (dbUser != null) {
			if (dbUser.getPassword().equals(frontendPassword)) {
				List<User> list = userDao.fetchAllUsers();
				req.setAttribute("k", list);
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("Display.jsp");
				requestDispatcher.forward(req, resp);
//				resp.sendRedirect("Success.jsp");
			} else {
				req.setAttribute("key", "Invalid Credentials, Please enter Valid Credential");
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("Login.jsp");
				requestDispatcher.forward(req, resp);
			}
		
		}
	}
}
