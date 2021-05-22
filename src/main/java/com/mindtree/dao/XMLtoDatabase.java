package com.mindtree.dao;

import java.io.*;
import java.sql.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;

public class XMLtoDatabase {
	static String url = "jdbc:mysql://127.0.0.1:3306/playerjson";
	static String user = "root";
	static String password = "9909";

	public static Connection ConnectToDB() throws Exception {
		// Registering the Driver
		Connection con = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url, user, password);
		System.out.println("Connection established......");
		return con;
	}

	public static void main(String[] args) {
		try {
			Connection con = ConnectToDB();

			Statement st = con.createStatement();

			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			Document doc = docBuilder
					.parse(new File("C:/Users/M1064478/Desktop/Eclipse WorkSpaces/XML&JSON/Files/XmlTodatabse.xml"));

			doc.getDocumentElement().normalize();

			System.out.println("Root element of the doc is " + doc.getDocumentElement().getNodeName());

			NodeList listOfPersons = doc.getElementsByTagName("employee");

			for (int s = 0; s < listOfPersons.getLength(); s++) {

				Node firstPersonNode = listOfPersons.item(s);

				if (firstPersonNode.getNodeType() == Node.ELEMENT_NODE) {

					Element firstPersonElement = (Element) firstPersonNode;

					NodeList nameList = firstPersonElement.getElementsByTagName("name");
					Element nameElement = (Element) nameList.item(0);

					NodeList textFNList = nameElement.getChildNodes();
					String name = ((Node) textFNList.item(0)).getNodeValue().trim();

					NodeList addressList = firstPersonElement.getElementsByTagName("address");
					Element addressElement = (Element) addressList.item(0);

					NodeList textLNList = addressElement.getChildNodes();
					String address = ((Node) textLNList.item(0)).getNodeValue().trim();

					int i = st.executeUpdate(
							"insert into firstxml(name,address) values('" + name + "','" + address + "')");
				}
			}
			System.out.println("Data is successfully inserted!");
		} catch (Exception err) {
			System.out.println(" " + err.getMessage());
		}
	}

}
