package shop.bo;

public interface Validate<T> {

	public boolean isValid(T object) throws ValidateException;
}
