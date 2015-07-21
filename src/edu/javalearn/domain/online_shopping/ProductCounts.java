package edu.javalearn.domain.online_shopping;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductCounts {
	public String category;

	public ResultSet getResultSet(String s) {
		this.category = s;
		ResultSet rs = null;
		try {
			Connection connection = null;
			connection = Login.dbConnect();
			Statement statement = null;
			statement = connection.createStatement();
			rs = statement
					.executeQuery("Select * from Products WHERE Category='"
							+ category + "'");

		}

		catch (SQLException sqlException) {
			sqlException.printStackTrace();
		} catch (ClassNotFoundException classNotFound) {
			classNotFound.printStackTrace();
		}
		return rs;
	}
}
