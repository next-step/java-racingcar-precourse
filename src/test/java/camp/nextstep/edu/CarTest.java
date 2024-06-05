package camp.nextstep.edu;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

public class CarTest {

    private String name = "test car";
    private Car car;

    @BeforeEach
    public void init() {
        this.car = new Car(name);
    }

    @Test
    public void carNameCheckTest() {
        assertThat(name).isEqualTo(car.getName());
    }

    @RepeatedTest(100)
    public void randomNumberTest() {
        int num = (int) (Math.random() * 10);
        assertThat(num).isLessThan(10);
    }

}
