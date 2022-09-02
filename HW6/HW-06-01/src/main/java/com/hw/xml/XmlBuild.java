package com.hw.xml;

import org.w3c.dom.*;

import static com.hw.xml.XmlUtilities.*;

public class XmlBuild {
	public static void main(String[] args) throws Exception {

		String path = "..\\..\\Student.xml";

		Document document = parse(path);
		Element student = document.getDocumentElement();
		
		long id = getAttribute(student, "id", 0);
		String name = getSingleElementText(student, "name", "");
		double mark = getSingleElementText(student, "mark", 0);
		
		System.out.println(id+" "+name+" "+mark);
	}
}
