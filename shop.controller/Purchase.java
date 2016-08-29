
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

import shop.bo.ProductBoImplementacija;
import shop.bo.ValidateException;
import shop.dto.Cart;
import shop.dto.Product;
import shop.dto.User;

@WebServlet("/purchase")
public class Purchase extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductBoImplementacija bo = new ProductBoImplementacija();

	public Purchase() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int productId = Integer.parseInt(request.getParameter("id"));
		User user = (User) request.getSession().getAttribute("user");
		Product product;
		try {
			product = bo.readProduct(productId);
			
			request.getSession().setAttribute("user", user);
			request.setAttribute("product", product);
			request.getRequestDispatcher("Cart").include(request, response);
			return;
			
		} catch (ValidateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
