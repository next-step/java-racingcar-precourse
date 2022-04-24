package racingcar.feature;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;

public class CarTest {
    final CarName carName = new CarName("ming");
    final ByteArrayOutputStream output = new ByteArrayOutputStream();
    MockedStatic<Randoms> randoms;

    @BeforeEach
    public void before() {
        randoms = Mockito.mockStatic(Randoms.class);
        System.setOut(new PrintStream(output));
    }

    @DisplayName("자동차 - 생성")
    @Test
    void createCarTest() {
        //given:
        Car car = new Car(carName);
        //when:
        //then:
        assertThat(car.getCarName())
                .isEqualTo(carName.getCarName());
    }

    @DisplayName("자동차 - 점수")
    @Test
    void carScoreTest() {
        //given:
        Car car = new Car(carName);
        randoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(4);
        //when:
        car.action();
        //then:
        assertThat(car.getScoreCount())
                .isEqualTo(1);
    }

    @DisplayName("자동차 - 자동차 상태")
    @Test
    void carStatusTest() {
        //given:
        Car car = new Car(carName);
        randoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(4);
        //when:
        car.action();
        car.printStatus();
        //then:
        assertEquals("ming : -\n", output.toString());
    }

    @AfterEach
    public void after() {
        randoms.close();
    }
}
