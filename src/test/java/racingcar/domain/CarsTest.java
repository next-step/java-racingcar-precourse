package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.DuplicateNameException;
import racingcar.exception.InvalidNumberOfCarsExecption;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.domain.rule.RacingcarGameRule.SEPERATOR;

@DisplayName("자동차 목록 도메인 테스트")
class CarsTest {

    @ParameterizedTest(name = "자동차 목록 생성")
    @ValueSource(strings = {"car1,car2,car3", "car1, ,car3", "car1", " ,car2"})
    void 자동차_목록_생성(String input) {
        // when
        Cars cars = new Cars(input.split(SEPERATOR));
        // then
        assertThat(cars.getSize()).isEqualTo(input.split(SEPERATOR).length);
    }

    @DisplayName("자동차 0개 입력시 예외발생")
    @Test
    void 자동차_0개_입력시_예외발생() {
        // when + then
        assertThatThrownBy(() -> new Cars(null)).isInstanceOf(InvalidNumberOfCarsExecption.class);
    }

    @ParameterizedTest(name = "자동차 이름 중복 입력시 예외발생")
    @ValueSource(strings = {"car1,car1,car3", " , ,car3"})
    void 자동차_이름_중복_예외발생(String input) {
        // when + then
        assertThatThrownBy(() -> new Cars(input.split(SEPERATOR))).isInstanceOf(DuplicateNameException.class);
    }

}