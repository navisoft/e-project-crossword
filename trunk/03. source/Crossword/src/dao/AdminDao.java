package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DataUtil;

public class AdminDao {
	public static boolean insertAdminUserAndPass(String user, String pass) {
		boolean result = false;
		String sql = "INSERT INTO USERS VALUES(?,?)";
		try {
			PreparedStatement statement = DataUtil.getConnection().prepareStatement(sql);
			statement.setString(1, user);
			statement.setString(2, pass);
			statement.execute();
			result = true;
		} catch (SQLException e) {
			result = false;
		}
		return result;
	}
	public static boolean checkExistsAdmin() {
		boolean result = false;
		String sql = "SELECT * FROM USERS";
		ResultSet set = DataUtil.executeQuery(sql);
		try {
			while (set.next()) {
				result = true;
			}
		} catch (SQLException e) {
			result = false;
		}
		return result;
	}
	public static boolean checkExistsUsername(String user) {
		boolean result = false;
		String sql = "SELECT * FROM USERS WHERE USERNAME =?";
		PreparedStatement statement;
		try {
			statement = DataUtil.getConnection().prepareStatement(sql);
			statement.setString(1, user);
			ResultSet resultSet = statement.executeQuery();
			try {
				while (resultSet.next()) {
					result = true;
				}
			} catch (SQLException e) {
				result = false;
			}
		} catch (SQLException e1) {
			return false;
		}
		return result;
	}

	public static boolean checkRightPassword(String user, String pass) {
		boolean result = false;
		String sql = "SELECT * FROM USERS WHERE USERNAME =? AND PASSWORD =?";
		PreparedStatement statement;
		try {
			statement = DataUtil.getConnection().prepareStatement(sql);
			statement.setString(1, user);
			statement.setString(2, pass);
			ResultSet resultSet = statement.executeQuery();
			try {
				while (resultSet.next()) {
					result = true;
				}
			} catch (SQLException e) {
				result = false;
			}
		} catch (SQLException e1) {
			return false;
		}
		return result;
	}
	public static boolean updateAccount(String password) {
		boolean result = false;
		String sql = "UPDATE USERS SET PASSWORD = ?";
		try {
			PreparedStatement statement = DataUtil.getConnection().prepareStatement(sql);
			statement.setString(1, password);
			statement.execute();
			result = true;
		} catch (SQLException e) {
			result = false;
		}
		return result;
	}
}











