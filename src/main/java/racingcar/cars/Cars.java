package racingcar.cars;

import racingcar.rules.Rule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {

    private static final String SEPARATOR = ",";

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars generateRacingCarsFromInputString(String input) throws IllegalArgumentException {
        String[] nameArr = input.split(SEPARATOR);
        List<Car> cars = new ArrayList<>();
        for (String name : nameArr) {
            cars.add(new Car(name));
        }
        return new Cars(cars);
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public Cars race() {
        for (Car car : this.cars) {
            car.setLocation(Rule.isMovingForward());
            car.printRaceResult();
        }
        return new Cars(this.cars);
    }

    public String filterWinner() {
        ArrayList<String> winnerList = new ArrayList<>();
        Collections.sort(this.cars, Collections.reverseOrder());
        int max = cars.get(0).getLocation();

        for (Car car : cars) {
            winnerList = findCoWinner(max, car, winnerList);
        }
        return String.join(", ", winnerList);
    }

    private ArrayList<String> findCoWinner(int max, Car car, ArrayList<String> winnerList) {
        if (max == car.getLocation()) winnerList.add(car.getName());
        return winnerList;
    }

}
