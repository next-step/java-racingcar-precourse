package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import racingcar.ui.ConsoleMessage;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.*;

@DisplayName("경주 게임 도메인 테스트")
class RacingGameTest {

    private Cars cars;

    @BeforeEach
    void setUp() {
        cars = new Cars("car1,car2,car3");
    }

    @Test
    @DisplayName("경주 게임 생성 성공")
    void constructor() {
        // when
        RacingGame racingGame = new RacingGame(cars, new AttemptCount(1));

        // then
        assertThat(racingGame).isNotNull();
    }

    @Test
    @DisplayName("1 미만의 시도 횟수로 경주 게임을 생성하면 예외를 발생한다.")
    void constructorException() {
        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new RacingGame(cars, new AttemptCount(0)))
                .withMessageMatching(ConsoleMessage.ATTEMPT_COUNT_ERROR.getMessage());
    }

    @Test
    @DisplayName("경주 게임 실행 성공")
    void run() {
        // given
        Cars mockCars = Mockito.mock(Cars.class);
        Car car = new Car("car1");
        when(mockCars.getWinners()).thenReturn(new Winners(Collections.singletonList(car)));

        int count = 3;
        RacingGame racingGame = new RacingGame(mockCars, new AttemptCount(count));

        // when
        Winners winners = racingGame.run();

        // then
        assertAll(
                () -> assertThat(winners.getCar(0)).isEqualTo(car),
                () -> verify(mockCars, times(count)).control()
        );
    }
}
