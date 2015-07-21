package edu.javalearn.domain.online_shopping;

import java.io.IOException;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class Cart
 */
@WebServlet("/Cart")
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);

		if (session != null) {
			String Pen[] = (String[]) session.getAttribute("Pen");
			String Novel[] = (String[]) session.getAttribute("Novel");
			String Book[] = (String[]) session.getAttribute("Book");

			String PenQuantity[] = (String[]) session
					.getAttribute("Penquantity");
			String BookQuantity[] = (String[]) session
					.getAttribute("Bookquantity");
			String NovelQuantity[] = (String[]) session
					.getAttribute("Novelquantity");

			out.println("<html><body>");
			out.println("<table bgcolor='yellow' border=1 width=1000>");

			if (Pen != null) {
				out.println("<tr>");
				out.println("<td>Pen</td>");

				for (int m = 0; m < Pen.length; m++) {
					out.println("<td>" + Pen[m] + "</td>");
					out.println("<td>" + PenQuantity[m] + "</td>");
				}
				out.println("</tr>");
			}
			if (Novel != null) {
				out.println("<tr>");
				out.println("<td>Novel</td>");

				for (int m = 0; m < Novel.length; m++) {
					out.println("<td>" + Novel[m] + "</td>");
					out.println("<td>" + NovelQuantity[m] + "</td>");
				}
				out.println("</tr>");
			}
			if (Book != null) {
				out.println("<tr>");
				out.println("<td>Book</td>");

				for (int m = 0; m < Book.length; m++) {
					out.println("<td>" + Book[m] + "</td>");
					out.println("<td>" + BookQuantity[m] + "</td>");
				}
				out.println("</tr>");
			}
			out.println("</table>");
			out.println("</body></html>");
			out.print(" <a href=\"Logout\">Logout</a>");
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
		}
	}

}
