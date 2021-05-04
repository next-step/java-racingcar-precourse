
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarNameTest {
    private CarName carName;
    private final String CAR_NAME = "xm3";
    private final String CAR_NAME_MAX = "myxm3";
    private final String CAR_NAME_BOUNDARY = "sonata";
    private final String CAR_NAME_LONG = "trailblazer";

    @Test
    void newCarNameTest() {
        carName = new CarName(CAR_NAME);
        Assertions.assertEquals(carName.toString(), CAR_NAME);
    }

    @Test
    void newCarNameMaxTest() {
        carName = new CarName(CAR_NAME_MAX);
        Assertions.assertEquals(carName.toString(), CAR_NAME_MAX);
    }

    @Test
    void newCarNameBoundaryExceptionTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CarName(CAR_NAME_BOUNDARY);
        });
    }

    @Test
    void newCarNameExceptionTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CarName(CAR_NAME_LONG);
        });
    }
}
