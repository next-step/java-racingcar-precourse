package racingcar.domain;

import racingcar.stategy.RandomMovingStrategy;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;
    private static final String SPLIT_SEPARATOR = ",";

    public Cars(String names) {
        this.cars = addCars(names);
    }

    private List<Car> addCars(String names) {
        String[] splitedNames = names.split(SPLIT_SEPARATOR);
        List<Car> cars = new ArrayList<>();
        for (int k = 0; k < splitedNames.length; k++) {
            cars.add(new Car(splitedNames[k], 0));
        }
        return cars;
    }

    public PlayResult startRacing(final String inputCount) {
        int playNumber = parsePlayNumberToInt(inputCount);
        for (int k = 0; k < playNumber; k++) {
            startRandomMoving();
        }

        return new PlayResult(cars);
    }

    public void startRandomMoving() {
        for (int k = 0; k < cars.size(); k++) {
            Car car = cars.get(k);
            car.move(new RandomMovingStrategy());
            System.out.println(car.getName() + " : " + car.getHyphenPosition());
        }
        System.out.println("--------------");
    }

    private int parsePlayNumberToInt(final String inputCount) {
        int playNumber = 0;
        try {
            playNumber = Integer.parseInt(inputCount);
        } catch (NumberFormatException e) {
            GuideMessage.에러_올바른_횟수.printlnMessage();
            throw new IllegalArgumentException(GuideMessage.에러_올바른_횟수.getMessage());
        }

        if (playNumber < 1) {
            GuideMessage.에러_올바른_횟수.printlnMessage();
            throw new IllegalArgumentException(GuideMessage.에러_올바른_횟수_음수.getMessage());
        }

        return playNumber;
    }

    public List<Car> getCarList() {
        return cars;
    }

}
