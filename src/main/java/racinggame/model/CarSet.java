package racinggame.model;

import nextstep.utils.Randoms;
import racinggame.util.Constant;

import java.util.ArrayList;

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

    public void moveCars(int count) {
        for (Car car : cars) {
            car.moveForward(count, Constant.BORDER_OF_MOVE_POSSIBILITY);
        }
    }

    public void printOutput(int count) {
        for (int i = 0; i < count; i++) {
            printCar(i);
        }
    }

    private void printCar(int turn) {
        StringBuilder racing = new StringBuilder();
        for (Car car : cars) {
            racing.append(car.getName() + " : " + car.getDashes()[turn] + "\n");
        }

        System.out.println(racing);
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
