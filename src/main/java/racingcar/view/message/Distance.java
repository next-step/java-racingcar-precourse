package racingcar.view.message;

public class Distance {
    private static final String ONE_STEP = "-";

    private final String value;

    private Distance(String value) {
        this.value = value;
    }

    public static Distance from(int position) {
        final String distance = appendStepToDistanceAs(position);
        return new Distance(distance);
    }

    private static String appendStepToDistanceAs(int position) {
        final StringBuilder distance = new StringBuilder();
        for (int i = 0; i < position; i++) {
            distance.append(ONE_STEP);
        }
        return distance.toString();
    }

    public String get() {
        return value;
    }
}
