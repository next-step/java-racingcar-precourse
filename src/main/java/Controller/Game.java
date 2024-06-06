package Controller;

import Model.Car;
import Model.Player;
import Model.Winner;
import Model.WinnerNumber;

import Util.NameValidity;
import Util.NumberValidity;
import Util.RandomNumber;
import Util.CarMovement;

import VIew.InputView;
import VIew.OutputView;

import java.io.IOException;

public class Game {

    private Car[] cars;
    private String[] beforeCheckCarNames;
    private Player player;
    private Winner winner;
    private WinnerNumber winnerNumber;

    public void setCars(Car[] cars){
        this.cars = cars;
    }

    public String[] getBeforeCheckCarNames() {
        return beforeCheckCarNames;
    }

    public Winner getWinner() {
        return winner;
    }

    // 입력받은 이름들 분리하여 배열에 저장
    public void separateName(String name) {
        beforeCheckCarNames = name.split(",");
    }

    // beforeCheckCarNames 에 있는 자동차들을 객체로 생성 => 올바르지 않은 값이 있다면 false 리턴
    public boolean makeCars() throws IOException {
        cars = new Car[beforeCheckCarNames.length];
        for (int i = 0; i < cars.length; i++) {
            if (!NameValidity.checkNameValidity(beforeCheckCarNames[i])) {
                return false;
            }
            cars[i] = new Car(beforeCheckCarNames[i], "", 0);
        }
        return isCarsOverOne(); // 한대만있으면 경주 불가이므로 한대라면 F / 2대 이상이면 T
    }

    // 한대일 경우 에러 발생
    private void makeErrorIsCarsOne() {
        if (cars.length == 1) {
            NameValidity.resetSameNameHashMap();
            throw new IllegalStateException("[Error] 자동차 1대로는 경주를 진행할 수 없습니다.");
        }
    }

    // 두대 이상인지 리턴하는 메소드
    private boolean isCarsOverOne() throws IOException {
        try {
            makeErrorIsCarsOne();
            return true;
        } catch (IllegalStateException illegalStateException) {
            OutputView.outputLine(("[Error] 자동차 1대로는 경주를 진행할 수 없습니다. 다시 입력 해주세요"));
            return false;
        }
    }

    // 올바르게 입력을 받는 메소드
    private void makeCorrectCars() throws IOException {
        do {
            beforeCheckCarNames = null;
            OutputView.outputInputCarNameMessage();
            String names = InputView.inputName();
            if(NameValidity.checkNamesValidity(names)){
                separateName(names);
            }
        } while (beforeCheckCarNames == null || !makeCars());
    }

    // 올바른 횟수를 입력 받는 메소드
    private void makeCorrectPlayer() throws IOException {
        OutputView.outputLine("시도할 회수는 몇회인가요?");
        String numberOfAttempts;
        while (!NumberValidity.checkNumberValidity(
            numberOfAttempts = InputView.inputNumberOfAttempts())) {
            OutputView.outputLine("시도할 회수는 몇회인가요?");
        }
        player = new Player(Integer.parseInt(numberOfAttempts));
    }

    // 모든 자동차들에 대해서 전지할지 정지할지 정하는 메소드
    private void decideAllCarMoveOrNot() {
        for (Car car : cars) {
            int randomNumber = RandomNumber.makeRandomNumber();
            CarMovement.checkMoveOrNot(randomNumber, car);
        }
    }

    // 모든 자동차들의 현재 전진상황을 출력하는 메소드
    private void printAllCarNowStatus() throws IOException {
        for (Car car : cars) {
            OutputView.outputLine(car.getNowStatus());
        }
        OutputView.outputLine("");
    }

    // 모든 자동차들을 검사해 가장 많이 전진한 자동차를 찾아 winnerNumber 에 저장
    private void findWinnerNumber() {
        winner = new Winner();
        int maxMoveStatus = 0;
        for (Car car : cars) {
            maxMoveStatus = Math.max(maxMoveStatus, car.getMoveCount());
        }
        winnerNumber = new WinnerNumber(maxMoveStatus);
    }

    // 모든 우승자들을 더함
    private void addAllWinner() {
        for (Car car : cars) {
            if (winnerNumber.getWinnerNumber() == car.getMoveCount()) {
                winner.addWinner(car.getName());
            }
        }
    }

    // 우승자들을 더한후 우승자를 출력
    public void makeAndPrintWinner() throws IOException {
        findWinnerNumber();
        addAllWinner();
        OutputView.outputGameWinner(winner.getWinner());
    }

    // 종합적인 게임
    public void startGame() throws IOException {
        makeCorrectCars();
        makeCorrectPlayer();
        OutputView.outputGameResultMessage();
        for (int i = 0; i < player.getTryNumber(); i++) {
            decideAllCarMoveOrNot();
            printAllCarNowStatus();
        }
        makeAndPrintWinner();
    }
}
