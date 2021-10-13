package racinggame.domain;

import java.util.ArrayList;
import java.util.List;
import nextstep.utils.Randoms;

public class RacingCars {

    private final List<RacingCar> racingCars;

    public RacingCars(final Names names) {
        this.racingCars = new ArrayList<>();
        for (Name name : names.getNames()) {
            racingCars.add(new RacingCar(name));
        }
    }

    public void race(NumberOfMoves numberOfMoves) {
        for (int i = 0; i < numberOfMoves.getValue(); i++) {
            moveRacingCars();
            reportCurrentState();
        }
        reportWinner();
    }

    private void moveRacingCars() {
        for (RacingCar car : racingCars) {
            car.move(Randoms.pickNumberInRange(0, 9));
        }
    }

    private void reportCurrentState() {
        StringBuilder sb = new StringBuilder();
        for (RacingCar car : racingCars) {
            sb.append(car.getName().getValue())
                .append(" : ")
                .append(currentPosition(car))
                .append("\n");
        }
        System.out.println(sb);
    }

    private String currentPosition(final RacingCar car) {
        Position position = new Position();
        StringBuilder sb = new StringBuilder();
        while (position.compareTo(car.getPosition()) < 0) {
            sb.append("-");
            position = position.next();
        }
        return sb.toString();
    }

    private void reportWinner() {
        Position max = new Position();
        for (RacingCar car : racingCars) {
            if (car.getPosition().compareTo(max) > 0) {
                max = car.getPosition();
            }
        }

        final List<String> winners = new ArrayList<>();
        for (RacingCar car : racingCars) {
            if (car.getPosition().compareTo(max) == 0) {
                winners.add(car.getName().getValue());
            }
        }

        System.out.println("최종 우승자는 " + String.join(",", winners) + " 입니다.");
    }
}
