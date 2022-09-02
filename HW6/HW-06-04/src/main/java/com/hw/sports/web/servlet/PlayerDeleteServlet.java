package com.hw.sports.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.w3c.dom.Document;

import com.hw.core.utils.StreamHelper;
import com.hw.core.utils.XmlHelper;
import com.hw.sports.database.entity.Player;
import com.hw.sports.database.manager.PlayerManager;
import com.hw.sports.xml.PlayerXml;

/**
 * Servlet implementation class PlayerFindServlet
 */
@WebServlet("/player/delete")
public class PlayerDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			
			PlayerManager playerManager = new PlayerManager();
			
			Document document = XmlHelper.parse(request.getInputStream());
			
			long playerid = PlayerXml.parseid(document);
		
			boolean deleted = playerManager.delete(playerid);
			
			String result = deleted
					?"Silindi"
					:"Silinemedi";
			StreamHelper.write(response.getOutputStream(), result);
			
		} catch (Exception e) {
	
			e.printStackTrace();
		} 
		
		
	}

	


}
