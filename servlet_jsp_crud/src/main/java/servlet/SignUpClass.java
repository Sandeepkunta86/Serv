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
@WebServlet("/SignUp")
public class SignUpClass extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		int age =Integer.parseInt( req.getParameter("age"));
		String address = req.getParameter("address");
		long phone = Long.parseLong(req.getParameter("phone"));
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		User user = new User();
		user.setName(name);
		user.setAge(age);
		user.setAddress(address);
		user.setPhone(phone);
		user.setEmail(email);
		user.setPassword(password);
		
		UserDao userDao = new UserDao();
		User dbUser=userDao.saveUser(user);
		
		if(dbUser != null) {
			req.setAttribute("key", "successfully signed up ....please login");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("Login.jsp");
			requestDispatcher.forward(req, resp);
		}
	}
}
