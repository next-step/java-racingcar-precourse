package race.controller;

import race.exception.LengthLimitException;
import race.handler.InputHandler;
import race.model.Car;
import race.model.CustomRandom;
import race.model.Race;
import race.view.InputView;
import race.view.OutputView;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class RaceController {
    private final InputView inputView;
    private final OutputView outputView;
    private final InputHandler inputHandler;
    private final Scanner scanner;
    private Race race;
    private int tryCount;

    public RaceController() {
        this.inputView = InputView.getInstance();
        this.outputView = OutputView.getInstance();
        this.inputHandler = InputHandler.getInstance();
        this.scanner = new Scanner(System.in);
    }

    public void startRace() {
        initializeRace();
        initializeTryCount();
        proceedStep();
        endRace();
    }

    private void initializeRace() {
        boolean isInputValid = false;
        do {
            try {
                inputForRace();
                isInputValid = true;
            }
            catch (LengthLimitException e) {
                outputView.outputPromptForErrorMessage(e.getMessage());
            }
        } while (!isInputValid);
    }

    private void initializeTryCount() {
        boolean isInputValid = false;

        do {
            try {
                inputForTryCount();
                isInputValid = true;
            }
            catch (InputMismatchException e) {
                outputView.outputPromptForErrorMessage("[ERROR] 입력한 형식이 잘못 되었습니다. 숫자를 넣어주세요");
            }
        } while (!isInputValid);
    }

    private void inputForTryCount() {
        inputView.inputPromptForTryCount();
        this.tryCount = scanner.nextInt();
    }

    private void inputForRace() {
        inputView.inputPromptForCarName();
        this.race = new Race(inputHandler.inputForCarNameList(scanner.nextLine()), new CustomRandom());
    }

    private void proceedStep() {
        for (int i = 0; i < tryCount; ++i)
            outputView.outputPromptForCarList(race.proceedStep());
    }

    private void endRace() {
        outputView.outputPromptForWinnerList(race.getWinnerList());
    }
}
