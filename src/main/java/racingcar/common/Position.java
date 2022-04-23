package racingcar.common;

public class Position {
    private final Integer DEFAULT_POSITION = 0;

    private Integer position = DEFAULT_POSITION;

    public Position() {}

    public void forward() {
        this.position++;
    }

    public void forward(Integer count) {
        this.position += count;
    }

    public Integer getPosition() {
        return this.position;
    }
}
