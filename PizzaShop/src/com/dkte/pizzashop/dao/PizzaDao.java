package com.dkte.pizzashop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dkte.pizzashop.entities.Pizza;
import com.dkte.DButils.*;

public class PizzaDao implements AutoCloseable {
	private Connection connection;

	public PizzaDao() throws SQLException {
		connection = DButil.getConnection();
	}

	public List<Pizza> getAllPizza() throws SQLException {
		String sql = "SELECT *FROM menu";
		List<Pizza> pizzaList = new ArrayList<Pizza>();
		try (PreparedStatement selectStmt = connection.prepareCall(sql)) {
			ResultSet rs = selectStmt.executeQuery();
			while (rs.next()) {
				Pizza pizza = new Pizza();
				pizza.setMid(rs.getInt(1));
				pizza.setName(rs.getString(2));
				pizza.setDescription(rs.getString(3));
				pizza.setPrice(rs.getDouble(4));

				pizzaList.add(pizza);
			}
		}
		return pizzaList;
	}

	@Override
	public void close() throws SQLException {
		if (connection != null)
			connection.close();

	}
}
