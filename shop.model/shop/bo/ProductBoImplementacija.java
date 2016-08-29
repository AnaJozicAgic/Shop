package shop.bo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import shop.dao.ProductDaoImplementacija;
import shop.dto.Product;

public class ProductBoImplementacija implements ProductBoInterface {
	
	private ProductDaoImplementacija dao = new ProductDaoImplementacija();

	@Override
	public boolean addProduct(Product product) throws ValidateException {
		if (productExists(product.getId())) {
			//Napravit kompozit ki - Sifra proizvoda
			throw new ValidateException("Taj product vec postoji");
		}
		try {
			dao.addProduct(product);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public Product readProduct(int productId) throws ValidateException {
		Product product = null;
		if (!productExists(productId)) {
			throw new ValidateException("Taj product ne postoji");
		}
		try {
			product = dao.readProduct(productId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public boolean updateProduct(Product product) {

		try {
			dao.updateProduct(product);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;

	}

	@Override
	public boolean deleteProduct(Product product) {

		try {
			dao.deleteProduct(product);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Product> listPrducts() {
		List<Product> productList = new ArrayList<>();
		try {
			productList = dao.reedAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productList;
	}

	@Override
	public boolean productExists(int productID) {
		try {
			if (dao.readProduct(productID) == null)
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public List<Product> searchPrducts(String name) {
		List<Product> searchProductsList = null;
		try {
			searchProductsList = dao.searchProducts(name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return searchProductsList;
	}

	@Override
	public Product readProduct(double price) {
		Product product = null;
		try {
			product = dao.readProduct(price);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public Product readProduct(String name) {
		Product product = null;
		try {
			product = dao.readProduct(name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;

	}

}
