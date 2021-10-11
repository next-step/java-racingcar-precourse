package racinggame.game.car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    private final List<Car> carList;
    private List<String> winnerCarNames;
    private int winnerForwardMovementCount = 0;

    public Cars(List<String> carNames) {
        this.carList = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(carName);
            this.carList.add(car);
        }
    }


    public void runRace() {
        for (Car car : this.carList) {
            car.runRace();
        }
    }

    public List<Car> getCarList() {
        return this.carList;
    }

    public List<String> getWinnerCarNames() {
        setWinnerCarNames();
        return winnerCarNames;
    }

    private void setWinnerCarNames() {
        this.winnerCarNames = new ArrayList<>();
        this.winnerForwardMovementCount = Collections.max(this.carList).getForwardMovementCount();
        Collections.reverse(this.carList);

        for (Car car : this.carList) {
            addNamesIfIsWinner(car);
        }
    }

    private void addNamesIfIsWinner(Car car) {
        if(car.getForwardMovementCount() == this.winnerForwardMovementCount) {
            this.winnerCarNames.add(car.getName());
        }
    }


}
