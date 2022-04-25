package racingcar;

import net.bytebuddy.matcher.CollectionOneToOneMatcher;

public class Context {
    private CommaSeparatedCarNames car_names;
    private Laps laps;
    private boolean empty;

    public Context() {
        car_names = null;
        laps = null;
        empty = true;
    }

    public Context(CommaSeparatedCarNames names) {
        car_names = names;
        laps = null;
        empty = false;
    }

    public Context(Laps lap_count) {
        car_names = null;
        laps = lap_count;
        empty = false;
    }

    public boolean isEmpty() {
        return empty;
    }

    public CommaSeparatedCarNames getCarNames() {
        return car_names;
    }

    public Laps getLaps() {
        return laps;
    }
}
