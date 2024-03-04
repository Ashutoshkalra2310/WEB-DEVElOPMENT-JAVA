package com.ashutosh;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/request")
public class ResultServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("archive")!=null){
			int id = Integer.parseInt(request.getParameter("archive"));
			String query = "UPDATE contact SET status = 'Active' WHERE id = ?";
			try{
				ResultsDao.changeStatus(query, id);
			}
			catch(Exception exception) {
				System.out.println(exception.getMessage());
			}
		}
		if(request.getParameter("active")!=null){
			int id = Integer.parseInt(request.getParameter("active"));
			String query = "UPDATE contact SET status = 'Archive' WHERE id = ?";
			try{
				ResultsDao.changeStatus(query, id);
			}
			catch(Exception exception) {
				System.out.println(exception.getMessage());
			}
		}
		
		String archiveQuery="SELECT * FROM contact WHERE status='Archive' ORDER BY id";
		List<Data> resultOfArchivedQuery = ResultsDao.sendData(archiveQuery);
		request.setAttribute("listOfArchivedData", resultOfArchivedQuery);
		
		String activeQuery = "SELECT * FROM contact WHERE status = 'Active' ORDER BY id";
		List<Data> resultOfActiveQuery = ResultsDao.sendData(activeQuery);
		request.setAttribute("listOfActiveData", resultOfActiveQuery);
		
		RequestDispatcher rd = request.getRequestDispatcher("results.jsp");
		rd.forward(request, response);
	}
}
