package com.imc.rps.game;

import java.util.List;
import com.imc.rps.enums.Move;
import static com.imc.rps.enums.Move.*;
import com.imc.rps.enums.GameResult;
import static com.imc.rps.enums.GameResult.*;
import com.imc.rps.players.Player;

/**
 * Represent the game rule for 2 players
 */
public class TwoPlayerGameEngine implements GameEngine{
    private static final int NUMBER_OF_PLAYERS = 2;
    protected GameResult compareMoves(Move player1Move, Move player2Move) {

        if (player1Move == player2Move)
            return DRAW;

        switch (player1Move) {
            case ROCK:
                return player2Move == SCISSORS ? WIN : LOSE;
            case PAPER:
                return player2Move == ROCK ? WIN : LOSE;
            case SCISSORS:
                return player2Move == PAPER ? WIN : LOSE;
        }
        throw new IllegalStateException();
    }

    public Player getWinner(List<Player> players) {
        if (players == null || players.size() != NUMBER_OF_PLAYERS) {
            throw new IllegalArgumentException("You need to have two players to use this gameEngine.");
        }

        Player player1 = players.get(0);
        Player player2 = players.get(1);

        Move player1Move = player1.getMove();
        Move player2Move = player2.getMove();

        System.out.println(player1.getName() + " : " + player1Move);
        System.out.println(player2.getName() + " : " + player2Move);

        GameResult result = compareMoves(player1Move, player2Move);

        switch (result) {
            case WIN:
                return player1;
            case LOSE:
                return player2;
            default:
                return null;
        }
    }
}
