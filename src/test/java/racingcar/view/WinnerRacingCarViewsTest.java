package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.common.NaturalNumber;
import racingcar.common.UserString;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerRacingCarViewsTest {
    @Test
    @DisplayName("우승자가 2명 이상일 경우 콤마로 연결하여 출력함")
    void test1() {
        WinnerRacingCarViews of = WinnerRacingCarViews.of(Arrays.asList(
                RaceCarView.of(UserString.of("car1"), NaturalNumber.of(10)),
                RaceCarView.of(UserString.of("car2"), NaturalNumber.of(10))
        ));

        assertThat(of.getWinners()).isEqualTo("car1,car2");
    }
}