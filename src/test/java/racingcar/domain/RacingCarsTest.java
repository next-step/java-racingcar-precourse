package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

        verify(car).move(any());
    }

    @DisplayName("우승자 정보를 얻어온다")
    @Test
    void getWinnerNames() {
        RacingCars racingCars = new RacingCars(
            Arrays.asList(
                createMockCar("win1", true),
                createMockCar("win2", true),
                createMockCar("lo1", false),
                createMockCar("lo2", false)
            )
        );

        Winners winners = racingCars.getWinners();
        List<String> winnerNames = winners.getNames();

        assertThat(winnerNames.size()).isEqualTo(2);
        assertThat(winnerNames.toString()).contains("win1", "win2");
    }

    private Car createMockCar(String willReturnName, boolean willReturnIsWinner) {
        Car car = mock(Car.class);
        when(car.getName()).thenReturn(willReturnName);
        when(car.isWinner(anyInt())).thenReturn(willReturnIsWinner);
        return car;
    }
}