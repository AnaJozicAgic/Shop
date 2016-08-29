package shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import shop.dto.User;

public class UserDaoImplementacija implements UserDaoInterface {
	Connection connection = ConectionManager.getInstance().getConnection();

	@Override
	public boolean addUser(User user) throws SQLException {
		String query = "INSERT INTO users (username, password, rolle) VALUE (?,?,?)";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, user.getUsername());
		statement.setString(2, user.getPassword());
		statement.setString(3, user.getRolle());
		statement.executeUpdate();
		return false;
	}

	@Override
	public User readUser(String username, String password) throws SQLException {

		String query = "SELECT * FROM users WHERE username = ? AND password=?";
	
		ResultSet rs = null;
		try (PreparedStatement statement = connection.prepareStatement(query);) {
			User user = null;
		
			statement.setString(1, username);
			statement.setString(2, password);
			rs = statement.executeQuery();

			if (rs.next()) {
				user = new User();

				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setRolle(rs.getString("rolle"));

			}
			
			rs.close();
			return user;
		}

	}

}
