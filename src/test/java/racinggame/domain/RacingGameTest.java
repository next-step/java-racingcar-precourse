package racinggame.domain;

import nextstep.utils.Randoms;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

public class RacingGameTest {
    @Test
    void 레이싱_게임_1회_실행() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            // given
            mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(9, 0, 0);
            List<Car> cars = Arrays.asList(new Car("pobi"), new Car("crong"), new Car("honux"));
            GameResult result = new RacingGame(cars).run(new LapCount(1));

            // when
            List<String> winners = result.getWinners();

            // then
            assertThat(winners).containsExactly("pobi");
        }
    }

    @Test
    void 레이싱_게임_1회_실행_공동우승() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            // given
            mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(0, 0, 0);
            List<Car> cars = Arrays.asList(new Car("pobi"), new Car("crong"), new Car("honux"));
            GameResult result = new RacingGame(cars).run(new LapCount(1));

            // when
            List<String> winners = result.getWinners();

            // then
            assertThat(winners).containsExactly("pobi", "crong", "honux");
        }
    }

    @Test
    void 레이싱_게임_5회_실행_예제() {
        // given
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            // given
            mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(9, 0, 9)
                    .thenReturn(9, 9, 9)
                    .thenReturn(9, 9, 9)
                    .thenReturn(9, 9, 9)
                    .thenReturn(9, 9, 9);
            List<Car> cars = Arrays.asList(new Car("pobi"), new Car("crong"), new Car("honux"));
            GameResult result = new RacingGame(cars).run(new LapCount(5));

            // when
            List<String> winners = result.getWinners();

            // then
            assertThat(winners).containsExactly("pobi", "honux");
        }
    }
}
