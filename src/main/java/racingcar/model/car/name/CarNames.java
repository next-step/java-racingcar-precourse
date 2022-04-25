package racingcar.model.car.name;


import java.util.LinkedList;
import java.util.Queue;
import racingcar.error.Error;

public class CarNames {
    private static final String DELIMITER = ",";

    private final Queue<CarName> carNames = new LinkedList<>();

    public CarNames(String lineup) {
        for (String eachName : lineup.split(DELIMITER)) {
            carNames.offer(new CarName(eachName));
        }
    }

    public boolean hasNext() {
        return !carNames.isEmpty();
    }

    public CarName next() {
        if (carNames.isEmpty()) {
            throw new IllegalStateException(Error.IS_EMPTY_STATUS.message());
        }

        return carNames.poll();
    }
}
