package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class RacingCarsTest {
    @DisplayName("레이킹 카 생성")
    @Test
    void create() {
        List<Car> cars = Arrays.asList(
            new Car("car1"),
            new Car("car2"),
            new Car("car3")
        );
        RacingCars racingCars = new RacingCars(cars);

        assertThat(racingCars.getCars().size()).isEqualTo(cars.size());
    }

    @DisplayName("playRound 호출 시 car의 move메소드 호출하는지 확인")
    @Test
    void playRound() {
        Car car = mock(Car.class);
        RacingCars racingCars = new RacingCars(Collections.singletonList(car));

        racingCars.playRound();

        verify(car).move();
    }

    @DisplayName("우승자 이름을 얻어온다")
    @Test
    void getWinnerNames() {
        String[] carNames = {"win1", "win2", "lo1", "lo2"};
        RacingCars racingCars = createRacingCars(carNames);

        try (final MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
            mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(Car.MOVEMENT_STANDARD, Car.MOVEMENT_STANDARD, Car.MOVEMENT_STANDARD - 1, Car.MOVEMENT_STANDARD - 1);
            racingCars.playRound();
        }
        List<String> winnerNames = racingCars.getWinnerNames();

        assertThat(winnerNames.size()).isEqualTo(2);
        assertThat(winnerNames.toString()).contains("win1", "win2");
    }

    private RacingCars createRacingCars(String ...carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name: carNames) {
            cars.add(new Car(name));
        }
        return new RacingCars(cars);
    }
}