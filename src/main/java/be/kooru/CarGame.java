package be.kooru;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CarGame {

    private static final int CAR_GAME_RULE_ONE_STEP = 4;

    private final List<Car> cars;

    public CarGame(Collection cars) {
        // 외부에서 주입된 Collection이 변경되면 내부적으로 영향을 줄 수 있다고 판단
        this.cars = new ArrayList<>(cars);
    }

    public void start() {
        for (Car car : cars) {
            addCarScore(car);
            printCarScore(car);
        }
        System.out.println();
    }

    protected void addCarScore(Car car) {
        int randomNumber = Util.generateRandomNumber(1, 0, 9)[0];
        car.addScore(scoreCalculator(randomNumber));
    }

    protected void printCarScore(Car car) {
        StringBuilder sb = new StringBuilder();
        sb.append(car.getName()).append(":");
        for (int i = 0; i < car.getScore(); i++) {
            sb.append("-");
        }
        System.out.println(sb.toString());
    }

    protected List<String> maxScoreCarList() {
        List<String> tempCars = new ArrayList<>();
        int maxNumber = 0;

        for (Car car : cars) {
            if (maxNumber == car.getScore()) {
                tempCars.add(car.getName());
            }
            if (maxNumber < car.getScore()) {
                tempCars = new ArrayList<>();
                tempCars.add(car.getName());
                maxNumber = car.getScore();
            }
        }
        return tempCars;
    }

    public void printCarWinner() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.join(",", maxScoreCarList()))
                .append("가 최종우승했습니다.");
        System.out.println(sb.toString());
    }

    protected int scoreCalculator(int value) {
        return value >= CAR_GAME_RULE_ONE_STEP ? 1 : 0;
    }

}
