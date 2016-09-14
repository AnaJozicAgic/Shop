
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

/**
 * Servlet implementation class EditProduct
 */
@WebServlet("/editProduct")
public class EditProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditProduct() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int productId = Integer.parseInt(request.getParameter("id"));
		User user = (User) request.getSession().getAttribute("user");
		Product product;
		ProductBoImplementacija bo = new ProductBoImplementacija();
		try {
			product=bo.readProduct(productId);
			
			request.getSession().setAttribute("user", user);
			request.getSession().setAttribute("product", product);
			request.getRequestDispatcher("EditForm.jsp").forward(request, response);
		} catch (ValidateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		Product product = (Product) request.getSession().getAttribute("product");
		ProductBoImplementacija bo = new ProductBoImplementacija();
		Product t = bo.readProduct(product.getName());
		bo.updateProduct(t);
		
		request.getSession().setAttribute("user", user);
		request.getRequestDispatcher("listProducts").forward(request, response);
		
	}

}
