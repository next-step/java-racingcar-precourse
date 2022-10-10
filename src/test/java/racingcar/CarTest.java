package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    Car car;

    @BeforeEach
    public void setUp() {
        car = new Car("pobi");
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void carNameTest() {
        assertThatThrownBy(() -> car = new Car("javaji")).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @ParameterizedTest
    @CsvSource(value = {"4:1", "0:0", "9:1"}, delimiter = ':')
    void getPositionTest(int number, int expectedPosition) {
        car.move(number);
        assertThat(car.getCarPosition()).isEqualTo(expectedPosition);
    }


}
