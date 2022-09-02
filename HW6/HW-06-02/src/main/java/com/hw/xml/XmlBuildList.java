package com.hw.xml;

import org.w3c.dom.*;

import static com.hw.xml.XmlUtilities.*;

public class XmlBuildList {
	public static void main(String[] args) throws Exception {

		String path = "..\\..\\Students.xml";

		Document document = parse(path);
		Element students = document.getDocumentElement();

		NodeList studentList = students.getElementsByTagName("student");
		for (int i = 0; i < studentList.getLength(); i++) {
			Element student = (Element) studentList.item(i);
			long id = getAttribute(student, "id", 0);
			String name = getSingleElementText(student, "name", "");
			double mark = getSingleElementText(student, "mark", 0);

			System.out.println(id + " " + name + " " + mark);
		}

	}
}
