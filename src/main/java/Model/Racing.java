package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Racing {
    private List<Car> carList;
    private int rounds;

    public Racing(List<String> carNames, String rounds) {
        carList = new ArrayList<>();
        for(String carName : carNames) {
            carList.add(new Car(carName, 0));
        }

        ErrorDetect.roundsTest(rounds);
        this.rounds = Integer.parseInt(rounds);
    }

    public List<Car> getCarList() {
        return carList;
    }

    public int getRounds() {
        return rounds;
    }

    public void playRound() {
        for (Car car : carList) {
            car.move();
        }
    }

}
