
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.bo.UserBoImplementacija;
import shop.bo.ValidateException;
import shop.dto.User;

/**
 * Servlet implementation class Register
 */
@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserBoImplementacija bo;

	public Register() {

	}

	@Override
	public void init() throws ServletException {
		super.init();
		bo = new UserBoImplementacija();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		User user = new User();
		if (request.getParameter("password2").equals(request.getParameter("password"))) {
			user.setUsername(request.getParameter("username"));
			user.setPassword(request.getParameter("password"));
			user.setRolle("user");
		} else {
			request.setAttribute("message", "Entered passwords do not match.");
			request.getRequestDispatcher("Register.jsp").forward(request, response);
		}

		try {
			bo.addUser(user);
			request.setAttribute("message", "Signup Succes!");
			request.getRequestDispatcher("Login.jsp").forward(request, response);

		} catch (ValidateException e) {
			request.setAttribute("message", e.getMessage());
			request.getRequestDispatcher("Register.jsp").forward(request, response);
		}
	}

}
