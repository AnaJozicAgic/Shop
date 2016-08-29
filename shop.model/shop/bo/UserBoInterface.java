package shop.bo;

import shop.dto.User;

public interface UserBoInterface {
	public boolean addUser(User user) throws ValidateException;

	public User readUser(String username, String password) throws ValidateException;
}
