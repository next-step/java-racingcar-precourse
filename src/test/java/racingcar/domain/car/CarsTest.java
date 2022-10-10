package racingcar.domain.car;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.contant.ExceptionMessage;

class CarsTest {

    @Test
    @DisplayName("두 자동차의 이동거리를 비교하여 우승자 찾기")
    void findWinnerFromTwoCarsTest() {
        // given
        List<Car> testCars = this.createTestCars(2);
        this.moveTestCars(testCars, 5, 2);

        // when
        Car car1 = testCars.get(0);
        Car car2 = testCars.get(1);
        Car winner = car1.findWinner(car2);

        // then
        Assertions.assertThat(winner).isEqualTo(car1);
    }

    @Test
    @DisplayName("자동차 3대의 이동거리를 비교하여 단독 우승자 찾기")
    void findSoloWinnerTest() {
        // given
        List<Car> testCars = this.createTestCars(3);
        this.moveTestCars(testCars, 9, 3, 0);
        Cars cars = Cars.from(testCars);

        // when
        List<Car> winners = cars.findWinners();

        // then
        Assertions.assertThat(winners).hasSize(1);
        Assertions.assertThat(winners.get(0)).isEqualTo(testCars.get(0));
    }

    @Test
    @DisplayName("자동차 3대의 이동거리를 비교하여 공동 우승자 찾기")
    void findCowinnerTest() {
        // given
        List<Car> testCars = this.createTestCars(3);
        this.moveTestCars(testCars, 9, 9, 0);
        Cars cars = Cars.from(testCars);

        // when
        List<Car> winners = cars.findWinners();

        // then
        Assertions.assertThat(winners).hasSize(2);
        Assertions.assertThat(winners.get(0)).isEqualTo(testCars.get(0));
        Assertions.assertThat(winners.get(1)).isEqualTo(testCars.get(1));
    }

    @Test
    @DisplayName("자동차 1대일 때 우승자 찾기")
    void findWinnerFromOneCarTest() {
        // given
        List<Car> testCars = this.createTestCars(1);
        this.moveTestCars(testCars, 4);
        Cars cars = Cars.from(testCars);

        // when
        List<Car> winners = cars.findWinners();

        // then
        Assertions.assertThat(winners).hasSize(1);
        Assertions.assertThat(winners.get(0)).isEqualTo(testCars.get(0));
    }

    @Test
    @DisplayName("자동차가 없는 Cars 객체 생성 시 예외 발생")
    void emptyCarsExceptionTest() {
        Assertions.assertThatThrownBy(() -> Cars.from(new ArrayList<>()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith(ExceptionMessage.INVALID_CAR_SIZE);
    }

    private List<Car> createTestCars(int size) {
        List<Car> testCars = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            testCars.add(Car.from("car" + i + 1));
        }
        return testCars;
    }

    private void moveTestCars(List<Car> testCars, int... fuels) {
        for (int i = 0; i < testCars.size(); i++) {
            Car testCar = testCars.get(i);
            testCar.move(fuels[i]);
        }
    }
}
