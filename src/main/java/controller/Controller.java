package controller;

import model.Car;
import model.GameModel;
import view.View;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.Random;

public class Controller {

    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static Controller instance;
    GameModel gameModel;
    View view;

    private Controller() {
        gameModel = new GameModel();
        view = new View();
    }

    static public Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    private boolean areCarNameLengthsValid(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() > MAX_CAR_NAME_LENGTH) {
                return false;
            }
        }
        return true;
    }

    private boolean areCarNamesUnique(String[] carNames) {
        HashSet<String> uniqueCarNames = new HashSet<>();
        for (String carName : carNames) {
            if (uniqueCarNames.contains(carName)) {
                return false;
            }
            uniqueCarNames.add(carName);
        }
        return true;
    }

    private void getCarNames() {
        boolean isAbnormal = false;
        String[] carNames = view.requestCarNames().split(",");
        try {
            if (!areCarNameLengthsValid(carNames)) {
                throw new IllegalArgumentException();
            }
            if (!areCarNamesUnique(carNames)) {
                throw new IllegalStateException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] : 자동차 이름의 길이는 5보다 작거나 같습니다.");
            System.out.println();
            isAbnormal = true;
        } catch (IllegalStateException e) {
            System.out.println("[ERROR] : 자동차의 이름은 중복될 수 없습니다.");
            System.out.println();
            isAbnormal = true;
        }
        if (isAbnormal) {
            getCarNames();
            return;
        }
        for (String carName : carNames) {
            gameModel.addCar(new Car(carName));
        }
    }

    private void getRepeatCount() {
        gameModel.setRepeatCount(view.requestRepeatCount());
    }

    private void runOneCycle() {
        Random random = new Random();
        for (int i = 0; i < gameModel.getCarsCount(); ++i) {
            int randomNumber = random.nextInt(10);
            if (randomNumber >= 4) {
                gameModel.getCar(i).moveForward();
            }
        }
    }

    private void run() {
        view.printResultText();
        for (int i = 0; i < gameModel.getRepeatCount(); ++i) {
            runOneCycle();
            view.printProgress(gameModel);
        }
    }

    private int getMaxDistance() {
        int maxDist = 0;
        for (int i = 0; i < gameModel.getCarsCount(); ++i) {
            if (gameModel.getCar(i).getPos() > maxDist) {
                maxDist = gameModel.getCar(i).getPos();
            }
        }
        return maxDist;
    }

    private LinkedList<String> getWinners() {
        LinkedList<String> winners = new LinkedList<>();
        for (int i = 0; i < gameModel.getCarsCount(); ++i) {
            if (gameModel.getCar(i).getPos() == getMaxDistance()) {
                winners.add(gameModel.getCar(i).getName());
            }
        }
        return winners;
    }

    public void play() {
        getCarNames();
        getRepeatCount();
        run();
        view.printWinners(getWinners());
    }
}
