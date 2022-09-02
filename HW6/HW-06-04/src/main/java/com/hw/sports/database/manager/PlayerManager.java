package com.hw.sports.database.manager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hw.sports.database.entity.Player;

public class PlayerManager extends BaseManager<Player> {

	public PlayerManager() {
		super();
	}

	public Player find(long playerId) throws SQLException {
		Player player = null;

		connect();

		String sql = "select * from player where playerid = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setDouble(1, playerId);
		ResultSet resultSet = statement.executeQuery();

		if (resultSet.next()) {
			player = parse(resultSet);
			return player;
		}

		disconnect();
		return player;

	}

	public List<Player> list() throws Exception {

		List<Player> players = new ArrayList<>();
		connect();

		String sql = "select * from player";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();

		players = parseList(players, resultSet);

		disconnect();

		return players;
	}

	public List<Player> listByAverageScoreGrater(double averageScore) throws Exception {

		List<Player> players = new ArrayList<>();
		connect();

		String sql = "select * from player where averageScore > ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setDouble(1, averageScore);
		ResultSet resultSet = statement.executeQuery();

		players = parseList(players, resultSet);

		disconnect();

		return players;
	}

	public List<Player> listByNameLikeFilter(String nameFilter) throws Exception {

		List<Player> players = new ArrayList<>();
		connect();

		String sql = "select * from player where playerName like ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, "%"+nameFilter+"%");
		ResultSet resultSet = statement.executeQuery();

		players = parseList(players, resultSet);

		disconnect();

		return players;
	}

	protected Player parse(ResultSet resultSet) throws SQLException {

		long playerId = resultSet.getLong("playerId");
		String playerName = resultSet.getString("playerName");
		double averageScore = resultSet.getDouble("averageScore");

		Player player = new Player(playerId, playerName, averageScore);

		return player;
	}

	protected List<Player> parseList(List<Player> players, ResultSet resultSet) throws SQLException {

		while (resultSet.next()) {

			Player player = parse(resultSet);
			players.add(player);
		}
		return players;

	}

	public boolean delete(long playerId) throws Exception {

		connect();

		String sql = "delete from player where playerId=?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setLong(1, playerId);
		int affected = statement.executeUpdate();

		disconnect();

		System.out.println("Etkilenmiş " + affected);

		return affected > 0;
	}

	public boolean update(Player player) throws Exception {

		connect();

		String sql = "update player set playerName=?, averageScore=? where playerId=?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, player.getPlayerName());
		statement.setDouble(2, player.getAverageScore());
		statement.setLong(3, player.getPlayerId());
		int affected = statement.executeUpdate();

		connection.close();

		System.out.println("Etkilenmiş " + affected);
		
		return affected > 0;
	}

	public boolean insert(Player player) throws Exception {

		connect();

		String sql = "insert into player(playerName,averageScore) values(?,?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, player.getPlayerName());
		statement.setDouble(2, player.getAverageScore());
		int affected = statement.executeUpdate();

		connection.close();

		System.out.println("Etkilenmiş " + affected);
		
		return affected > 0;
	}

}
