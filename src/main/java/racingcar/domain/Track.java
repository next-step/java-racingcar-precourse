package racingcar.domain;

public class Track {
    private Integer value;

    private Track(Integer value) {
        this.value = value;
    }

    public static Track initialize() {
        return new Track(0);
    }

    public static Track from(Integer value) {
        return new Track(value);
    }

    public Integer getValue() {
        return this.value;
    }

    public void move(MovingCommand command) {
        if (command == MovingCommand.MOVE_FORWARD) {
            this.value++;
        }
    }
}
