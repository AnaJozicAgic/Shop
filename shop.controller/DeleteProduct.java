

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.bo.ProductBoImplementacija;
import shop.bo.ValidateException;
import shop.dto.User;

/**
 * Servlet implementation class DeleteProduct
 */
@WebServlet("/deleteProduct")
public class DeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productId = Integer.parseInt(request.getParameter("id"));
		User user = (User) request.getSession().getAttribute("user");
		
		ProductBoImplementacija bo = new ProductBoImplementacija();
		try {
			bo.deleteProduct(bo.readProduct(productId));
			request.getSession().setAttribute("user", user);
			request.getRequestDispatcher("listProducts").forward(request, response);
		} catch (ValidateException e) {
			e.printStackTrace();
		}
	}

}
