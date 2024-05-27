package domain.race.model;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private final int round;
    private int currRound = 0;
    private final List<Car> carList;

    public Race(List<Car> carList, int round) {
        this.carList = carList;
        this.round = round;
    }

    public boolean isFinished() {
        return currRound == round;
    }

    public void game() {
        for (Car car : carList) {
            car.move();
        }
        currRound++;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public List<String> getWinner() {
        List<Car> cars = new ArrayList<>(carList.stream().toList());
        cars.sort((a, b) -> b.getPosition() - a.getPosition());

        List<String> winnerList = new ArrayList<>();
        winnerList.add(cars.get(0).getName());

        for (int i = 1; i < cars.size(); i++) {
            if (cars.get(i).getPosition() == cars.get(0).getPosition()) {
                winnerList.add(cars.get(i).getName());
                continue;
            }
            break;
        }

        return winnerList;
    }
}
