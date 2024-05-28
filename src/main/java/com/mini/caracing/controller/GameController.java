package com.mini.caracing.controller;

import com.mini.caracing.model.GameModel;
import com.mini.caracing.view.GameView;

public class GameController {
    private GameModel gameModel;
    private GameView gameView;

    public GameController(GameModel gameModel, GameView gameView) {
        this.gameModel = gameModel;
        this.gameView = gameView;
    }
}
