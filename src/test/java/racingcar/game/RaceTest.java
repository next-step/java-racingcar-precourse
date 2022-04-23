package racingcar.game;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Cars;
import racingcar.domain.MoveCount;

public class RaceTest {

    @Nested
    @DisplayName("레이싱카 주행 테스트")
    class RacingCarDriveTest {

        @DisplayName("시도할 회수가 n 이라면 자동차 이동 시도 역시 n번이 발생해야 한다")
        @ParameterizedTest
        @ValueSource(ints = {1, 3, 5, 7, 9})
        void racing_car_move_test(int 시도할_회수) {
            Cars cars = mock(Cars.class);
            MoveCount moveCount = new MoveCount(시도할_회수);

            Race race = new Race(cars, moveCount);
            race.start();
            verify(cars, times(시도할_회수)).move();
        }
    }
}
