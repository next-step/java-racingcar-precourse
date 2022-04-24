package racingcar.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.car.Car;
import racingcar.car.CarGroup;

import java.util.List;
import java.util.function.Consumer;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("DefaultRacingReferee에 대해 테스트한다.")
class DefaultRacingRefereeTest {

    private final RacingReferee racingReferee = DefaultRacingReferee.INSTANCE;

    @DisplayName("전체가 한번씩 움직여 모두가 우승자가 된다.")
    @Test
    void allWinningCars() {
        final CarGroup carGroup = CarGroup.of("1,2,3");
        carGroup.forEach(Car::move);

        final RacingResult result = racingReferee.determine(carGroup);

        final List<Car> cars = result.asList();
        assertThat(cars).size().isEqualTo(3);
        assertThat(cars).element(0).satisfies(car -> {
            assertThatCar(car, "1", 1);
        });
        assertThat(cars).element(1).satisfies(car -> {
            assertThatCar(car, "2", 1);
        });
        assertThat(cars).element(2).satisfies(car -> {
            assertThatCar(car, "3", 1);
        });
    }

    @DisplayName("특정 이름만 한번 움직여 한명만 우승자가 된다.")
    @Test
    void oneWinnerCar() {
        final CarGroup carGroup = CarGroup.of("1,2,3");
        carGroup.forEach(moveIfNameEquals("1"));

        final RacingResult result = racingReferee.determine(carGroup);

        final List<Car> cars = result.asList();
        assertThat(cars).size().isEqualTo(1);
        assertThat(cars).element(0).satisfies(car -> {
            assertThatCar(car, "1", 1);
        });
    }

    private static Consumer<Car> moveIfNameEquals(String name) {
        return car -> {
            if (car.name().equals(name)) {
                car.move();
            }
        };
    }

    private static void assertThatCar(Car car, String name, int position) {
        assertThat(car.name()).isEqualTo(name);
        assertThat(car.position()).isEqualTo(position);
    }

}
