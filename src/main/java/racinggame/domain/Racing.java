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

    public List<String> getWinnerStr() {
        List<String> winner = new ArrayList<>();
        int highScore = getHighScore();
        for(Car car : this.cars) {
            addWinner(winner, highScore, car);
        }
        return winner;
    }

    private void addWinner(List<String> winner, int highScore, Car car){
        if(car.getDistance() == highScore) {
            winner.add(car.getCarName());
        }
    }

    private int getHighScore() {
        int highScore = 0;
        for(Car car : this.cars) {
            highScore = checkHighScore(highScore, car.getDistance());
        }
        return highScore;
    }

    private int checkHighScore(int highScore, int distance) {
        if(distance >= highScore) {
            highScore = distance;
        }
        return highScore;
    }

    public void playRacing(Command command) {
        for(int i=0; i<getAttemptCount(); i++) {
            oneTurn();
            printOneTurnResult(command);
        }
    }

    private void oneTurn() {
        for(Car car : this.cars) {
            car.goAndStop(Randoms.pickNumberInRange(0, 9));
        }
    }

    private void printOneTurnResult(Command command) {
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

    private void attemptCountValidation(String attemptCountStr) {
        final Matcher matcher = ATTEMPT_COUNT_PATTERN.matcher(attemptCountStr);
        if(!matcher.matches()) {
            throw new IllegalArgumentException();
        }
    }

    private int getAttemptCount() {
        return attemptCount;
    }
}
