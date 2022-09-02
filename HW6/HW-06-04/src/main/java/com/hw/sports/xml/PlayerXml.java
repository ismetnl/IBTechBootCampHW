package com.hw.sports.xml;

import static com.hw.xml.XmlUtilities.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import com.hw.sports.database.entity.Player;

public class PlayerXml {

	public static Document format(Player player)
			throws ParserConfigurationException, SAXException, IOException, TransformerException {

		Document document = create("player");
		Element playerElement = document.getDocumentElement();
		playerElement.setAttribute("id", String.valueOf(player.getPlayerId()));

		addSingleElementText(document, playerElement, "name", player.getPlayerName());
		addSingleElementText(document, playerElement, "averageScore", player.getAverageScore());

		return document;
	}
	
	public static Document formatid(long playerId)
			throws ParserConfigurationException, SAXException, IOException, TransformerException {

		Document document = create("player");
		Element playerElement = document.getDocumentElement();
		playerElement.setAttribute("id", String.valueOf(playerId));

		return document;
	}

	public static Document format(List<Player> players) throws ParserConfigurationException {
		Document document = create("players");
		Element playerList = document.getDocumentElement();

		for (Player player : players) {
			Element playerElement = document.createElement("player");
			playerElement.setAttribute("id", String.valueOf(player.getPlayerId()));
			addSingleElementText(document, playerElement, "name", player.getPlayerName());
			addSingleElementText(document, playerElement, "averageScore", player.getAverageScore());
			playerList.appendChild(playerElement);
		}

		return document;

	}
	
	

	public static Player parse(Document document) throws ParserConfigurationException, SAXException, IOException {

		Element playerElement = document.getDocumentElement();
		long id = getAttribute(playerElement, "id", 0);
		String name = getSingleElementText(playerElement, "name", "");
		double averageScore = getSingleElementText(playerElement, "averageScore", 0);

		Player player = new Player(id, name, averageScore);

		return player;
	}
	
	public static long parseid(Document document) throws ParserConfigurationException, SAXException, IOException {

		Element playerElement = document.getDocumentElement();
		long id = getAttribute(playerElement, "id", 0);
		return id;
	}


	public static List<Player> parseList(Document document) throws ParserConfigurationException, SAXException, IOException {
		
		Element playerListElement = document.getDocumentElement();
		
		List<Player> playerList = new ArrayList<>(); 
		
		NodeList playersElement = playerListElement.getElementsByTagName("player");
		
		for(int i = 0; i < playersElement.getLength(); i++) {
			
			Element playerElement = (Element)playersElement.item(i);
			long playerId = getAttribute(playerElement, "id", 0);
			String playername = getSingleElementText(playerElement, "name", "");
			double averageScore = getSingleElementText(playerElement, "averageScore", 0);
			
			Player player = new Player(playerId,playername,averageScore);
			
			playerList.add(player);
		}
		
		return playerList;
		
	}

}
