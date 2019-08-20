package com.imc.rps.game;

import com.imc.rps.enums.GameResult;
import com.imc.rps.enums.Move;
import com.imc.rps.players.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TwoPlayerGameEngineTest {

    private TwoPlayerGameEngine gameEngine;

    @Before
    public void setUp(){
        gameEngine = new TwoPlayerGameEngine();
    }

    @Test
    public void testBeatsRock(){
        Assert.assertEquals(GameResult.WIN, gameEngine.compareMoves(Move.PAPER, Move.ROCK));
    }

    @Test
    public void testBeatsPaper(){
        Assert.assertEquals(GameResult.WIN, gameEngine.compareMoves(Move.SCISSORS, Move.PAPER));
    }

    @Test
    public void testBeatsScissors(){
        Assert.assertEquals(GameResult.WIN, gameEngine.compareMoves(Move.SCISSORS, Move.PAPER));
    }


    @Test
    public void testGetWinner() {
        List<Player> players = new ArrayList<>();
        Player player1 = Mockito.mock(Player.class);
        Player player2 = Mockito.mock(Player.class);
        players.add(player1);
        players.add(player2);

        Mockito.when(player1.getMove()).thenReturn(Move.ROCK);
        Mockito.when(player2.getMove()).thenReturn(Move.PAPER);

        Assert.assertEquals(player2, gameEngine.getWinner(players));
        Mockito.verify(player1).getMove();
        Mockito.verify(player2).getMove();

    }

    @Test
    public void testDraw() {
        List<Player> players = new ArrayList<>();
        Player player1 = Mockito.mock(Player.class);
        Player player2 = Mockito.mock(Player.class);
        players.add(player1);
        players.add(player2);

        Mockito.when(player1.getMove()).thenReturn(Move.ROCK);
        Mockito.when(player2.getMove()).thenReturn(Move.ROCK);

        Assert.assertNull(gameEngine.getWinner(players));
    }
}