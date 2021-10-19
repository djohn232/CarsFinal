package controller;

import java.io.IOException;  
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Car;
import model.garageDetails;

/**
 * Servlet implementation class addCarServlet
 */
@WebServlet("/addCarServlet")
public class addCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addCarServlet() {
        super();
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String year = request.getParameter("Year");
		String make = request.getParameter("Make");
		String model = request.getParameter("Model");
		
		Car li = new Car(year, make, model);
		CarHelper dao = new CarHelper();
		dao.insertItem(li);
				
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
