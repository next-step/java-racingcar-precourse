package controller;

import service.RacingGame;
import util.GameServiceFactory;
import util.RacingGameUtil;
import view.UserInterface;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Controller {
    private UserInterface userInterface = new UserInterface();
    private GameServiceFactory gameServiceFactory = new GameServiceFactory();
    private RacingGame racingGame;


    public int playGame(){
        userInterface.explain();

        if (prepareRacingCar() != 0 || prepareRoundOfNum() != 0) {
            return errorTerminationInformation();
        }

        racingGame = gameServiceFactory.getRacingGame();
        playRound();
        checkTheWinnerCar();
        return 0;
    }



    private int prepareRacingCar() {
        String carNameInput = userInterface.enterCarName();
        return executeWithErrorHandling(() -> gameServiceFactory.prepareRacingCar(carNameInput));
    }

    private int prepareRoundOfNum() {
        String roundInput = userInterface.enterNumberOfRounds();
        return executeWithErrorHandling(() -> gameServiceFactory.prepareRound(roundInput));
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
        for (int i = 1; i <= round; i++){
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
