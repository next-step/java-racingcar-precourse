package nextstep.domain;

public class MoveResult {

    private final String name;
    private final int distance;

    public MoveResult(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public String getName() {
        return this.name;
    }

    public int getDistance() {
        return this.distance;
    }
}
