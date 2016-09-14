
import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import shop.bo.CartBoImplementacija;
import shop.bo.ProductBoImplementacija;
import shop.bo.ValidateException;
import shop.dto.Cart;
import shop.dto.Product;
import shop.dto.User;

@WebServlet("/purchase")
public class Purchase extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2883725492689853255L;
	ProductBoImplementacija bo = new ProductBoImplementacija();

	public Purchase() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int productId = Integer.parseInt(request.getParameter("id"));
		User user = (User) request.getSession().getAttribute("user");
		Product product;
		List<Product> cart = (List<Product>) request.getSession().getAttribute("cart");
		double totalAmounth = 0;
		try {
			product = bo.readProduct(productId);

			cart.add(product);

			for (int i = 0; i < cart.size(); i++) {
				totalAmounth += cart.get(i).getPrice();
			}

			request.getSession().setAttribute("user", user);
			request.getSession().setAttribute("cart", cart);
			request.setAttribute("message", totalAmounth);
			request.getRequestDispatcher("Cart.jsp").forward(request, response);
			return;

		} catch (ValidateException e) {
			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User) req.getSession().getAttribute("user");
		List<Product> cart = (List<Product>) req.getSession().getAttribute("cart");

		CartBoImplementacija cartBo = new CartBoImplementacija();
		Cart cart0;

		long time = new java.util.Date().getTime();
		
		for (int i = 0; i < cart.size(); i++) {
			cart0 = new Cart();
			cart0.setDateTime(new Date(time));
			cart0.setProductid(cart.get(i).getId());
			cart0.setUserid(user.getId());
			cartBo.addCart(cart0);

		}

		cart.clear();

		req.getSession().setAttribute("user", user);
		req.getSession().setAttribute("cart", cart);
		req.getRequestDispatcher("Succes.jsp").forward(req, resp);
	}

}
