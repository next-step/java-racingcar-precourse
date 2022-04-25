package racingcar.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.utils.TestCarsUtils.testCarList;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.game.InputCarNames;
import racingcar.racing.RoundResults;
import racingcar.utils.TestCarsUtils;

class CarsTest {

    @Test
    @DisplayName("자동차s 생성 성공 테스트")
    void init() {
        // given

        // when
        final Cars cars = Cars.init();

        // then
        assertThat(cars.countCars()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차s 사용자 입력값으로 생성 성공 테스트")
    void valueOf() {
        // given
        final InputCarNames inputCarNames = TestCarsUtils.testInputCarNames();

        // when
        final Cars cars = Cars.valueOf(inputCarNames);

        // then
        assertThat(cars.countCars()).isEqualTo(inputCarNames.count());
    }

    @Test
    @DisplayName("자동차s 사용자 입력값으로 생성 실패 테스트")
    void valueOf_exception() {
        // given

        // when & then
        assertThatThrownBy(() -> Cars.valueOf(null))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName("리스트로 생성 성공 테스트")
    void of() {
        // given
        List<Car> carList = testCarList();

        // when
        final Cars cars = Cars.of(carList);

        // then
        assertThat(cars.countCars()).isEqualTo(carList.size());

    }

    @Test
    @DisplayName("빈 리스트로 생성 실패 테스트")
    void of_exception() {
        // given

        // when & then
        assertThatThrownBy(() -> Cars.of(new ArrayList<>()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 경주 테스트")
    void goOrStopAll() {
        // given
        final Cars cars = Cars.of(testCarList());

        // when
        final RoundResults roundResults = cars.goOrStopAll();

        // then
        assertThat(roundResults.getRoundResults().size()).isEqualTo(cars.countCars());
    }

    @Test
    @DisplayName("자동차 추가 성공 테스트")
    void addCar() {
        // given
        final Cars cars = Cars.of(testCarList());
        final int oldCount = cars.countCars();

        // when
        final Car newCar = Car.of(CarName.of("new"));
        cars.addCar(newCar);

        // then
        assertThat(cars.countCars()).isEqualTo(oldCount + 1);
    }

}