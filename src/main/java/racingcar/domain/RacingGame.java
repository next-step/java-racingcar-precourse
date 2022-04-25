package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.ConstantMessage;
import racingcar.constant.ConstantNumber;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    Cars cars;

    public Cars play(String input) {
        try {
            CarValidation.validateCarName(input);
            splitCar(input);
        } catch (Exception e) {
            printErrorMessage(e);
        }
        return cars;
    }

    private void printErrorMessage(Exception e) {
        e.printStackTrace();
        System.out.println(e.getMessage());
        restartGame();
    }

    private void restartGame() {
        play(Console.readLine());
    }

    public Cars attemptRacingCar(Cars cars, int attempt) {
        for (int i = 0; i < attempt; i++) {
            moveCars(cars);
        }
        return cars;
    }

    private void moveCars(Cars cars) {
        for (Car car : cars.getCars()) {
            car.move(Randoms.pickNumberInRange(0, 9));
        }
    }

    private void splitCar(String input) {
        String[] names = input.split(ConstantMessage.COMMA);
        List<Car> carsList = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            carsList.add(new Car(names[i], new CarPosition()));
        }
        cars = new Cars(carsList);
    }

    public void drawCarMove(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.print(car.getName().getName() + ConstantMessage.COLON);
            drawCarMoveByHyphen(car);
            System.out.println();
        }
    }

    private void drawCarMoveByHyphen(Car car) {
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print(ConstantMessage.HYPHEN);
        }
    }

    public void printWinnerCar(Cars cars) {
        int maxPostition = 0;
        for (Car car : cars.getCars()) {
            maxPostition = getMaxPostition(maxPostition, car);
        }
        List<String> winnerCar = new ArrayList<>();
        for (Car car : cars.getCars()) {
            getWinnerCarName(maxPostition, winnerCar, car);
        }
        printWinnerCar(winnerCar);
    }

    private void printWinnerCar(List<String> winnerCar) {
        if (winnerCar.size() == ConstantNumber.WINNING_CAR_IS_ONE) {
            System.out.println(ConstantMessage.FINAL_WINNER + winnerCar.get(0));
        }
        if (winnerCar.size() != ConstantNumber.WINNING_CAR_IS_ONE) {
            System.out.println(ConstantMessage.FINAL_WINNER + String.join(ConstantMessage.COMMA, winnerCar));
        }
    }

    private void getWinnerCarName(int maxPostition, List<String> winnerCar, Car car) {
        if(car.isWinner(maxPostition)) {
            winnerCar.add(car.getName().getName());
        }
    }

    private int getMaxPostition(int maxPostition, Car car) {
        if (lessThanCarPosition(maxPostition, car)) {
            maxPostition = car.getPosition();
        }
        return maxPostition;
    }

    private boolean lessThanCarPosition(int maxPostition, Car car) {
        return maxPostition < car.getPosition();
    }
}
