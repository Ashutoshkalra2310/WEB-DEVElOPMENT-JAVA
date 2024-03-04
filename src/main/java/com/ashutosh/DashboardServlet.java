package com.ashutosh;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
	public void doGet(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
		List<Request> ActiveQuerieList = RequestDao.fetchRequests(true);
		request.setAttribute("ActiveQuerieList", ActiveQuerieList);
		List<Request>ArchiveQuerieList = RequestDao.fetchRequests(false);
		request.setAttribute("ArchiveQuerieList", ArchiveQuerieList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/dashboard.jsp");
		dispatcher.forward(request,response);
	}
	public void doPost(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("archiveid")!=null){
			RequestDao.changeStatus(Integer.parseInt(request.getParameter("archiveid")),false);
		}
		if(request.getParameter("activeid")!=null){
			RequestDao.changeStatus(Integer.parseInt(request.getParameter("activeid")),true);
		}
		response.sendRedirect("dashboard");
	}
}
