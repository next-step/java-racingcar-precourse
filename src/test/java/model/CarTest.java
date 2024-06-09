package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    private Car car;

    @BeforeEach
    public void setUp() {
        car = new Car("Car1");
    }


    @Test
    @DisplayName("이동 조건을 충족시 positon 값 1 증가")
    void addPosition_whenSatisfyCondition() {
        // given
        int initialPosition = car.getPosition();
        int randomNumber = 5;

        // when
        car.move(randomNumber);
        int newPosition = car.getPosition();

        // then
        assertEquals(initialPosition + 1, newPosition);
    }

    @Test
    @DisplayName("이동 조건이 충족되지 않으면 position 값 유지")
    void stayPosition_whenSatisfyNotCondition() {
        // given
        int initialPosition = car.getPosition();
        int randomNumber = 3;

        // when
        car.move(randomNumber);
        int newPosition = car.getPosition();

        // then
        assertEquals(initialPosition, newPosition);
    }


}
