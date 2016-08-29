
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.dto.Cart;
import shop.dto.User;



@WebServlet("/purchase")
public class Purchase extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Purchase() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		int productId = Integer.parseInt(request.getParameter("id"));
		User user = (User)request.getSession().getAttribute("user");
		
		Cart cart = new Cart();
		Date date= new Date(System.currentTimeMillis());
		

		cart.setProductid(productId);
		cart.setDateTime(date);
		
		
		
		request.getSession().setAttribute("user", user);
		request.setAttribute("cart", cart);
		request.getRequestDispatcher("Cart").forward(request, response);
	}



}
