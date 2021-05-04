package racingcar.domain;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.CarsException;
import racingcar.exception.NameException;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.domain.constant.RacingCarConstant.SEPARATOR;

@DisplayName("자동차 목록 도메인 테스트")
class CarsTest {

    @ParameterizedTest(name = "자동차 목록 생성")
    @ValueSource(strings = {"car1,car2,car3", "car1, ,car3", "car1", " ,car2"})
    void 자동차_목록_생성(String input) {
        // when
        Cars cars = new Cars(input.split(SEPARATOR));
        // then
        assertThat(cars.getSize()).isEqualTo(input.split(SEPARATOR).length);
    }

    @DisplayName("자동차 0개 입력시 예외발생")
    @Test
    void 자동차_0개_입력시_예외발생() {
        // when + then
        assertThatThrownBy(() -> new Cars(null)).isInstanceOf(CarsException.InvalidCountException.class);
    }

    @ParameterizedTest(name = "자동차 이름 중복 입력시 예외발생")
    @ValueSource(strings = {"car1,car1,car3", " , ,car3"})
    void 자동차_이름_중복_예외발생(String input) {
        // when + then
        assertThatThrownBy(() -> new Cars(input.split(SEPARATOR))).isInstanceOf(NameException.DuplicateException.class);
    }

    @DisplayName("우승한 자동차 목록 조회")
    @Test
    void 우승한_자동차_목록_조회() {
        // given
        Cars cars = new Cars("car1,car2,car3,car4".split(SEPARATOR));
        Car car1 = cars.getCars().get(0);
        Car car2 = cars.getCars().get(1);
        Car car3 = cars.getCars().get(2);
        Car car4 = cars.getCars().get(3);

        car1.move(new Distance(1));
        car2.move(new Distance(7));
        car3.move(new Distance(2));
        car4.move(new Distance(7));

        // when
        List<Car> winners = cars.getWinners();

        // then
        assertThat(winners).containsExactly(Arrays.array(car2, car4));
    }

}