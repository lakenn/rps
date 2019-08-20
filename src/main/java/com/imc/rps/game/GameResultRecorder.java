package com.imc.rps.game;

import com.imc.rps.players.Player;
import java.util.HashMap;
import java.util.Map;

/**
 * The class is responsible for keeping the winning records of the players
 */

public class GameResultRecorder {
    private Map<Player, Integer> winRecord = new HashMap<>();

    public void record(int round, Player winner) {
        if (winner == null) {
            System.out.println("Round " + round + " was a draw.");
        } else {
            System.out.println("Round " + round + " was won by "
                    + winner.getName());
            if (winRecord.containsKey(winner)) {
                winRecord.put(winner, winRecord.get(winner) + 1);
            } else {
                winRecord.put(winner, 1);
            }
        }
    }

    public void summarize() {
        for (Map.Entry<Player, Integer> e : winRecord.entrySet()) {
            System.out.println(e.getKey().getName() + " won " + e.getValue() + " times");
        }
    }
}
