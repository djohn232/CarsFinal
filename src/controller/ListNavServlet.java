package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Car;

/**
 * Servlet implementation class ListNavServlet
 */
@WebServlet("/listNavServlet")
public class ListNavServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListNavServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CarHelper dao = new CarHelper();
		String act = request.getParameter("doThisToItem");
		String path = "/viewAllCarsServlet";
		
		if (act.equals("delete")) {
		} 
		else if (act.equals("edit")) {
			try {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			Car itemToEdit = dao.searchForCarById(tempId);
			request.setAttribute("itemToEdit", itemToEdit);
			path = "/editCars.jsp";
			} catch(NumberFormatException e) {
				System.out.println("Nothing Selected.");
			}
		} 
		else if (act.equals("add")) {
		path = "/index.html";
		}
		getServletContext().getRequestDispatcher(path).forward(request,
		response);
				
		try {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			Car toDelete = dao.searchForCarById(tempId);
			dao.deleteItem(toDelete);
			} catch(NumberFormatException e) {
				System.out.println("Nothing Selected.");
			}
		
		doGet(request, response);
	}

}
