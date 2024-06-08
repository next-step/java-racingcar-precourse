package controller;

import service.RacingGame;
import util.RacingGameFactory;
import view.UserInterface;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Controller {
    private UserInterface userInterface = new UserInterface();
    private RacingGameFactory racingGameFactory = new RacingGameFactory();
    private RacingGame racingGame;

    public int playGame() {
        userInterface.explain();

        if (prepareGame() != 0) {
            return errorTerminationInformation();
        }

        racingGame = racingGameFactory.getRacingGame();
        playRound();
        checkTheWinnerCar();
        return 0;
    }

    private int prepareGame() {
        if (prepareRacingCar() != 0 || prepareRoundOfNum() != 0) {
            return -1;
        }

        try {
            racingGame = racingGameFactory.getRacingGame();
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            return -1;
        }
        return 0;
    }

    private int prepareRacingCar() {
        int numberOfAttempts = 0;
        while (numberOfAttempts < 3) {
            String carNameInput = userInterface.enterCarName();
            int result = executeWithErrorHandling(() -> racingGameFactory.prepareRacingCar(carNameInput));
            if (result == 0) {
                break;
            }
            numberOfAttempts ++;
            System.out.println("잘못된 입력입니다. 다시 시도해 주세요. 기회는 " + (3 - numberOfAttempts) + "번 남았습니다.");
        }

        if (numberOfAttempts == 4){
            return -1;
        }
        return 0;
    }

    private int prepareRoundOfNum() {
        int numberOfAttempts = 0;
        while (numberOfAttempts < 3) {
            String roundInput = userInterface.enterNumberOfRounds();
            int result = executeWithErrorHandling(() -> racingGameFactory.prepareRound(roundInput));
            if (result == 0) {
                break;
            }
            numberOfAttempts ++;
            System.out.println("잘못된 입력입니다. 다시 시도해 주세요. 기회는 " + (3 - numberOfAttempts) + "번 남았습니다.");

        }

        if (numberOfAttempts == 4){
            return -1;
        }

        return 0;
    }

    private int executeWithErrorHandling(Runnable operation) {
        try {
            operation.run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return -1;
        }
        return 0;
    }

    public int playRound() {
        int round = racingGame.getRound();
        for (int i = 1; i <= round; i++) {
            LinkedHashMap<String, Integer> carList = racingGame.palyRouound();
            userInterface.printRoundResults(i, carList);
        }
        return 0;
    }

    public int checkTheWinnerCar() {
        LinkedHashMap<String, Integer> winnerCarMap = racingGame.calculateWinner();

        List<String> winnerCarList = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : winnerCarMap.entrySet()) {
            winnerCarList.add(entry.getKey());
        }

        userInterface.printWinners(winnerCarList);
        return 0;
    }

    private int errorTerminationInformation() {
        System.out.println("ㅜㅜ 게임을 종료할게요..!");
        return -1;
    }
}
