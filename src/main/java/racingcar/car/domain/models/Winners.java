package racingcar.car.domain.models;

import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;
import racingcar.car.domain.errors.CarErrors;
import racingcar.util.StringUtils;

public class Winners {

    private final List<Car> winners;

    public Winners(List<Car> winners) {
        validate(winners);
        this.winners = winners;
    }

    private void validate(List<Car> winners) {
        if (winners == null || winners.isEmpty()) {
            throw new IllegalStateException(CarErrors.WINNERS_EMPTY_ERROR);
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(StringUtils.COMMA + StringUtils.SPACE);

        for (Car winner : winners) {
            joiner.add(winner.getCarName());
        }

        return joiner.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Winners winners1 = (Winners) o;
        return Objects.equals(winners, winners1.winners);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winners);
    }
}
