package com.mini.caracing.controller;

import com.mini.caracing.controller.validator.Validator;
import com.mini.caracing.model.GameModel;
import com.mini.caracing.view.GameView;
import java.util.Arrays;
import java.util.List;

public final class GameController {

    private GameModel gameModel;
    private GameView gameView;

    public GameController(GameModel gameModel, GameView gameView) {
        this.gameModel = gameModel;
        this.gameView = gameView;
    }

    public List<String> readCarNames() {
        String carNamesInput;

        while (true) {
            try {
                carNamesInput = gameView.getCarNamesInput();
                Validator.validateCarNames(carNamesInput);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR]" + e.toString());
            }
        }

        return Arrays.asList(carNamesInput.split(","));
    }

    public int readTotalMove() {
        String totalMoveInput;

        while (true) {
            try {
                totalMoveInput = gameView.getTotalMoveInput();
                Validator.validateTotalMove(totalMoveInput);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR]" + e.toString());
            }
        }

        return Integer.parseInt(totalMoveInput);
    }

}
