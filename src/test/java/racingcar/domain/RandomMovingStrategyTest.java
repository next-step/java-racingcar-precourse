package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

class RandomMovingStrategyTest {
    @DisplayName("랜덤값으로 이동 가능한 값이 나왔을 경우")
    @ParameterizedTest
    @ValueSource(ints = { RandomMovingStrategy.MOVEMENT_STANDARD, RandomMovingStrategy.MOVEMENT_STANDARD + 1 })
    void movableValue(int randomValue) {
        try (final MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
            mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(randomValue);
            MovingStrategy strategy = new RandomMovingStrategy();
            assertThat(strategy.isMovable()).isTrue();
        }
    }

    @DisplayName("랜덤값으로 이동 불가능한 값이 나왔을 경우")
    @ParameterizedTest
    @ValueSource(ints = { 0, RandomMovingStrategy.MOVEMENT_STANDARD - 1 })
    void notMovableValue(int randomValue) {
        try (final MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
            mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(randomValue);
            MovingStrategy strategy = new RandomMovingStrategy();
            assertThat(strategy.isMovable()).isFalse();
        }
    }
}