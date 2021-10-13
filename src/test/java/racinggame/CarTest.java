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
    void 움직이기() {
        Car carForTest = new Car("latte");
        assertRandomTest(()-> {
            run("latte", "1");
            verify("latte : -");
        },5);
    }
    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
