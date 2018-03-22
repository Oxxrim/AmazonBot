package org.itstep.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.itstep.model.Account;
import org.itstep.model.Action;

public class ActionDAO {

	public void save(Action action) {
		Connection con = null;
		PreparedStatement statement = null;
		String sql = "INSERT INTO actions(asin, login, add_to_cart, time) VALUES(?, ?, ?, ?)";
		try {
			con = DBConnection.getConnection();
			statement = con.prepareStatement(sql);
			statement.setString(1, action.getAsin());
			statement.setString(2, action.getLogin());
			statement.setString(3, action.getAdd());
			statement.setLong(4, action.getTime());
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				statement.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
