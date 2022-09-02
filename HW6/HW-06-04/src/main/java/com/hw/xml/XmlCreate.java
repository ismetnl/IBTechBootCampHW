package com.hw.xml;

import static com.hw.xml.XmlUtilities.*;

import org.w3c.dom.*;

public class XmlCreate {
	public static void main(String[] args) throws Exception {

		Document document = create("employee");
		Element employee = document.getDocumentElement();
		employee.setAttribute("id", "401");

		addSingleElementText(document, employee, "name", "Neşet Ertaş");
		addSingleElementText(document, employee, "salary", 9875);

		long id = getAttribute(employee, "id", 0);
		String name = getSingleElementText(employee, "name", "");
		double salary = getSingleElementText(employee, "salary", 0);

		System.out.println(id + " " + name + " " + salary);

		String path = "C:\\Users\\ISMETUNLU\\Desktop\\EE\\Dump.xml";

		dump(document, path);

	}
}
