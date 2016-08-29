
import java.io.IOException;
import java.util.ArrayList;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.dto.Product;
import shop.dto.User;


@WebServlet("/Cart")
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        
		User user = (User) request.getSession().getAttribute("user");
		shop.dto.Cart cart =  (shop.dto.Cart)request.getAttribute("cart");
		ArrayList<shop.dto.Cart> cartItems = new ArrayList<>();
		cartItems.add(cart);
		
		ArrayList<Product> products = new ArrayList<>();
		for(shop.dto.Cart  id : cartItems){
			Product product =new Product();
			product.setId(id.getProductid());
			products.add(product);
			
		}
		
		request.setAttribute("products", products);
		request.getSession().setAttribute("user", user);
		request.getRequestDispatcher("Cart.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		;
	}

}
