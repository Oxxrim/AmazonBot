package org.itstep.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.itstep.model.Account;
import org.itstep.model.Good;

public class AccountDAO {
	
	public void save(Account account) {
		Connection con = null;
		PreparedStatement statement = null;
		String sql = "INSERT INTO accounts(name, email, password) VALUES(?, ?, ?)";
		try {
			con = DBConnection.getConnection();
			statement = con.prepareStatement(sql);
			statement.setString(1, account.getName());
			statement.setString(2, account.getEmail());
			statement.setString(3, account.getPassword());
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
	
	public ArrayList getAsin() {
		
		ArrayList<String> asins = new ArrayList();
		
		Connection con = null;
		PreparedStatement statement = null;
		String sql = "SELECT asin FROM goods";
		ResultSet resultSet = null;
		try {
			con = DBConnection.getConnection();
			statement = con.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				asins.add(resultSet.getString("asin"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				statement.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return asins;
	}
}