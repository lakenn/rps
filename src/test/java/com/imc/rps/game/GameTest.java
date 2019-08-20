package com.imc.rps.game;

import com.imc.rps.enums.Move;
import com.imc.rps.exxceptions.GameException;
import com.imc.rps.players.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class GameTest {

    private Game twoPlayerGame;

    @Before
    public void setUp() throws Exception {
        twoPlayerGame = new Game(2);
    }

    @Test
    public void testSetNumOfRoundGreaterThanZero() {
        twoPlayerGame.setNumOfRound(1);
        Assert.assertEquals(1, twoPlayerGame.numOfRounds);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetNumOfRoundZero() {
        twoPlayerGame.setNumOfRound(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetNumOfRoundNegative() {
        twoPlayerGame.setNumOfRound(-1);
    }

    @Test
    public void addTwoPlayers() throws Exception {
        Player player1 = Mockito.mock(Player.class);
        Player player2 = Mockito.mock(Player.class);
        twoPlayerGame.addPlayer(player1);
        twoPlayerGame.addPlayer(player2);
        Assert.assertEquals(2, twoPlayerGame.players.size());
        Assert.assertTrue(twoPlayerGame.players.contains(player1));
        Assert.assertTrue(twoPlayerGame.players.contains(player2));
    }

    @Test
    public void addSamePlayerTwice() throws Exception {
        Player player1 = Mockito.mock(Player.class);
        twoPlayerGame.addPlayer(player1);
        twoPlayerGame.addPlayer(player1);
        Assert.assertEquals(1, twoPlayerGame.players.size());
        Assert.assertTrue(twoPlayerGame.players.contains(player1));
    }

    @Test(expected = GameException.class)
    public void addThreePlayers() throws Exception {
        Player player1 = Mockito.mock(Player.class);
        Player player2 = Mockito.mock(Player.class);
        Player player3 = Mockito.mock(Player.class);
        twoPlayerGame.addPlayer(player1);
        twoPlayerGame.addPlayer(player2);
        twoPlayerGame.addPlayer(player3);
    }

    @Test
    public void testPlay() throws Exception {
        Player player1 = Mockito.mock(Player.class);
        Player player2 = Mockito.mock(Player.class);

        TwoPlayerGameEngine engine = Mockito.mock(TwoPlayerGameEngine.class);
        GameResultRecorder recorder = Mockito.mock(GameResultRecorder.class);

        int numOfRounds = 3;
        twoPlayerGame.players.add(player1);
        twoPlayerGame.players.add(player2);
        twoPlayerGame.numOfRounds = numOfRounds;
        twoPlayerGame.gameEngine = engine;
        twoPlayerGame.gameResultRecorder = recorder;

        Mockito.when(engine.getWinner(twoPlayerGame.players)).thenReturn(player1);

        // start play
        twoPlayerGame.play();

        for (int i=1; i<=numOfRounds; i++) {
            Mockito.verify(recorder).record(i, player1);
        }

        Mockito.verify(engine, Mockito.times(numOfRounds)).getWinner(twoPlayerGame.players);
        Mockito.verify(recorder).summarize();
    }

    @Test(expected = GameException.class)
    public void testPlayNoPlayers() throws Exception {
        twoPlayerGame.play();
    }

    @Test(expected = GameException.class)
    public void testNotEnoughPlayers() throws Exception {
        Player player = Mockito.mock(Player.class);
        twoPlayerGame.addPlayer(player);
        twoPlayerGame.play();
    }

}