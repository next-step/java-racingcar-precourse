package com.mini.caracing;

import com.mini.caracing.controller.GameController;
import com.mini.caracing.model.GameModel;
import com.mini.caracing.view.GameView;

public class Application {
    public static void main(String[] args) {
        GameModel gameModel = new GameModel();
        GameView gameView = new GameView();
        GameController gameController = new GameController(gameModel, gameView);

        gameController.play();
    }
}
