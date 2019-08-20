package com.imc.rps.players;

import com.imc.rps.enums.Move;
import static com.imc.rps.enums.Move.*;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Could further break it down as ComputerPlayer Interface potentially
 * And class implementating it with different game strategy
 */
public class ComputerPlayer implements Player {
    private final List<Move> moves = Arrays.asList(PAPER, ROCK, SCISSORS);
    private final Random randomGenerator = new Random();
    private final String name;

    public ComputerPlayer(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Move getMove() {
        return moves.get(randomGenerator.nextInt(moves.size()));
    }
}
