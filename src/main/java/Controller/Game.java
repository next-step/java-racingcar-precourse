package Controller;

import Model.Car;
import Model.Player;
import Model.Winner;
import Model.WinnerNumber;

import Util.CheckNameValidity;
import Util.CheckNumberValidity;
import Util.MakeRandomNumber;
import Util.MoveOrNot;

import VIew.InputView;
import VIew.OutputView;

import java.io.IOException;
import java.util.StringTokenizer;

public class Game {

    private Car[] cars;
    private String[] beforeCheckCarNames;
    private StringTokenizer carNames;
    private Player player;
    private Winner winner;
    private WinnerNumber winnerNumber;

    private void separateName(String name) {
        beforeCheckCarNames = name.split(",");
    }

    private boolean makeCars()throws IOException {
        cars = new Car[beforeCheckCarNames.length];
        for (int i = 0; i < cars.length; i++) {
            if (!CheckNameValidity.checkNameValidity(beforeCheckCarNames[i])) {
                return false;
            }
            cars[i] = new Car(beforeCheckCarNames[i], "", 0);
        }
        return true;
    }

    private void makeCorrectCars() throws IOException {
        do {
            OutputView.outputInputCarNameMessage();
            String names = InputView.inputName();
            separateName(names);
        } while (!makeCars());
    }

    private void makeCorrectPlayer() throws IOException {
        OutputView.outputLine("시도할 회수는 몇회인가요?");
        String numberOfAttempts;
        while (!CheckNumberValidity.checkNumberValidity(numberOfAttempts = InputView.inputNumberOfAttempts())) {
            OutputView.outputLine("다시~~~");
        }
        player = new Player(Integer.parseInt(numberOfAttempts));
    }

    private void allCarMoveOrNot() {
        for (Car car : cars) {
            int randomNumber = MakeRandomNumber.makeRandomNumber();
            MoveOrNot.checkMoveOrNot(randomNumber, car);
        }
    }

    private void printAllCarNowStatus()throws IOException{
        for(Car car : cars){
            OutputView.outputLine(car.getNowStatus());
        }
        OutputView.outputLine("");
    }

    private void findWinnerNumber() {
        winner = new Winner();
        int maxMoveStatus = 0;
        for (Car car : cars) {
            maxMoveStatus = Math.max(maxMoveStatus, car.getMoveCount());
        }
        winnerNumber = new WinnerNumber(maxMoveStatus);
    }

    private void addAllWinner() {
        for (Car car : cars) {
            if (winnerNumber.getWinnerNumber() == car.getMoveCount()) {
                winner.addWinner(car.getName());
            }
        }
    }

    private void makeAndPrintWinner() throws IOException {
        findWinnerNumber();
        addAllWinner();
        OutputView.outputGameWinner(winner.getWinner());
    }

    public void totalGame() throws IOException {
        makeCorrectCars();
        makeCorrectPlayer();
        OutputView.outputGameResultMessage();
        for (int i = 0; i < player.getTryNumber(); i++) {
            allCarMoveOrNot();
            printAllCarNowStatus();
        }
        makeAndPrintWinner();
    }
}
