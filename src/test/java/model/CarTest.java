package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CarTest {
    @Test
    public void carNameShouldBeFiveCharsOrLess() {
        IllegalArgumentException thrown = assertThrows(
            IllegalArgumentException.class,
            () -> new Car("abcdef")
        );
        assertEquals("[ERROR] 자동차 이름은 1자 이상 5자 이하만 가능합니다.", thrown.getMessage());
    }

    @Test
    public void carNameShouldNotBeEmpty() {
        IllegalArgumentException thrown = assertThrows(
            IllegalArgumentException.class,
            () -> new Car("")
        );
        assertEquals("[ERROR] 자동차 이름은 1자 이상 5자 이하만 가능합니다.", thrown.getMessage());
    }

    @Test
    public void carShouldStartAtPositionZero() {
        Car car = new Car("test");
        car.initializePosition();
        assertEquals(0, car.getPosition());
    }

    @Test
    public void carShouldMove() {
        Car car = new Car("test");
        car.initializePosition();
        car.move();
        assertEquals(1, car.getPosition());
    }
}
