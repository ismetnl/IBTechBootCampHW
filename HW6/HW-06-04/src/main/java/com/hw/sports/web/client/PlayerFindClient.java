package com.hw.sports.web.client;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.hw.core.utils.WebHelper;
import com.hw.core.utils.XmlHelper;
import com.hw.sports.database.entity.Player;
import com.hw.sports.xml.PlayerXml;

public class PlayerFindClient {

	public static void main(String[] args) throws MalformedURLException, IOException, ParserConfigurationException, SAXException {
		long productId = 1;
		String address = String.format("http://localhost:8080/HW-06-04/player/find?id=%d", productId);
		
		InputStream in = WebHelper.get(address);
		
		Document document = XmlHelper.parse(in);
		
		Player player = PlayerXml.parse(document);
		
		System.out.println(player.getPlayerId()+" "
				+player.getPlayerName()+" "
				+player.getAverageScore());
	}
}
