package com.mindtree.servlets;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mindtree.dao.EntryDaoImpl;

/**
 * Servlet implementation class Entry
 */
@WebServlet("/entry")
public class Entry extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Entry() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		int answer = 0;
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String skills = request.getParameter("skills");
		answer = new EntryDaoImpl().setDatas(name, age, skills);
		if (answer != 0) {
			try {
				response.sendRedirect("home.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
