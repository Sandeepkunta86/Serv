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
@WebServlet("/delete")
public class DeleteUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	int id =Integer.parseInt(req.getParameter("id"));
    	
    	UserDao userDao = new UserDao();
    	boolean result=userDao.deleteUser(id);
    	
    	if(result) {
    		List<User>list=userDao.fetchAllUsers();
    		req.setAttribute("k", list);
    		RequestDispatcher requestDispatcher = req.getRequestDispatcher("Display.jsp");
    		requestDispatcher.forward(req, resp);
    	}
    }

}