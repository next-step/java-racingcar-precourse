package racinggame;

import nextstep.test.NSTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racinggame.model.Car;

public class CarTest extends NSTest{
    private final int numOfMove = 4;

    @BeforeEach
    void beforeEach() {
        setUp();
    }

    @AfterEach
    void tearDown() {
        outputStandard();
    }

    @Test
    void 이름_저장() {
        Car carForTest = new Car("latte");
        System.out.println(carForTest.getName());
        verify("latte");
    }

    @Test
    void 전진() {
        Car carForTest = new Car("latte");
        for (int i = 0; i < numOfMove; i++) {
            carForTest.moveForward();
        }
        System.out.println(carForTest.getPosition());
        verify(Integer.toString(numOfMove));
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
