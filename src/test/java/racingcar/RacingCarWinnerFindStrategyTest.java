package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.car.RacingCar;
import racingcar.car.RacingCarName;
import racingcar.car.RacingCarPosition;
import racingcar.car.RacingCars;
import racingcar.game.strategy.DefaultRacingCarWinnerFindStrategy;
import racingcar.game.strategy.RacingCarWinnerFindStrategy;

public class RacingCarWinnerFindStrategyTest {

    RacingCarWinnerFindStrategy strategy = new DefaultRacingCarWinnerFindStrategy();

    RacingCar createMockRacingCar(String name, int position) {
        RacingCar car = mock(RacingCar.class);
        when(car.getRacingCarName()).thenReturn(new RacingCarName(name));
        when(car.getRacingCarPosition()).thenReturn(new RacingCarPosition(position));
        return car;
    }

    RacingCars createMockRacingCars(RacingCar... cars) {
        RacingCars racingCars = new RacingCars();
        for (RacingCar car : cars) {
            racingCars.addRacingCar(car);
        }
        return racingCars;
    }

    @Test
    void 자동차가_1대일때_항상_우승() {
        RacingCars testResult = createMockRacingCars(createMockRacingCar("car1", 3));
        List<RacingCarName> winners = strategy.pickWinners(testResult);
        assertThat(winners.containsAll(Arrays.asList(new RacingCarName("car1")))).isTrue();
    }

    @Test
    void 모든_자동차가_전진하지_않은_경우() {
        RacingCars testResult = createMockRacingCars(
                createMockRacingCar("car1", 0),
                createMockRacingCar("car2", 0)
        );
        List<RacingCarName> winners = strategy.pickWinners(testResult);
        assertThat(winners.containsAll(Arrays.asList(new RacingCarName("car1"), new RacingCarName("car2")))).isTrue();
    }

    @Test
    void 단일_승자_테스트() {
        RacingCars testResult = createMockRacingCars(
                createMockRacingCar("car1", 3),
                createMockRacingCar("car2", 3),
                createMockRacingCar("car3", 4)
        );
        List<RacingCarName> winners = strategy.pickWinners(testResult);
        assertThat(winners.containsAll(Arrays.asList(new RacingCarName("car3")))).isTrue();
    }

    @Test
    void 다중_승자_테스트() {
        RacingCars testResult = createMockRacingCars(
                createMockRacingCar("car1", 3),
                createMockRacingCar("car2", 3),
                createMockRacingCar("car3", 2)
        );
        List<RacingCarName> winners = strategy.pickWinners(testResult);
        assertThat(winners.containsAll(Arrays.asList(new RacingCarName("car1"), new RacingCarName("car2")))).isTrue();
    }
}
