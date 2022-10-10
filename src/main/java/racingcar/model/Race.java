package racingcar.model;

import java.util.List;
import racingcar.common.Messages;

public class Race {

    private final RaceCount raceCount;
    private final RacePosition topPosition;

    public Race(RaceCount raceCount, RacePosition topPosition) {
        this.raceCount = raceCount;
        this.topPosition = topPosition;
    }

    public RaceCount getRaceCount() {
        return raceCount;
    }

    public void start(List<Car> cars) {
        for (int count = 0; count < raceCount.get(); count++) {
            progress(cars);
            Messages.EMPTY.println();
        }
        printWinners(cars);
    }

    private void progress(List<Car> cars) {
        for (Car car : cars) {
            car.move();
            car.print();
            topPosition.update(car.getPosition());
        }
    }

    private void appendWinner(StringBuilder builder, Car car) {
        if (car.getPosition().equals(topPosition)) {
            builder.append(car.getName()).append(Messages.COMMA.toString()).append(Messages.BLANK.toString());
        }
    }

    private void printWinners(List<Car> cars) {
        StringBuilder builder = new StringBuilder();
        builder.append(Messages.WINNERS.toString());
        for (Car car : cars) {
            appendWinner(builder, car);
        }
        builder.setLength(builder.length() - 2);
        Messages.EMPTY.println(builder.toString());
    }
}
