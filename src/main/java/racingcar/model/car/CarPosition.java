package racingcar.model.car;

import java.util.Objects;
import racingcar.model.value.RaceMsg;
import racingcar.model.value.Rule;

/**
 * 자동차 위치 객체
 *
 * @author YONGSEOK CHOI
 * @version 1.0 2022.10.09
 */
public class CarPosition {

    private int position;

    public CarPosition() {
        this.position = Rule.START_POSITION;
    }

    public CarPosition(int i) {
        this.position = i;
    }

    public void moveOneStep() {
        position += Rule.ONE_STEP;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarPosition carPosition = (CarPosition) o;
        return position == carPosition.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    public boolean biggerThan(CarPosition p) {
        return position > p.getPosition();
    }

    public boolean lesserThan(CarPosition p) {
        return position < p.getPosition();
    }

    private int getPosition() {
        return position;
    }

    public String printCarPosition() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            builder.append(RaceMsg.PROGRESS_PARTICLE);
        }
        return builder.toString();
    }
}
