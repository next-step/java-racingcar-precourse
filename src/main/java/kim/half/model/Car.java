package kim.half.model;

public class Car {

    private final String name;
    private int distance = 0;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    public void run(int number) {
        if (isMove(number)) {
            this.distance++;
        }
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    private void validateName(String name) {
        if (name == null || name.length() < Rule.MIN_LENGTH.value()
            || name.length() > Rule.MAX_LENGTH.value()) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 1자 이상 5자 이하만 가능합니다.");
        }
    }

    private boolean isMove(int number) {
        return number >= Rule.THRESHOLD.value();
    }
}
