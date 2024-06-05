package controller;

import java.util.InputMismatchException;
import model.Car;
import model.GameModel;
import view.View;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.Random;

public class Controller {

    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static Controller instance;
    private GameModel gameModel;
    private View view;

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

    public void clear() {
        gameModel = new GameModel();
        view = new View();
    }

    public GameModel getGameModel() {
        return gameModel;
    }

    private void validateCarNameLength(String[] carNames) throws IllegalArgumentException {
        for (String carName : carNames) {
            if (MAX_CAR_NAME_LENGTH < carName.length() || carName.isEmpty()) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateCarNameUniqueness(String[] carNames) throws IllegalStateException {
        HashSet<String> uniqueCarNames = new HashSet<>();
        for (String carName : carNames) {
            if (uniqueCarNames.contains(carName)) {
                throw new IllegalStateException();
            }
            uniqueCarNames.add(carName);
        }
    }

    private void validateCarNameCount(String[] carNames) throws NonCarException {
        if (carNames.length == 0) {
            throw new NonCarException();
        }
    }

    public boolean areCarNamesValid(String[] carNames) {
        boolean isValid = true;
        try {
            validateCarNameLength(carNames);
            validateCarNameUniqueness(carNames);
            validateCarNameCount(carNames);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] : 자동차 이름의 길이는 1 ~ 5 이어야 합니다.\n");
            isValid = false;
        } catch (IllegalStateException e) {
            System.out.println("[ERROR] : 자동차 이름은 중복될 수 없습니다.\n");
            isValid = false;
        }
        return isValid;
    }

    public boolean isRepeatCountValid(String repeatCount) {
        boolean isValid = true;
        try {
            if (Integer.parseInt(repeatCount) < 0) {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] : 정수 형태 입력이 아닙니다.\n");
            isValid = false;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] : 반복 횟수는 음이 아닌 정수이어야 합니다.\n");
            isValid = false;
        } catch (InputMismatchException e) {
            System.out.println("[ERROR] : 반복할 횟수는 정수 타입이어야 합니다.\n");
            isValid = false;
        }
        return isValid;
    }

    public void createCars(String[] carNames) {
        for (String carName : carNames) {
            gameModel.addCar(new Car(carName));
        }
    }

    public void setRepeatCount(int repeatCount) {
        gameModel.setRepeatCount(repeatCount);
    }

    private String[] getCarNames() {
        String[] carNames = view.requestCarNames().split(",");
        if (!areCarNamesValid(carNames)) {
            return getCarNames();
        }
        return carNames;
    }

    private int getRepeatCount() {
        String repeatCount = view.requestRepeatCount();
        if (!isRepeatCountValid(repeatCount)) {
            return getRepeatCount();
        }
        return Integer.parseInt(repeatCount);
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

    public LinkedList<String> getWinners() {
        LinkedList<String> winners = new LinkedList<>();
        for (int i = 0; i < gameModel.getCarsCount(); ++i) {
            if (gameModel.getCar(i).getPos() == getMaxDistance()) {
                winners.add(gameModel.getCar(i).getName());
            }
        }
        return winners;
    }

    public void play() {
        createCars(getCarNames());
        setRepeatCount(getRepeatCount());
        run();
        view.printWinners(getWinners());
    }
}

class NonCarException extends IllegalArgumentException {

    public NonCarException() {
    }

    public NonCarException(String message) {
        super(message);
    }
}