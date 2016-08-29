package shop.bo;

import java.sql.SQLException;
import java.util.List;

import shop.dao.CartDaoImplementacija;
import shop.dto.Cart;

public class CartBoImplementacija implements CartBoInterface{
CartDaoImplementacija dao= new CartDaoImplementacija();
	@Override
	public void addCart(Cart cart) {
	if(cart!=null){
		try {
			dao.addToCart(cart);
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}
		
	}

	@Override
	public void addCart(List<Cart> cart) {
		if(cart!=null){
			try {
				dao.addToCart(cart);
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}
	}

}
