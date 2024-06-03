package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.Car;

public class CarTest {

    private Car car;

    @BeforeEach
    public void setUp() {
        car = new Car("TestCar");
    }

    @Test
    public void testGetName() {
        assertEquals("TestCar", car.getName());
    }

    @Test
    public void testInitialPosition() {
        assertEquals(0, car.getPosition());
    }

    @Test
    public void testIncreasePosition() {
        car.increasePosition();
        assertEquals(1, car.getPosition());
    }

    @Test
    public void testCompareMaxAndPosition() {
        assertEquals(0, car.compareMaxAndPosition(0));
        car.increasePosition();
        assertEquals(1, car.compareMaxAndPosition(0));
    }

    @Test
    public void testAddWinner() {
        StringBuilder winner = new StringBuilder();
        car.increasePosition();
        assertEquals("TestCar", car.addWinner(winner, 1).toString());
    }
}
