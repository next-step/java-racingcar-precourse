package com.github.momentjin;

import com.github.momentjin.ui.GameWinnerPrinter;
import com.github.momentjin.ui.MovableObjectStatusPrinter;
import com.github.momentjin.ui.RacingCarNameInput;
import com.github.momentjin.ui.RacingCountInput;
import com.github.momentjin.ui.application.MovableObjectStatusService;
import com.github.momentjin.ui.application.RacingCarNamesConvertService;

import java.util.Scanner;

public class RacingCarGameApplication {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        RacingCarNamesConvertService carNamesConvertService = new RacingCarNamesConvertService();
        RacingCarNameInput racingCarNameInput = new RacingCarNameInput(carNamesConvertService);

        RacingCountInput racingCountInput = new RacingCountInput();
        GameWinnerPrinter gameWinnerPrinter = new GameWinnerPrinter();

        MovableObjectStatusService movableObjectStatusService = new MovableObjectStatusService();
        MovableObjectStatusPrinter movableObjectStatusPrinter = new MovableObjectStatusPrinter(movableObjectStatusService);

        RacingCarGame game = new RacingCarGame(
                scanner,
                racingCountInput,
                racingCarNameInput,
                gameWinnerPrinter,
                movableObjectStatusPrinter
        );

        game.execute();
    }
}
