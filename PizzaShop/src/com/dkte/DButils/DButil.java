package com.dkte.DButils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DButil {

		private static final String URL = "jdbc:mysql://localhost:3306/pizzastore_db";
		private static final String USERNAME = "root";
		private static final String PASSWORD = "Rits@0104";

		public static Connection getConnection() throws SQLException {
			
			//Connection connection =DBUtil.getConnection();
			
			return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	
		}
	}

