package com.imc.rps.game;

import java.util.List;
import com.imc.rps.players.Player;

/**
 * GameEngine -- interface for different game engine rules
 * Implement this interface to define the winning rule of the game (eg. more than 3 symbols)
 * with the capability of multiplayers
 * The game engine will be used by Game class
 */
public interface GameEngine {
    Player getWinner(List<Player> players);
}
