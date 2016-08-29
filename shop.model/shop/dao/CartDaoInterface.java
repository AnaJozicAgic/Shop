package shop.dao;

import java.sql.SQLException;
import java.util.List;
import shop.dto.Cart;

public interface CartDaoInterface {
	
	public void addToCart(Cart cart) throws SQLException;

	public void addToCart(List<Cart> cart) throws SQLException;
	

}
