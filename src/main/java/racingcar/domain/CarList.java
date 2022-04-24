package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class CarList {
    private final List<Car> carList = new ArrayList<>();

    public CarList(String carNames) {
        createCars(carNames);
    }

    private void createCars(String carNames) {
        for (String name : carNames.split(",")) {
            carList.add(new Car(name));
        }
    }

    private int getRandomCommand() {
        return Randoms.pickNumberInRange(
                MoveStatus.COMMAND_RANGE_MIN, MoveStatus.COMMAND_RANGE_MAX);
    }

    public void race() {
        for (Car car : this.getCars()) {
            car.command(getRandomCommand());
        }
    }

    public List<Car> getCars() {
        return carList;
    }

    public String getWinnerName(String token) {
        StringJoiner stringJoiner = new StringJoiner(token);
        for (Car car : getWinnerList()) {
            stringJoiner.add(car.getName());
        }
        return stringJoiner.toString();
    }

    private List<Car> getWinnerList() {
        List<Car> winners = new ArrayList<>();
        winners.add(this.getCars().get(0));
        for (int i = 1; i < this.getCars().size(); i++) {
            winnerMake(winners, i);
        }
        return winners;
    }

    private void winnerMake(List<Car> winners, int index) {
        Car winner = winners.get(0);
        Car car = this.carList.get(index);
        if (car.moveLength() > winner.moveLength()) {
            winners.clear();
        }
        if (car.moveLength() >= winner.moveLength()) {
            winners.add(car);
        }
    }
}
