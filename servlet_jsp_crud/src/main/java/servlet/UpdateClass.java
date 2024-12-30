package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dto.User;

@WebServlet("/update")

public class UpdateClass extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		UserDao userDao=new UserDao();
		User user=userDao.fetchUserById(id);
		
		if(user!=null) {
		req.setAttribute("user", user);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("Update.jsp");
		requestDispatcher.forward(req, resp);
		}
		
	}
	
}
