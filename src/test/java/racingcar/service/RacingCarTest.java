package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RacingCarTest {
    RacingCar racingCar;
    String carsName;
    int tryCnt;

    @BeforeEach
    void setUp() {
        carsName = "pobi,woni,jun";
        tryCnt = 1;
        racingCar = new RacingCar(carsName);
    }


    @Test
    void 레이싱자동차_PLAY_TEST() {
        assertThat(racingCar.start(tryCnt)).isTrue();
    }

    @Test
    void 레이싱자동차_PLAY_예외_TEST() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThrows(IllegalStateException.class, () -> {
                        racingCar.start(tryCnt);
                    });
                }, 4, 3, 10);
    }

    @Test
    void 레이싱자동차_END_TEST() {
        OutputStream outputStream = new ByteArrayOutputStream();

        assertRandomNumberInRangeTest(
                () -> {
                    racingCar.start(3);

                    System.setOut(new PrintStream(outputStream));
                    racingCar.end();

                    assertThat(outputStream.toString().trim()).isEqualTo("최종 우승자 : woni");
                },
                3, 4, 3, 4, 4, 3, 4, 4, 4
        );
    }

}
