package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RepeatServiceTest {

    private RepeatService repeatService;

    @BeforeEach
    void setUp() {
        repeatService = new RepeatService();
    }

    @DisplayName("유효한 값이 나올 때까지 반복한다")
    @Test
    void 유효한_값이_나올_때까지_반복한다() {
        // given
        final int repeatCount = 3;
        final int[] currentCount = {0};

        // when
        repeat(repeatCount, currentCount);

        // then
        assertThat(currentCount[0]).isEqualTo(repeatCount);
    }

    @DisplayName("유효한 값이 바로 나오는 경우 반복하지 않는다")
    @Test
    void 유효한_값이_바로_나오는_경우_반복하지_않는다() {
        // given
        final int repeatCount = 0;
        final int[] currentCount = {0};

        // when
        repeat(repeatCount, currentCount);

        // then
        assertThat(currentCount[0]).isEqualTo(repeatCount);
    }

    private void repeat(int repeatCount, int[] currentCount) {
        repeatService.initTarget(() -> {
            if (repeatCount == currentCount[0]) {
                return "FINISH";
            }

            currentCount[0]++;

            return null;
        });
    }
}