
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.bo.ProductBoImplementacija;
import shop.bo.ValidateException;
import shop.dto.Product;
import shop.dto.User;

@WebServlet("/addProduct")
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user = (User) request.getSession().getAttribute("user");
		String name = request.getParameter("name");
		double price = Double.parseDouble(request.getParameter("price"));
		String description = request.getParameter("description");

		ProductBoImplementacija bo = new ProductBoImplementacija();
		Product product = new Product();
		
		product.setName(name);
		product.setPrice(price);
		product.setDescription(description);

		try {
			bo.addProduct(product);
			
			request.getSession().setAttribute("user", user);
			response.sendRedirect("listProducts");
			
		} catch (ValidateException e) {
			e.printStackTrace();
		}
	}

}
