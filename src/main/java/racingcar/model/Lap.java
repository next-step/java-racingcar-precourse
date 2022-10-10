package racingcar.model;

public class Lap implements Comparable<Lap> {
    private int lap;

    public Lap(String lap) {
        validate(lap);
        this.lap = Integer.parseInt(lap);
    }

    public Lap(int lap) {
        validate(lap);
        this.lap = lap;
    }

    public int getLap() {
        return lap;
    }

    public void increment() {
        lap += 1;
    }

    @Override
    public int compareTo(Lap o) {
        if (lap > o.getLap()) {
            return 1;
        } else if (lap < o.getLap()) {
            return -1;
        }
        return 0;
    }

    private void validate(String lap) {
        if (!lap.matches("\\d+")) {
            throw new IllegalArgumentException();
        }
    }

    private void validate(int lap) {
        if (lap < 0) {
            throw new IllegalArgumentException();
        }
    }
}
