package shop.bo;

import java.util.List;

import shop.dto.Cart;

public interface CartBoInterface {
	public void addCart(Cart cart);
	public void addCart(List<Cart> cart);
	

}
