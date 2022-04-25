package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class CarInfoTest {

    CarInfo carInfo;

    @BeforeEach
    void CarSetup() {
        carInfo = new CarInfo("java");
    }

    @Test
    void 차_객체생성_테스트() {
        assertRandomNumberInRangeTest(
                () -> assertThat(carInfo.getName()).contains("java"),0
        );
    }
}