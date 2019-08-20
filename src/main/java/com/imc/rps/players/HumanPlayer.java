package com.imc.rps.players;

import com.imc.rps.enums.Move;
import static com.imc.rps.enums.Move.*;
import java.util.Scanner;

public class HumanPlayer implements Player {
    private final String name;
    public HumanPlayer(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Move getMove() {
        Scanner sc = new Scanner(System.in);
        String userInput;

        while(true) {
            System.out.println(getName() + " : Enter \"r\" for rock, \"p\" for paper, or \"s\" for scissor:");
            userInput = sc.nextLine().toUpperCase().replace(" ", "");
            if (userInput.isEmpty())
                continue;

            char playerChoice = userInput.charAt(0);

            switch (playerChoice) {
                case 'R':
                    return ROCK;
                case 'P':
                    return PAPER;
                case 'S':
                    return SCISSORS;
                default:
                    System.out.println("Wrong input. Please enter again.");
            }
        }
    }
}
