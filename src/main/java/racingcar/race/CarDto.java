package racingcar.race;

public class CarDto {
    private final String name;
    private final int position;

    public CarDto(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public int position() {
        return position;
    }

    public String name() {
        return name;
    }
}
