package racingCar.domain;

public class CarDTO {
    private final String name;
    private int pos = 0;

    public CarDTO(String name) {
        this.name = name;
    }

    public void increasePos() {
        pos++;
    }

    public String getName() {
        return name;
    }

    public int getPos() {
        return pos;
    }
}
