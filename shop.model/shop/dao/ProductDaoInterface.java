package shop.dao;

import java.sql.SQLException;
import java.util.List;

import shop.dto.Product;

public interface ProductDaoInterface {
	public boolean addProduct(Product product) throws SQLException;

	public Product readProduct(String name) throws SQLException;

	public Product readProduct(double price) throws SQLException;

	public Product readProduct(int productid) throws SQLException;

	public List<Product> reedAll() throws SQLException;

	public boolean updateProduct(Product product) throws SQLException;

	public boolean deleteProduct(Product product) throws SQLException;

	public List<Product> searchProducts(String name) throws SQLException;

}
