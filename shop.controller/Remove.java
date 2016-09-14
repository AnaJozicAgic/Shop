
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.dto.Product;
import shop.dto.User;

@WebServlet("/remove")
public class Remove extends HttpServlet {
	private static final long serialVersionUID = 549738575954573232L;

	public Remove() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int productId = Integer.parseInt(request.getParameter("id"));
		User user = (User) request.getSession().getAttribute("user");
		Product product;
		List<Product> cart = (List<Product>) request.getSession().getAttribute("cart");
		double totalAmounth=0;
		
		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i).getId() == productId) {
				cart.remove(cart.get(i));
			}
		}
		
		for(int i=0; i<cart.size();i++){
			totalAmounth+=cart.get(i).getPrice();
		}
		
		request.getSession().setAttribute("user", user);
		request.getSession().setAttribute("cart", cart);
		request.setAttribute("message", totalAmounth);
		request.getRequestDispatcher("Cart.jsp").forward(request, response);
		return;
	}

}
