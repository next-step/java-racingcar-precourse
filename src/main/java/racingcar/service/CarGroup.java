package racingcar.service;

import racingcar.view.RacingCarViewer;

import java.util.*;

public class CarGroup {
    private static final int INITIAL_WINNER = 0;
    private static final String SEPARATION_MARK = ",";

    private final List<Car> cars;

    private CarGroup(List<Car> cars) {
        this.cars = cars;
    }

    public static CarGroup fromNames(String rawNames) {
        checkRawNames(rawNames);
        String[] names = rawNames.split(SEPARATION_MARK);
        checkUniqueName(names);

        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }

        return new CarGroup(cars);
    }

    private static void checkRawNames(String rawNames) {
        int firstIndex = 0;
        int lastIndex = rawNames.length() - 1;

        checkRawNamesCondition(rawNames.contains(SEPARATION_MARK + SEPARATION_MARK));
        checkRawNamesCondition(rawNames.charAt(firstIndex) == SEPARATION_MARK.charAt(firstIndex));
        checkRawNamesCondition(rawNames.charAt(lastIndex) == SEPARATION_MARK.charAt(firstIndex));
    }

    private static void checkRawNamesCondition(boolean isNotValid) {
        if (isNotValid) {
            throw new IllegalArgumentException("[ERROR] 콤마사이에 값을 넣어주세요.");
        }
    }

    private static void checkUniqueName(String[] names) {
        Set<String> distinctNames = new HashSet<>(Arrays.asList(names));

        if (distinctNames.size() != names.length) {
            throw new IllegalStateException("[ERROR] 증복된 이름이 기입되었습니다.");
        }
    }

    public int getCarCount() {
        return getCars().size();
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public void raceByTimes(int loopCount) {
        for (int time = 0 ; time < loopCount ; time++) {
            raceOneCycle();
            RacingCarViewer.printLineBreak();
        }
    }

    private void raceOneCycle() {
        for (Car car : this.cars) {
            car.move();
            RacingCarViewer.printCarStatus(car.getName(), car.getDistance());
        }
    }

    public String getWinners() {
        List<Car> winners = new ArrayList<>();
        winners.add(this.cars.get(INITIAL_WINNER));
        for (int index = 1 ; index < this.cars.size() ; index++) {
            winners = recreateOrAddWinner(winners, this.cars.get(index));
        }

        return toWinnersFromWinnerCars(winners);
    }

    private List<Car> recreateOrAddWinner(List<Car> winners, Car car) {
        if (winners.get(INITIAL_WINNER).getDistanceSize() < car.getDistanceSize()) {
            return Arrays.asList(car);
        }

        if (winners.get(INITIAL_WINNER).getDistanceSize() == car.getDistanceSize()) {
            winners.add(car);
        }

        return winners;
    }

    private String toWinnersFromWinnerCars(List<Car> winners) {
        StringJoiner winnerNames = new StringJoiner(SEPARATION_MARK);
        for (Car winner : winners) {
            winnerNames.add(winner.getName());
        }

        return winnerNames.toString();
    }
}
