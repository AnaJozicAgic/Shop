package shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import shop.dto.Product;

public class ProductDaoImplementacija implements ProductDaoInterface {
	Connection connection = ConectionManager.getInstance().getConnection();

	@Override
	public boolean addProduct(Product product) throws SQLException {

		String query = "INSERT INTO products (name, price, description, img) VALUE (?,?,?,?)";
		PreparedStatement statement = connection.prepareStatement(query);

		statement.setString(1, product.getName());
		statement.setDouble(2, product.getPrice());
		statement.setString(3, product.getDescription());
		statement.setString(4, product.getImg());
		statement.executeUpdate();

		return false;
	}

	@Override
	public Product readProduct(String name) throws SQLException {

		String query = "SELECT * FROM products WHERE name = ?";
		ResultSet rs = null;
		try (PreparedStatement statement = connection.prepareStatement(query);) {

			Product returnedProduct = null;

			statement.setString(1, name);

			rs = statement.executeQuery();

			if (rs.next()) {

				returnedProduct = new Product();

				returnedProduct.setId(rs.getInt("id"));
				returnedProduct.setDescription(rs.getString("description"));
				returnedProduct.setImg(rs.getString("img"));
				returnedProduct.setName(rs.getString("name"));
				returnedProduct.setPrice(rs.getDouble("price"));

			}

			rs.close();

			return returnedProduct;
		}
	}

	@Override
	public Product readProduct(double price) throws SQLException {
		String query = "SELECT * FROM products WHERE price = ?";
		ResultSet rs = null;
		try (PreparedStatement statement = connection.prepareStatement(query);) {

			Product returnedProduct = null;

			statement.setDouble(1, price);

			rs = statement.executeQuery();

			if (rs.next()) {

				returnedProduct = new Product();

				returnedProduct.setId(rs.getInt("id"));
				returnedProduct.setDescription(rs.getString("description"));
				returnedProduct.setImg(rs.getString("img"));
				returnedProduct.setName(rs.getString("name"));
				returnedProduct.setPrice(rs.getDouble("price"));

			}

			rs.close();

			return returnedProduct;
		}
	}

	@Override
	public Product readProduct(int productid) throws SQLException {
		String query = "SELECT * FROM products WHERE id = ?";
		ResultSet rs = null;
		try (PreparedStatement statement = connection.prepareStatement(query);) {

			Product returnedProduct = null;

			statement.setInt(1, productid);

			rs = statement.executeQuery();

			if (rs.next()) {

				returnedProduct = new Product();

				returnedProduct.setId(rs.getInt("id"));
				returnedProduct.setDescription(rs.getString("description"));
				returnedProduct.setImg(rs.getString("img"));
				returnedProduct.setName(rs.getString("name"));
				returnedProduct.setPrice(rs.getDouble("price"));

			}

			rs.close();

			return returnedProduct;
		}
	}

	@Override
	public List<Product> reedAll() throws SQLException {
		ArrayList<Product> products = new ArrayList<>();
		String query = "SELECT * FROM products";
		Product product = null;

		ResultSet rs = null;

		try (PreparedStatement statement = connection.prepareStatement(query);) {

			rs = statement.executeQuery(query);

			while (rs.next()) {

				product = new Product();
				product.setId(rs.getInt("id"));
				product.setDescription(rs.getString("description"));
				product.setImg(rs.getString("img"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getDouble("price"));

				products.add(product);
			}
		}

		return products;

	}

	@Override
	public boolean updateProduct(Product product) throws SQLException {
		String query = "UPDATE products SET name = ?, price = ?, description = ?, img = ? WHERE id = ?";

		try (PreparedStatement statement = connection.prepareStatement(query);) {

			statement.setString(1, product.getName());
			statement.setDouble(2, product.getPrice());
			statement.setString(3, product.getDescription());
			statement.setString(4, product.getImg());
			statement.setInt(5, product.getId());

			statement.executeUpdate();
		}

		return true;
	}

	@Override
	public boolean deleteProduct(Product product) throws SQLException {

		String query = "DELETE FROM products WHERE id = ?";

		try (PreparedStatement statement = connection.prepareStatement(query);) {

			statement.setInt(1, product.getId());

			statement.executeUpdate();
		}

		return true;

	}

	@Override
	public List<Product> searchProducts(String name) throws SQLException {
		List<Product> productList = new ArrayList<>();

		String selectAllQuery = "SELECT * FROM products WHERE name LIKE ?";
		PreparedStatement statement = connection.prepareStatement(selectAllQuery);

		statement.setString(1, "%" + name + "%");

		ResultSet res = statement.executeQuery();

		while (res.next()) {
			Product product = new Product();
			product.setId(res.getInt("id"));
			product.setDescription(res.getString("description"));
			product.setImg(res.getString("img"));
			product.setName(res.getString("name"));
			product.setPrice(res.getDouble("price"));
			productList.add(product);
		}

		return productList;
	}

}
