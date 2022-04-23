package racingcar.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EqualsAndHashCode
public class RacingCar implements Comparable<RacingCar> {
    @NonNull
    @Getter
    private final RacingCarName racingCarName;

    @EqualsAndHashCode.Exclude
    @Getter
    private int moveCount = 0;

    public void move() {
        moveCount++;
    }

    @Override
    public String toString() {
        return racingCarName.getName() + " : " + toStringOfMoveCount();
    }

    private String toStringOfMoveCount() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < moveCount; i++) {
            sb.append("-");
        }

        return sb.toString();
    }

    public static RacingCar newInstance(RacingCar car) {
        RacingCar newInstance = new RacingCar(car.racingCarName);
        newInstance.moveCount = car.moveCount;
        return newInstance;

    }

    @Override
    public int compareTo(RacingCar o) {
        int value = Integer.compare(o.moveCount, this.moveCount);

        if (value == 0) {
            value = this.racingCarName.getName().compareTo(o.racingCarName.getName());
        }

        return value;
    }
}
