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
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		if(req.getParameter("archive")!=null){
			int id = Integer.parseInt(req.getParameter("archive"));
			String query = "UPDATE contact SET status = 'Active' WHERE id = ?";
			try{
				ResultsDao.changeStatus(query, id);
			}
			catch(Exception e) {
				System.out.println( e.getMessage());
			}
		}
		if(req.getParameter("active")!=null){
			int id = Integer.parseInt(req.getParameter("active"));
			String query = "UPDATE contact SET status = 'Archive' WHERE id = ?";
			try{
				ResultsDao.changeStatus(query, id);
			}
			catch(Exception e) {
				System.out.println( e.getMessage());
			}
		}
		
		String archiveQuery="SELECT * FROM contact WHERE status='Archive' ORDER BY id";
		List<Data> resultOfArchivedQuery = ResultsDao.sendData(archiveQuery);
		req.setAttribute("listOfArchivedData", resultOfArchivedQuery);
		
		String activeQuery = "SELECT * FROM contact WHERE status = 'Active' ORDER BY id";
		List<Data> resultOfActiveQuery = ResultsDao.sendData(activeQuery);
		req.setAttribute("listOfActiveData", resultOfActiveQuery);
		
		RequestDispatcher rd = req.getRequestDispatcher("results.jsp");
		rd.forward(req, res);
	}
}
