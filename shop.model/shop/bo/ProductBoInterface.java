package shop.bo;

import java.util.List;

import shop.dto.Product;

public interface ProductBoInterface {
	public boolean addProduct(Product product) throws ValidateException;

	public Product readProduct(int productId) throws ValidateException;

	public boolean updateProduct(Product product);

	public boolean deleteProduct(Product product);

	public List<Product> listPrducts();

	public boolean productExists(int productID);

	public List<Product> searchPrducts(String name);

	public Product readProduct(double price);

	public Product readProduct(String name);
}
