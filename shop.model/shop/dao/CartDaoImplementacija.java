package shop.dao;

import java.util.List;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import shop.dto.Cart;

public class CartDaoImplementacija implements CartDaoInterface {

	Connection connection = ConectionManager.getInstance().getConnection();

	@Override
	public void addToCart(Cart cart) throws SQLException {

		String query = "INSERT INTO cart (userid, date_time, productID) VALUE (?,?,?)";

		PreparedStatement stetement = connection.prepareStatement(query);

		stetement.setInt(1, cart.getUserid());
		stetement.setDate(2, (Date) cart.getDateTime());
		stetement.setInt(3, cart.getProductid());

		stetement.executeUpdate();

	}

	@Override
	public void addToCart(List<Cart> cart) throws SQLException {
		String query = "INSERT INTO cart (userid, date_time, productID) VALUE (?,?,?)";

		PreparedStatement stetement = connection.prepareStatement(query);
		
		for (int i = 0; i < cart.size(); i++) {
			stetement.setInt(1, cart.get(i).getUserid());
			stetement.setDate(2, (Date) cart.get(i).getDateTime());
			stetement.setInt(3, cart.get(i).getProductid());

			stetement.executeUpdate();

		}
	}

}
