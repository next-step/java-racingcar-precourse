package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarsTest {
    private static final String CAR_NAMES = "빨강,주황,노랑,초록";
    private static final String DIFF_CAR_NAMES = "빨강,노랑,주황,초록";

    List<Car> cars = new ArrayList<>();

    @BeforeEach
    void setUp() {
        cars.add(new Car("빨강"));
        cars.add(new Car("주황"));
        cars.add(new Car("노랑"));
        cars.add(new Car("초록"));
    }

    @DisplayName("자동차들 비교 테스트")
    @Test
    void carsEqualTest() {
        Cars inputCars = Cars.addCarListByStringCarNames(CAR_NAMES);
        Cars expectedCars = Cars.addCarList(this.cars);
        assertThat(inputCars).isEqualTo(expectedCars);
    }

    @DisplayName("자동차들 다름 테스트")
    @Test
    void carsNotEqualTest() {
        Cars inputCars = Cars.addCarListByStringCarNames(DIFF_CAR_NAMES);
        Cars expectedCars = Cars.addCarList(this.cars);
        assertThat(inputCars).isNotEqualTo(expectedCars);
    }

    @DisplayName("자동차들 사이즈 테스트")
    @Test
    void carsSizeTest() {
        Cars inputCars = Cars.addCarListByStringCarNames(CAR_NAMES);
        assertThat(inputCars.size()).isEqualTo(4);
    }

    @DisplayName("자동차들 입력 유효성 검사")
    @ParameterizedTest
    @ValueSource(strings = {"", "빨강,,노랑", ",주황,노랑", ",,"})
    void carsNameInvalidTest(String carNames) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Cars.addCarListByStringCarNames(carNames));
    }

    @DisplayName("자동차들 최종 우승자 테스트")
    @Test
    void carsTest() {
        cars.get(0).advance();
        cars.get(2).advance();
        Cars testCars = Cars.addCarList(this.cars);
        assertThat(testCars.getWinnerName()).isEqualTo("빨강,노랑");
    }
}
