package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class DistanceLog {

    private List<Distance> logs = new ArrayList<>();

    public void record(int factor) {
        this.logs.add(Distance.fromFactor(factor));
    }

    public String calcMileageAsSymbol() {
        return parseToSymbol(calcMileage());
    }

    private String parseToSymbol(Distance mileage) {
        final String symbol = "-";
        final StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < mileage.toNumber(); i++) {
            stringBuilder.append(symbol);
        }
        return stringBuilder.toString();
    }

    private Distance calcMileage() {
        Distance mileage = Distance.valueOf(0);
        for (Distance history : logs) {
            mileage = mileage.add(history);
        }

        return mileage;
    }
}
