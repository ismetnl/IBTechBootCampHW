package com.hw.sports.web.client;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.hw.core.utils.WebHelper;
import com.hw.core.utils.XmlHelper;
import com.hw.sports.database.entity.Player;
import com.hw.sports.xml.PlayerXml;

public class PlayerListClient {
	public static void main(String[] args) throws MalformedURLException, IOException, ParserConfigurationException, SAXException {
	
		String address = "http://localhost:8080/HW-06-04/player";
		
		InputStream in = WebHelper.get(address);
		
		Document document = XmlHelper.parse(in);
		
		List<Player> players= PlayerXml.parseList(document);
		
		for(Player player:players) {
			System.out.println(player.getPlayerId()+" "
					+player.getPlayerName()+" "
					+player.getAverageScore());
		}
		
		
	}
}
