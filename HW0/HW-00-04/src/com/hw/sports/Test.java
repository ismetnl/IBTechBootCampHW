package com.hw.sports;

import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
		
		////League 1
		League league = new League(601,"Süperlig");
		league.setTeamList(new ArrayList<>());
		
		//Team A
		Team teamA = new Team(801,"Godoro Spor");
		teamA.setPlayerList(new ArrayList<>());
		
		
		Player player1A = new Player(401, "Teoman Alpay", 4.67);
		player1A.setTeam(teamA);
		teamA.getPlayerList().add(player1A);
		
		Player player2A = new Player(402, "Yusuf Nalkesen", 7.89);
		player2A.setTeam(teamA);
		teamA.getPlayerList().add(player2A);
		
		Player player3A = new Player(404, "Avni Anıl", 6.61);
		player3A.setTeam(teamA);
		teamA.getPlayerList().add(player3A);
		
		
		//Team B
		Team teamB = new Team(802,"Fibiler Spor");
		teamB.setPlayerList(new ArrayList<>());
		
		
		Player player1B = new Player(403, "Yıldırım Gürses", 2.93);
		player1B.setTeam(teamB);
		teamB.getPlayerList().add(player1B);
		
		Player player2B = new Player(405, "Erdoğan Berker", 8.11);
		player2B.setTeam(teamB);
		teamB.getPlayerList().add(player2B);
	
		
		
		league.getTeamList().add(teamA);
		league.getTeamList().add(teamB);
		
		
		System.out.println(league.getLeagueId()+" "+league.getLeagueName());
		for(Team team: league.getTeamList()) {
			System.out.println("\t"+team.getTeamId()+" "+team.getTeamName());
			for(Player player: team.getPlayerList()) {
				System.out.println("\t\t"+player.getPlayerId()+" "
						+player.getPlayerName()+ " "
						+player.getAverageScore());
			}
		}
	}
}
