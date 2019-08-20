package com.imc.rps;

import com.imc.rps.exxceptions.GameException;
import com.imc.rps.game.GameEngine;
import com.imc.rps.game.GameResultRecorder;
import com.imc.rps.game.Game;
import com.imc.rps.game.TwoPlayerGameEngine;
import com.imc.rps.players.ComputerPlayer;
import com.imc.rps.players.HumanPlayer;
import com.imc.rps.players.Player;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws GameException {

        System.out.println("=== Paper, Scisssors, Rock ===");
        System.out.println("Welcome ! How many rounds do you want to play ?");

        Scanner sc = new Scanner(System.in);
        int numOfRounds = 0;

        while(true) {
            if(!sc.hasNextInt()){
                System.out.println("Please enter a valid integer number");
                if(sc.hasNext())
                    sc.nextLine();
                continue;
            }
            numOfRounds = sc.nextInt();
            sc.nextLine();

            if (numOfRounds > 0)
                break;

            System.out.println("Please enter a number > 0");
        }

        GameEngine gameEngine = new TwoPlayerGameEngine();
        Game twoPlayerGame = new Game(2);
        twoPlayerGame.setGameEngine(gameEngine);
        twoPlayerGame.setGameResultRecorder(new GameResultRecorder());

        Player player1 = new HumanPlayer("Player1");
        Player player2 = new ComputerPlayer("Computer");
        twoPlayerGame.addPlayer(player1);
        twoPlayerGame.addPlayer(player2);
        twoPlayerGame.setNumOfRound(numOfRounds);

        System.out.println("Game Started");
        twoPlayerGame.play();
    }
}
