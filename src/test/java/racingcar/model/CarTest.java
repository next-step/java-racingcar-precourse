package racingcar.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.utils.InputString;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private static final String ERROR_MESSAGE = "[ERROR]";

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void 자동차_이름입력(){
        Car car = new Car(new InputString("pubi"));
        String carName = car.getCarName();

        assertThat(carName).isEqualTo("pubi");
    }

    @Test
    void 차이름이_5자_이상이면_false(){
        try {
            Car.validLength("asdfasd");
        }catch (IllegalArgumentException e) {
            assertThat(e).
                    isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    void 차이름이_5자_이상이면_Error출력(){
        try {
            Car.validLength("asdfasd");
        }catch (IllegalArgumentException e) {
            assertThat(e).
                    isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR]");
        }
    }


}
