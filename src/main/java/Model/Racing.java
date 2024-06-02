package Model;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private List<Car> carList;
    private int rounds;

    public Racing(List<String> carNames, String rounds) {
        carList = new ArrayList<>();
        for(String carName : carNames) {
            carList.add(new Car(carName, 0));
        }
    }

    public List<Car> getCarList() {
        return carList;
    }

    public int getRounds() {
        return rounds;
    }

    public void setRounds(String rounds) {
        this.rounds = Integer.parseInt(rounds);
    }

    public void playRound() {
        for (Car car : carList) {
            car.move();
        }
    }

    public List<String> getWinners() {
        int winnerPositon = 0;
        List<String> winnerNames = new ArrayList<>();
        for (Car car : carList) {
            if (car.getPositon() > winnerPositon) {
                winnerPositon = car.getPositon();;
            }
        }

        for (Car car : carList) {
            if (car.getPositon() == winnerPositon) {
                winnerNames.add(car.getCarName());
            }
        }
        return winnerNames;
    }
}
