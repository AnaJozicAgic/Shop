
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.bo.ProductBoImplementacija;
import shop.dto.Product;
import shop.dto.User;

@WebServlet("/ListProduct")
public class ListProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListProduct() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user = (User) request.getSession().getAttribute("user");
		ProductBoImplementacija productBo = new ProductBoImplementacija();
		
		List<Product> products = productBo.listPrducts();

		request.setAttribute("products", products);
		request.getSession().setAttribute("products", products);
		request.getSession().setAttribute("user", user);
		request.getRequestDispatcher("ListProdust.jsp").forward(request, response);

	}

}
