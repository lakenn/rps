package com.imc.rps.game;

import java.util.ArrayList;
import java.util.List;
import com.imc.rps.exxceptions.GameException;
import com.imc.rps.players.Player;

/**
 * This class is responsible for controlling the flow of the game
 * multiplayers awareness
 */
public class Game {
    protected final int max_players;
    protected List<Player> players;
    protected int numOfRounds;
    protected GameEngine gameEngine;
    protected GameResultRecorder gameResultRecorder;

    public Game(int max_players) {
        this.max_players = max_players;
        this.players = new ArrayList<>(max_players);
    }

    public void addPlayer(Player player) throws GameException {
        if (player == null) {
            throw new IllegalArgumentException();
        }
        if (players.size() == max_players) {
            throw new GameException("Reached max number of players");
        }

        if (!players.contains(player)) {
            players.add(player);
        }
    }

    public void setNumOfRound(int numberOfRounds) {
        if (numberOfRounds < 1) {
            throw new IllegalArgumentException("Number of rounds cannot be < 1");
        }

        this.numOfRounds = numberOfRounds;
    }

    public void setGameEngine(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }

    public void setGameResultRecorder(GameResultRecorder gameResultRecorder) {
        this.gameResultRecorder = gameResultRecorder;
    }

    public void play() throws GameException {
        if (players.size() < max_players) {
            throw new GameException("Not enough players registered to play");
        }

        int round = 1;
        while (round <= numOfRounds) {
            System.out.println("\nRound " + round + ":");
            Player winner = gameEngine.getWinner(players);
            gameResultRecorder.record(round, winner);
            round++;
        }

        System.out.println("\n===== Game End ======");
        gameResultRecorder.summarize();
    }
}
