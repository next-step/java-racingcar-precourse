package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import vo.Car;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameServiceTest {

    private final GameService gameService = new GameService();

    @Test
    @DisplayName("Number is 4 or more, 'forward', otherwise with no change in distance")
    void moveCars() {
        // Given
        Car car1 = new Car("Sonny");
        Car car2 = new Car("Bell");
        Car car3 = new Car("Kane");

        // When
        gameService.move(car1,7);
        gameService.move(car2,2);
        gameService.move(car3,4);

        // Then
        assertThat(car1.getDistance()).isEqualTo(1);
        assertThat(car2.getDistance()).isEqualTo(0);
        assertThat(car3.getDistance()).isEqualTo(1);
    }


    @Test
    @DisplayName("Return the Car with the maximum distance when there is a single winner")
    void validateGetOneCarMaxDistance() {
        // Given
        List<Car> cars = Arrays.asList(new Car("Bell"), new Car("Sonny"), new Car("Kane"));
        cars.get(0).addPosition(); //Bell: 1
        cars.get(1).addPosition(); //Sonny: 1
        cars.get(1).addPosition(); //Sonny: 2

        // When
        List<Car> winner = gameService.getCarWithMaxDistance(cars);

        // Then
        assertThat(winner.get(0)).isEqualTo(cars.get(1));
    }

    @Test
    @DisplayName("Return multiple cars with the maximum distance when there are multiple winners")
    void validateGetMultipleCarMaxDistance() {
        // Given
        Car car1 = new Car("Bell");
        Car car2 = new Car("Sonny");
        Car car3 = new Car("Kane");
        List<Car> cars = Arrays.asList(car1, car2, car3);
        car1.addPosition(); //Bell: 1
        car2.addPosition(); //Sonny: 1
        car2.addPosition(); //Sonny: 2
        car3.addPosition(); //Kane: 1
        car3.addPosition(); //Kane: 2

        // When
        List<Car> winners = gameService.getCarWithMaxDistance(cars);

        // Then
        assertThat(winners).containsExactly(car2, car3);
    }

    @Test
    @DisplayName("Throw IllegalArgumentException when given an empty list of cars")
    void invalidateGetNoneCarMaxDistance() {
        // Given
        List<Car> noneCar = Collections.emptyList();

        // When & Then
        assertThatThrownBy(() -> { gameService.getCarWithMaxDistance(noneCar);})
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 세팅된 자동차가 없습니다.");

    }
}