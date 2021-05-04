import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarProgressTest {
    private CarProgress carProgress;
    private final int MAXIMUM_STOP_NUMBER = 3;
    private final int MINIMUM_GO_NUMBER = 4;
    private final int MAXIMUM_NUMBER = 9;
    private final int MINIMUM_NUMBER = 0;
    private final int MINUS_NUMBER = -1;
    private final int EX_NUMBER = 10;
    private final String NO_STEP = "";
    private final String ONE_STEP = "-";
    private final String TWO_STEP = "--";

    @BeforeEach
    void setup() {
        carProgress = new CarProgress();
    }

    @Test
    void goNoStepCarTest() {
        carProgress.moveForward(MAXIMUM_STOP_NUMBER);
        carProgress.moveForward(MINIMUM_NUMBER);
        Assertions.assertEquals(carProgress.toString(), NO_STEP);
    }

    @Test
    void goOneStepCarTest() {
        carProgress.moveForward(MINIMUM_GO_NUMBER);
        Assertions.assertEquals(carProgress.toString(), ONE_STEP);
    }

    @Test
    void goTwoStepCarTest() {
        carProgress.moveForward(MINIMUM_GO_NUMBER);
        carProgress.moveForward(MAXIMUM_NUMBER);
        Assertions.assertEquals(carProgress.toString(), TWO_STEP);
    }

    @Test
    void newCarMoveMinusNumberExceptionTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            carProgress.moveForward(MINUS_NUMBER);
        });
    }

    @Test
    void newCarMoveExNumberExceptionTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            carProgress.moveForward(EX_NUMBER);
        });
    }

}
