package com.hw.xml;

import static com.hw.xml.XmlUtilities.*;

import org.w3c.dom.*;

public class XmlBuildList {

	public static void main(String[] args) throws Exception {

		String path = "C:\\Users\\ISMETUNLU\\Desktop\\EE\\Exam.xml";
		Document document = parse(path);

		// DOM
		Element exam = document.getDocumentElement();
		String id = getAttribute(exam, "id", "0");
		String title = getSingleElementText(exam, "title", "");
		System.out.println(id + " : " + title);

		NodeList questions = exam.getElementsByTagName("question");
		for (int i = 0; i < questions.getLength(); i++) {

			Element question = (Element) questions.item(i);
			String number = getAttribute(question, "number", "0");
			String text = getSingleElementText(question, "text", "");
			System.out.println(number + ". " + text);
			NodeList options = question.getElementsByTagName("option");
			for (int j = 0; j < options.getLength(); j++) {
				Element option = (Element) options.item(j);
				String code = getAttribute(option, "code", "0");
				String content = option.getTextContent();
				System.out.println("\t" + code + ") " + content);
			}
		}

	}
}
