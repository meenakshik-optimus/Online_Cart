package edu.javalearn.domain.online_shopping;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		String UserName = request.getParameter("UserName");
		String Password = request.getParameter("Password");

		PrintWriter out = response.getWriter();
		out.println("<html><body>");

		try {
			Connection connection = null;
			connection = Login.dbConnect();
			Statement statement = null;
			statement = connection.createStatement();
			ResultSet resultSet = statement
					.executeQuery("SELECT * FROM Customer WHERE UserName='"
							+ UserName + "'and Pass='" + Password + "'");
			if (resultSet.next()) {
				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("/UserExist");
				requestDispatcher.forward(request, response);
			} else {
				String query = "insert into Customer values('" + UserName
						+ "','" + Password + "')";
				statement.executeUpdate(query);
				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("/Welcome");
				requestDispatcher.forward(request, response);
			}
		} catch (SQLException sqlexception) {
			sqlexception.printStackTrace();
		} catch (ClassNotFoundException classNotFound) {
			classNotFound.printStackTrace();
		}
	}
}
