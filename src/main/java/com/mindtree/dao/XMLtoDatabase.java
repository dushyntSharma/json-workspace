package com.mindtree.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

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
			Document doc = docBuilder.parse(new File("D:/Script Workspace/JSONProject/XmlTodatabse.xml"));

			doc.getDocumentElement().normalize();

			System.out.println("Root element of the doc is " + doc.getDocumentElement().getNodeName());

			NodeList listOfPersons = doc.getElementsByTagName("employee");
			List<String> list = new ArrayList<String>();

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
							"insert into xmldatabase(name,address) values('" + name + "','" + address + "')");
				}

			}
			System.out.println("Data is successfully inserted!");
		} catch (Exception err) {
			System.out.println(" " + err.getMessage());
		}
	}

}
