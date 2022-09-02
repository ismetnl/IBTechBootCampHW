package com.hw.sports.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.w3c.dom.Document;

import com.hw.core.utils.XmlHelper;
import com.hw.sports.database.entity.Player;
import com.hw.sports.database.manager.PlayerManager;
import com.hw.sports.xml.PlayerXml;

/**
 * Servlet implementation class PlayerFindServlet
 */
@WebServlet("/player/find")
public class PlayerFindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			long playerid = Long.parseLong(request.getParameter("id"));
			
			PlayerManager manager = new PlayerManager();
		
			Player player = manager.find(playerid);
			
			Document document = PlayerXml.format(player);
			
			response.setContentType("application/xml; charset=UTF-8");
			
			XmlHelper.dump(document, response.getOutputStream());
			
		} catch (Exception e) {
	
			e.printStackTrace();
		} 
		
		
	}

	


}
