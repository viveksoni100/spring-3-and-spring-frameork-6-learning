package com.example.learspring.game;

import com.example.learspring.game.GameRunner;
import com.example.learspring.game.MarioGame;
import com.example.learspring.game.PacmanGame;
import com.example.learspring.game.SuperContraGame;

/**
 * iteration-2 provided loose coupling using interfaces
 */

public class App01GamingBasic {


    public static void main(String[] args) {

        var marioGame = new MarioGame();
        var superContraGame = new SuperContraGame();
        var pacmanGame = new PacmanGame();

        var gameRunner = new GameRunner(pacmanGame);
        gameRunner.run();

    }

}
