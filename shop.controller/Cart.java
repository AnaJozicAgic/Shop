
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
		List<Product>products=(List<Product>) request.getSession().getAttribute("products");
		Product product =(Product) request.getAttribute("product");
		products.add(product);
		
	

		
		request.getSession().setAttribute("products", products);
		request.getSession().setAttribute("user", user);
		request.getRequestDispatcher("Cart.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		;
	}

}
