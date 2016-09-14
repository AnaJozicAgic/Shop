
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import shop.bo.UserBoImplementacija;
import shop.bo.ValidateException;

import shop.dto.Product;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		shop.dto.User user = null;
		List<Product> cart = new ArrayList<>();

		UserBoImplementacija userBo = new UserBoImplementacija();

		try {
			user = userBo.readUser(username, password);
			HttpSession sesion = request.getSession();
			sesion.setAttribute("user", user);

			HttpSession session2 = request.getSession();
			session2.setAttribute("cart", cart);
			
			if (user.getRolle().equals("administrator")) {
				response.sendRedirect("Admin.jsp");
			} else {
				response.sendRedirect("Succes.jsp");
			}
			
		} catch (ValidateException x) {
			request.setAttribute("message", x.getMessage());
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		} catch (Exception e) {
			response.sendRedirect("Login.jsp");

		}

	}

}
