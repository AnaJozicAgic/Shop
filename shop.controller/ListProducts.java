

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.bo.ProductBoImplementacija;
import shop.dto.Product;
import shop.dto.User;

@WebServlet("/listProducts")
public class ListProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListProducts() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		User user = (User) request.getSession().getAttribute("user");
		
		List<Product> products = new ArrayList<>();
		ProductBoImplementacija bo = new ProductBoImplementacija();
		 
		products = bo.listPrducts();
		
		request.getSession().setAttribute("user", user);
		request.setAttribute("products", products);
		request.getRequestDispatcher("EditProduct.jsp").forward(request, response);
		
	}



}
