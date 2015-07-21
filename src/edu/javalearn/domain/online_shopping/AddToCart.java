package edu.javalearn.domain.online_shopping;

import java.io.IOException;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class AddToCart
 */
@WebServlet("/AddToCart")
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		if (session != null) {
			String category = (String) session.getAttribute("Category");
			

			if ((category.toString()).equals("Pen")) {
				String[] Pen = request.getParameterValues("Category");
				String[] quantity = request.getParameterValues("quantity");
				session.setAttribute("Pen", Pen);
				session.setAttribute("Penquantity", quantity);
			}

			if (category.equals("Novel")) {
				String[] Novel = request.getParameterValues("Category");
				String[] quantity = request.getParameterValues("quantity");
				session.setAttribute("Novel", Novel);
				session.setAttribute("Novelquantity", quantity);
			}

			if (category.equals("Book")) {
				String[] Book = request.getParameterValues("Category");
				String[] quantity = request.getParameterValues("quantity");
				session.setAttribute("Book", Book);
				session.setAttribute("Bookquantity", quantity);
			}

			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("/Welcome.jsp");
			requestDispatcher.forward(request, response);
		} else {
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("/index.jsp");
			requestDispatcher.forward(request, response);
		}
	}

}
