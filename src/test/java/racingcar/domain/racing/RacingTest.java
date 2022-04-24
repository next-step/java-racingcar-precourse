package racingcar.domain.racing;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingTest {
    private static final String CAR_NAMES = "pobi,woni,jun";
    private static final int PARTICIPANTS_COUNT = 3;

    @Test
    @DisplayName("자동차 이름과 시도횟수를 입력받아 생성한다")
    void 자동차_이름과_시도횟수를_입력받아_생성한다() {
        assertThat(createRacing()).isNotNull();
    }

    @Test
    @DisplayName("쉼표로 구분된 N개의 자동차 이름으로 생성한다")
    void 쉼표로_구분된_N개의_자동차_이름으로_생성한다() {
        assertThat(createRacing().getParticipants().count()).isEqualTo(PARTICIPANTS_COUNT);
    }

    @Test
    @DisplayName("레이싱을 시작하면 레이싱 결과를 반환한다")
    void 레이싱을_시작하면_레이싱_결과를_반환한다() {
        assertThat(createRacing().start(TryCount.from(5))).isNotNull().isInstanceOf(RacingResult.class);
    }

    private Racing createRacing() {
        return Racing.from(CAR_NAMES);
    }
}
