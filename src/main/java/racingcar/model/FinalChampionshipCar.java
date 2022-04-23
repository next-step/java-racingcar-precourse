package racingcar.model;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class FinalChampionshipCar {

    private static final String REST_SPACE = ", ";

    private final StringBuilder builder;
    private final Map<String, Integer> distanceByName;
    private final AtomicInteger topDistance;

    public FinalChampionshipCar(AtomicInteger topDistance, Map<String, Integer> distanceByName) {
        this.builder = new StringBuilder();
        this.distanceByName = distanceByName;
        this.topDistance = topDistance;
    }

    public String getFinalChampionshipCarNames() {
        for (Map.Entry<String, Integer> entry : distanceByName.entrySet()) {
            final String carName = entry.getKey();
            final int count = entry.getValue();
            appendCarName(count, carName);
        }

        return builder.toString();
    }

    private void appendCarName(int count, String carName) {
        if (topDistance.get() > count) {
            return;
        }

        if (builder.length() > 0) {
            builder.append(REST_SPACE);
        }

        builder.append(carName);
    }

}
