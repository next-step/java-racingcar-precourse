package racingcar.model.laps;

public class Laps {
    private final int laps;

    private Laps(int laps) {
        LapsValidator.assertValid(laps);
        this.laps = laps;
    }

    public static Laps of(String laps) {
        return Laps.of(Integer.parseInt(laps));
    }

    public static Laps of(int laps) {
        return new Laps(laps);
    }

    public int get() {
        return laps;
    }
}
