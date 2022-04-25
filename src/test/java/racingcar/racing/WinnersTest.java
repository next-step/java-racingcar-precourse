package racingcar.racing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.utils.TestCarsUtils;

class WinnersTest {

    @Test
    @DisplayName("우승자들 생성 성공 테스트")
    void init() {
        // given

        // when
        final Winners winners = Winners.init(TestCarsUtils.testWinnerCounts());

        // then
        assertThat(winners).isNotNull();
    }

    @Test
    @DisplayName("우승자들 생성 실패 테스트")
    void init_exception() {
        // given

        // when & then
        assertThatThrownBy(() -> Winners.init(WinnerCounts.init()))
                .isInstanceOf(IllegalArgumentException.class);
    }

}