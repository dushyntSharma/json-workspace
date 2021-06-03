package com.mindtree.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mindtree.model.Employee;

/**
 * Servlet implementation class HomeServlet
 */
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Employee> empList = new ArrayList<Employee>();
		Employee emp1 = new Employee();
		emp1.setId(1);
		emp1.setName("Shreevatsa MS");
		emp1.setSkills("Java");
		Employee emp2 = new Employee();
		emp2.setId(2);
		emp2.setName("Vignesh Sharma");
		emp2.setSkills("Python");
		empList.add(emp1);
		empList.add(emp2);
		request.setAttribute("empList", empList);
// 		List<Employee> empNew = new ArrayList<Employee>();
// 		empNew.add(e);
		request.setAttribute("htmlTagData", "<br/> creates a new line.");
		request.setAttribute("url", "https://github.com/dushyntSharma");
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/jstl.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
