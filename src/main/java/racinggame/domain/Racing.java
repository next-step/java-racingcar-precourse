package racinggame.domain;

import nextstep.utils.Randoms;
import racinggame.view.Command;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Racing {
    private static final Pattern ATTEMPT_COUNT_PATTERN = Pattern.compile("[+-]?\\d*(\\.\\d+)?");

    private final List<Car> cars;
    private final int attemptCount;

    public Racing(List<Car> cars, String attemptCountStr) {
        carsValidation(cars);
        attemptCountValidation(attemptCountStr);
        this.cars = cars;
        this.attemptCount = Integer.parseInt(attemptCountStr);
    }

    public void oneTurn() {
        for(Car car : this.cars) {
            car.goAndStop(Randoms.pickNumberInRange(0, 9));
        }
    }

    public void printOneTurnResult(Command command) {
        for(Car car : this.cars) {
            command.printCar(car);
        }
        command.println();
    }

    public static Racing createRacing(final String carsStr, final String attemptCountStr) {
        final String[] carsStrArr = carsStr.split(",");
        final List<Car> cars = new ArrayList<>();
        for(String carStr : carsStrArr) {
            cars.add(new Car(carStr));
        }
        return new Racing(cars, attemptCountStr);
    }

    private void duplicated(List<Car> cars) {
        Set<Car> carsSet = new HashSet<>(cars);
        if(cars.size() != carsSet.size()) {
            throw new IllegalArgumentException();
        }
    }

    private void carsValidation(List<Car> cars) {
        duplicated(cars);
    }

    public void attemptCountValidation(String attemptCountStr) {
        final Matcher matcher = ATTEMPT_COUNT_PATTERN.matcher(attemptCountStr);
        if(!matcher.matches()) {
            throw new IllegalArgumentException();
        }
    }

    public int getAttemptCount() {
        return attemptCount;
    }
}
