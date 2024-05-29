package race.controller;

import race.exception.LengthLimitException;
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
    private final Scanner scanner;
    private Race race;
    private int tryCount;

    public RaceController() {
        this.inputView = InputView.getInstance();
        this.outputView = OutputView.getInstance();
        this.scanner = new Scanner(System.in);
    }

    public void startRace() {
        boolean isInputValid = false;
        do {
            try {
                initializeRace();
                isInputValid = true;
            }
            catch (LengthLimitException e) {
                outputView.outputPromptForErrorMessage(e.getMessage());
            }
        } while (!isInputValid);

        isInputValid = false;

        do {
            try {
                inputForTryCount();
                isInputValid = true;
            }
            catch (InputMismatchException e) {
                outputView.outputPromptForErrorMessage("[ERROR] 입력한 형식이 잘못 되었습니다. 숫자를 넣어주세요");
            }
        } while (!isInputValid);

        proceedStep();
        endRace();
    }

    private List<Car> inputForCarNameList() {
        List<String> carNameList = splitStringByComma(scanner.nextLine());

        return carNameList.stream()
                .map(Car::new)
                .toList();
    }

    private void inputForTryCount() {
        inputView.inputPromptForTryCount();
        this.tryCount = scanner.nextInt();
    }

    private List<String> splitStringByComma(String string) {
        return Arrays.asList(string.split("\\s*,\\s*"));
    }

    private void initializeRace() {
        inputView.inputPromptForCarName();
        this.race = new Race(inputForCarNameList(), CustomRandom.getInstance());
    }

    private void proceedStep() {
        for (int i = 0; i < tryCount; ++i)
            outputView.outputPromptForCarList(race.proceedStep());
    }

    private void endRace() {
        outputView.outputPromptForWinnerList(race.getWinnerList());
    }
}
