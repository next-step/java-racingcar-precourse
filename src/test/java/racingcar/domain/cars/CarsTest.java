package racingcar.domain.cars;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.car.Car;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @DisplayName("Cars 클래스는 n개의 Car를 가질 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 10})
    void carsTest01(int n) {
        Cars cars = new Cars();
        for (int i = 0; i < n; i++) {
            cars.add(new Car("" + i));
        }
        assertThat(cars.numberOfCar()).isEqualTo(n);
    }

    @DisplayName("Cars 클래스는 가지고 있는 Car들의 상태를 획득할 수 있다.")
    @Test
    void carsTest02() {
        Cars cars = new Cars();
        cars.add(new Car("pobi"));
        cars.add(new Car("woni"));
        cars.add(new Car("jun"));

        String carsToStatusString = cars.toStatusString();
        assertThat(carsToStatusString)
                .contains("pobi :")
                .contains("woni :")
                .contains("jun :");
    }

    @DisplayName("Cars 클래스는 가지고 있는 Car들을 움직일 수 있다.")
    @RepeatedTest(value = 100)
    void carsTest03() {
        Cars cars = new Cars();
        cars.add(new Car("pobi"));
        cars.add(new Car("woni"));
        cars.add(new Car("jun"));
        boolean atLeastMove = cars.move();
        String carsStatusFormString = cars.toStatusString();

        if (atLeastMove) {
            assertThat(carsStatusFormString).contains("-");
        } else {
            assertThat(carsStatusFormString).doesNotContain("-");
        }
    }

    @DisplayName("Cars 클래스 단독 우승자를 체크할 수 있다.")
    @RepeatedTest(value = 100)
    void carsTest04() {
        Cars cars = new Cars();
        Car winner = new Car("woni");
        cars.add(new Car("pobi"));
        cars.add(new Car("jun"));
        cars.add(winner);


        onlyOneMove(winner);

        WinnerCars winnerCars = cars.calcWinner();
        assertThat(winnerCars).isNotNull();
        assertThat(winnerCars.numberOfWinner()).isEqualTo(1);
        Assertions.assertThat(winnerCars.getWinnerCar(0)).isEqualTo(winner);
    }

    @DisplayName("Cars 클래스 공동 우승자를 체크할 수 있다.")
    @RepeatedTest(value = 100)
    void carsTest05() {
        Cars cars = new Cars();
        Car winner1 = new Car("woni");
        Car winner2 = new Car("jun");
        cars.add(new Car("pobi"));
        cars.add(winner1);
        cars.add(winner2);

        onlyOneMove(winner1);
        onlyOneMove(winner2);

        WinnerCars winnerCars = cars.calcWinner();
        assertThat(winnerCars).isNotNull();
        assertThat(winnerCars.numberOfWinner()).isEqualTo(2);
    }

    private void onlyOneMove(Car winner) {
        boolean onlyOneMove = false;
        for (int i = 0; i < 100 && !onlyOneMove; i++) {
            onlyOneMove = winner.move();
        }
    }
}