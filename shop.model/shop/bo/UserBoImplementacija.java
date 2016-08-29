package shop.bo;

import java.sql.SQLException;

import shop.dao.UserDaoImplementacija;
import shop.dto.User;

public class UserBoImplementacija implements UserBoInterface {
	private UserDaoImplementacija dao = new UserDaoImplementacija();
	private ValidateUser valid = new ValidateUser();

	@Override
	public boolean addUser(User user) throws ValidateException {
		if (valid.isValid(user)) {
//REfactor checkout password
			if (userExists(user.getUsername(), user.getPassword())) {
				throw new ValidateException("Taj username vec postoji");
			}

			try {
				dao.addUser(user);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return true;
	}

	@Override
	public User readUser(String username, String password) throws ValidateException {
		User user = null;
		try {
			user = dao.readUser(username, password);

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (user == null) {
			throw new ValidateException("Incorect entry, please try again");
		}
		return user;
	}

	public boolean userExists(String username, String password) {
		try {
			if (dao.readUser(username, password) == null)
				//
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
}
