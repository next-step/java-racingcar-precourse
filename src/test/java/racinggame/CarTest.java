package racinggame;

import nextstep.test.NSTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest extends NSTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;


    @BeforeEach
    void beforeEach() {

        setUp();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void moveCar() {
        assertRandomTest(() -> {
            Car car = new Car("test");
            car.moveCar();
            assertEquals(car.getPlace(), 1);
        }, MOVING_FORWARD);
    }

    @Test
    void getPlaceToString() {
        assertRandomTest(() -> {
            Car car = new Car("test");
            car.moveCar();
            String placeString = car.getPlaceToString();
            assertEquals(placeString, "test : -");
        }, MOVING_FORWARD);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
