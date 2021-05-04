import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CarTest {
    
    private Car car;
    private final String CAR_NAME = "xm3";
    private final String DELEMETER = " : ";
    private final String ONE_STEP = "-";

    
    // @CsvSource(value = {"xm3:0", "xm3:1", "xm3:2", "xm3:3", "456:0", "789:0"}, delimiter = ':')
    @Test
    void newCarTest() {
        car = new Car(new CarName(CAR_NAME));
        Assertions.assertEquals(car.toString(), CAR_NAME + DELEMETER);
    }

    @ParameterizedTest
    @CsvSource(value = {"0", "1", "2", "3"})
    void newCarNoStepTest(int num) {
        car = new Car(new CarName(CAR_NAME));
        car.go(num);
        Assertions.assertEquals(car.toString(), CAR_NAME + DELEMETER);
    }

    @ParameterizedTest
    @CsvSource(value = {"4", "5", "6", "7", "8", "9"})
    void newCarOneStepTest(int num) {
        car = new Car(new CarName(CAR_NAME));
        car.go(num);
        Assertions.assertEquals(car.toString(), CAR_NAME + DELEMETER + ONE_STEP);
    }
}
