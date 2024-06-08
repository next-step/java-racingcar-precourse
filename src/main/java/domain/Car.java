package domain;

public class Car {
    private final String carName;
    private int position;

    public Car(String carName) {
        // 차 이름 검증
        this.carName = carName;
        this.position = 0;
    }
}
