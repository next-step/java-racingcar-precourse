package src;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class Application {
    public static void main(String[] args) throws IOException {
        InputGetter inputGetter = new InputGetter();
        String[] userName = inputGetter.getUserName();
        int numberOfTry = inputGetter.getNumberOfTry();

        RaceGame raceGame = new RaceGame(userName);
        raceGame.doGame(numberOfTry);
    }

    public static class CarTest {

        private Car car;

        @BeforeEach
        public void setUp() {
            car = new Car("TestCar");
        }

        @Test
        public void testGetName() {
            Assert.assertEquals("TestCar", car.getName());
        }

        @Test
        public void testInitialPosition() {
            Assert.assertEquals(0, car.getPosition());
        }

        @Test
        public void testIncreasePosition() {
            car.increasePosition();
            Assert.assertEquals(1, car.getPosition());
        }

        @Test
        public void testCompareMaxAndPosition() {
            Assert.assertEquals(0, car.compareMaxAndPosition(0));
            car.increasePosition();
            Assert.assertEquals(1, car.compareMaxAndPosition(0));
        }

        @Test
        public void testAddWinner() {
            StringBuilder winner = new StringBuilder();
            car.increasePosition();
            Assert.assertEquals("TestCar", car.addWinner(winner, 1).toString());
        }
    }
}
