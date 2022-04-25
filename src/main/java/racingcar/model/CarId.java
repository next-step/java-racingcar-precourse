package racingcar.model;

import java.util.UUID;

/**
 * 자동차 중복 이름 발생시 식별 위한 ID
 */
public class CarId {

    private final String carId;

    public CarId() {
        this.carId = UUID.randomUUID().toString();
    }

    public String carId() {
        return this.carId;
    }
}
