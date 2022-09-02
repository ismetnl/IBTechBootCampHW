package com.hw.xml;

import org.w3c.dom.*;

import static com.hw.xml.XmlUtilities.*;


public class XmlDump {
	public static void main(String[] args) throws Exception {

		String path = "..\\..\\Generated.xml";

		Document document = create("student");
		Element student = document.getDocumentElement();
		student.setAttribute("id", "601");

		addSingleElementText(document, student, "name", "Yıldırım Gürses");
		addSingleElementText(document, student, "mark", 2.7);

		long id = getAttribute(student, "id", 0);
		String name = getSingleElementText(student, "name", "");
		double mark = getSingleElementText(student, "mark", 0);

		System.out.println(id + " " + name + " " + mark);

		dump(document, path);
	}
}
