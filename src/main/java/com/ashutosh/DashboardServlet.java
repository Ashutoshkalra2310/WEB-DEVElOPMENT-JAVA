package com.ashutosh;

import java.util.List;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
	public void doGet(HttpServletRequest request , HttpServletResponse response) {
		List<Request> ActiveQuerieList = RequestDao.fetchResults(true);
		request.setAttribute("ActiveQuerieList", ActiveQuerieList);
		List<Request>ArchiveQuerieList = RequestDao.fetchResults(false);
		request.setAttribute("ArchiveQuerieList", ArchiveQuerieList);
	}
}
