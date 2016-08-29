
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

@WebServlet("/search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Search() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		String search = request.getParameter("product");
		User user = (User) request.getSession(false).getAttribute("user");
		ProductBoImplementacija bo = new ProductBoImplementacija();

		List<Product> products = bo.searchPrducts(search);

		request.setAttribute("products", products);
		request.getSession().setAttribute("user", user);
		request.getRequestDispatcher("ListProdust.jsp").forward(request, response);
	}

}
