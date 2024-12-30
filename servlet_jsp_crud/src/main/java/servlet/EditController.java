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

@WebServlet("/edit")

public class EditController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		int age =Integer.parseInt( req.getParameter("age"));
		String address = req.getParameter("address");
		long phone = Long.parseLong(req.getParameter("phone"));
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setAge(age);
		user.setAddress(address);
		user.setPhone(phone);
		user.setEmail(email);
		user.setPassword(password);
		
		UserDao userDao = new UserDao();
		User updatedUser=userDao.updateUser(user);
		
		if(updatedUser !=null) {
			List<User>list=userDao.fetchAllUsers();
			req.setAttribute("k", list);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("Display.jsp");
			requestDispatcher.forward(req, resp);
		
		}
	}
}
