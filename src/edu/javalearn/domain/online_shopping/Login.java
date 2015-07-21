package edu.javalearn.domain.online_shopping;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String UserName = request.getParameter("UserName");
		String Password = request.getParameter("Password");
		try {
			Connection connection = null;
			connection = Login.dbConnect();
			Statement statement = null;
			statement = connection.createStatement();
			ResultSet resultSet = statement
					.executeQuery("SELECT * FROM Customer WHERE UserName='"
							+ UserName + "'and Pass='" + Password + "'");
			if (resultSet.next()) {
				HttpSession session = request.getSession();
				/**
				 * if (!(session.getAttribute("UserName").equals(UserName))) {
				 * session.setAttribute("UserName", UserName); }
				 */

				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("/Welcome.jsp");
				requestDispatcher.forward(request, response);
			} else {
				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("/index.jsp");
				requestDispatcher.forward(request, response);
			}
			connection.close();
		} catch (SQLException sqlexception) {
			sqlexception.printStackTrace();
		} catch (ClassNotFoundException classNotFound) {
			classNotFound.printStackTrace();
		}
	}

	public static Connection dbConnect() throws SQLException,
			ClassNotFoundException {
		Connection connection = null;
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=Online_Shopping_Project;user=sa;password=optimus@123";
		connection = DriverManager.getConnection(dbURL);
		return connection;

	}
}
