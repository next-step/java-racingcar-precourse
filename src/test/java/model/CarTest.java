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
    public void carNameShouldBeSetCorrectly() {
        Car car = new Car("pobi");
        assertEquals("pobi", car.getName());
    }

    @Test
    public void carShouldStartAtPositionZero() {
        Car car = new Car("test");
        assertEquals(0, car.getPosition());
    }

    @Test
    public void carShouldMove() {
        Car car = new Car("test");
        car.move();
        assertEquals(1, car.getPosition());
    }

    @Test
    public void carShouldMoveMultipleTimes() {
        Car car = new Car("test");
        car.move();
        car.move();
        assertEquals(2, car.getPosition());
    }

    @Test
    public void carNameShouldAllowSpecialCharacters() {
        Car car = new Car("p@bi");
        assertEquals("p@bi", car.getName());
    }
}
