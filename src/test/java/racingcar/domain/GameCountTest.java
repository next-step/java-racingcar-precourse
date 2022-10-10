package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class GameCountTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 5, 4, 3, 2})
    void 게임_횟수_객체_생성(final int count) {
        GameCount gameCount = new GameCount(count);
        Assertions.assertThat(gameCount).isEqualTo(new GameCount(count));
    }

    @Test
    void 경기_횟수_감소() {
        GameCount gameCount = new GameCount(5);
        GameCount downCounted = gameCount.downCount();
        Assertions.assertThat(downCounted).isEqualTo(new GameCount(4));
    }

    @Test
    void 경기_횟수_잔여_여부_확인() {
        GameCount gameCount = new GameCount(1);
        GameCount downCounted = gameCount.downCount();
        Assertions.assertThat(downCounted.isLeft()).isFalse();
    }

    @Test
    void 게임_횟수에_문자열_입력시_오류발생_테스트() {
        Assertions.assertThatThrownBy(() -> new GameCount("dd"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
