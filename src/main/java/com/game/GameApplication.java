package com.game;

import com.game.global.Game;
import com.game.racingCar.RacingCarGame;

public class GameApplication {

    private Game game;


    public GameApplication(Game game) {
        this.game = game;
    }


    public static void main(String[] args) {
        GameApplication gameApplication = new GameApplication(new RacingCarGame());
        gameApplication.run();
    }

    public void run() {
        try {
            game.prepare();
            game.play();
            game.result();
        } catch (RuntimeException re) {
            System.out.println(re.getMessage() + "\n");
            this.run();
        }
    }

}
