package com.freeefly;

import com.freeefly.executor.RacingExecutor;
import com.freeefly.model.RacingGame;
import com.freeefly.validator.CarNameValidator;
import com.freeefly.validator.ProceedCountValidator;

public class Main {
    public static void main(String[] args) {
        RacingExecutor executor = new RacingExecutor();
        CarNameValidator carNameValidator = new CarNameValidator();
        ProceedCountValidator proceedCountValidator = new ProceedCountValidator();
        RacingGame game = new RacingGame(executor, carNameValidator, proceedCountValidator);
        game.inputCarNames();
        game.inputProceedCount();
        game.playGame();
        game.openResult();
    }
}
