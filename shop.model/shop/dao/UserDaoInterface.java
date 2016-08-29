package shop.dao;

import java.sql.SQLException;

import shop.dto.User;

public interface UserDaoInterface {
	
	public boolean addUser(User user) throws SQLException;

	public User readUser(String username, String password) throws SQLException;

}
