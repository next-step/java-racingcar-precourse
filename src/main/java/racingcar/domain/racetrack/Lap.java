package racingcar.domain.racetrack;

import java.util.Objects;
import racingcar.util.ValidateUtil;

public class Lap {

    int lap;

    public Lap(Integer inputValue) {
        ValidateUtil.positive(inputValue);
        this.lap = inputValue;
    }

    public Lap(String inputText) {
        ValidateUtil.numberFormat(inputText);
        this.lap = Integer.parseInt(inputText);
    }

    public int getCurrentLap() {
        return lap;
    }

    public void decrease() {
        lap--;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lap lap1 = (Lap) o;
        return lap == lap1.lap;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lap);
    }


}
