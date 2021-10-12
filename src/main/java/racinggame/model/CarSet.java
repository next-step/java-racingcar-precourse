package racinggame.model;

import nextstep.utils.Randoms;
import racinggame.exception.IllegalInputException;
import racinggame.util.Constant;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CarSet {
    private static final CarSet carSet = new CarSet();
    private ArrayList<Car> cars;

    private CarSet() {
        this.cars = new ArrayList<>();
    }

    public static CarSet getCarSetInstance() {
        return carSet;
    }

    public void addCar(String name) {
        cars.add(new Car(name));
    }

    public void clearCarList() {
        cars.clear();
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public void moveCars() {
        for (int i = 0; i < cars.size(); i++) {
            moveCarOneByOne(i, Randoms.pickNumberInRange(Constant.LOWER_BOUND_OF_MOVE_POSSIBILITY, Constant.UPPER_BOUND_OF_MOVE_POSSIBILITY));
        }
    }

    private void moveCarOneByOne(int idx, int possibility) {
        if (possibility >= Constant.BORDER_OF_MOVE_POSSIBILITY) cars.get(idx).moveForward();
    }

    public void printOutput() {
        CarSet carSet = CarSet.getCarSetInstance();
        for (Car car : carSet.getCars()) {
            printCar(car.getName(), car.getPosition());
        }
        System.out.println();
    }

    private void printCar(String carName, long carPos) {
        StringBuilder moveDashes = new StringBuilder();
        for (int i = 0; i < carPos; i++) {
            moveDashes.append("-");
        }

        System.out.println(carName + " : " + moveDashes);
    }

    public String getWinner() {
        StringBuilder stringBuilder = new StringBuilder();
        Winner winner = new Winner();
        winner.getWinner();

        for (String winnerName : winner.getWinnerList()) {
            stringBuilder.append(winnerName);
            stringBuilder.append(',');
        }
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(","));
        return stringBuilder.toString();
    }
}
