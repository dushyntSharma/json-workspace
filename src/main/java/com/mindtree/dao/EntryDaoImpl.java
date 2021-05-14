package com.mindtree.dao;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import com.mindtree.model.Employee;

public class EntryDaoImpl implements EntryDao {

	static String url = "jdbc:mysql://127.0.0.1:3306/person";
	static String user = "root";
	static String password = "9909";
	PreparedStatement ps = null;
	Connection con = null;
	Statement st = null;
	ResultSet rs = null;

	@Override
	public int setDatas(String name, int age, String skills) {
		// TODO Auto-generated method stub
		String sql1 = "insert into employee(id, name, age, skills) values(?,?,?,?)";
		int answer = 0;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			Random rand = SecureRandom.getInstanceStrong();
			int id = rand.nextInt();
			ps = con.prepareStatement(sql1);
			ps.setInt(1, Math.abs(id));
			ps.setString(2, name);
			ps.setInt(3, age);
			ps.setString(4, skills);
			answer = ps.executeUpdate();
			return answer;
		} catch (NoSuchAlgorithmException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (ps != null)
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return 0;
	}

	@Override
	public List<Employee> getValues() {
		// TODO Auto-generated method stub
		String sql = "select * from employee;";
		List<Employee> emp = new LinkedList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Employee obj = new Employee();
				obj.setId(rs.getInt("id"));
				obj.setName(rs.getString("name"));
				obj.setAge(rs.getInt("age"));
				obj.setSkills(rs.getString("skills"));
				emp.add(obj);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (st != null)
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		return emp;
	}

}
