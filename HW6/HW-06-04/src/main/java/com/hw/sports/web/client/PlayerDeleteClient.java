package com.hw.sports.web.client;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URLConnection;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.hw.core.utils.StreamHelper;
import com.hw.core.utils.WebHelper;
import com.hw.core.utils.XmlHelper;
import com.hw.sports.database.entity.Player;
import com.hw.sports.xml.PlayerXml;

public class PlayerDeleteClient {

	public static void main(String[] args) throws MalformedURLException, IOException, ParserConfigurationException, SAXException, TransformerException {

		long playerId = 4;
		
		String address = "http://localhost:8080/HW-06-04/player/delete";
		Document document = PlayerXml.formatid(playerId);
		URLConnection connection = WebHelper.connect(address);
		
		XmlHelper.dump(document, connection.getOutputStream());
		
		String result = StreamHelper.read(connection.getInputStream());
		
		System.out.println(result);
	}
}
