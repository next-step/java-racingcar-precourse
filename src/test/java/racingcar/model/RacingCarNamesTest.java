package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class RacingCarNamesTest {
    @DisplayName(value = "다섯자 초과 이름으로 자동차이름 생성")
    @ParameterizedTest
    @ValueSource(strings = {"아주긴이름의자동차,6글자자동차,메르세데스벤츠GLE클래스"})
    void 다섯자_초과_이름으로_자동차이름_생성(String carName) {
        assertThatThrownBy(() -> new RacingCarNames(carName)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName(value = "빈 값으로 자동차이름 생성")
    @ParameterizedTest
    @ValueSource(strings = {""})
    void 빈_값으로_자동차이름_생성(String carName) {
        assertThatThrownBy(() -> new RacingCarNames(carName)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName(value = "이름 1개로 자동차이름 생성")
    @ParameterizedTest
    @ValueSource(strings = {"car", "happy", "new", "람보르기니"})
    void 이름_1개로_자동차이름_생성(String carName) {
        assertThatThrownBy(() -> new RacingCarNames(carName)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName(value = "공백 포함한 자동차이름 생성")
    @ParameterizedTest
    @ValueSource(strings = {"람 보르기,BMW,벤 츠,소 나 타"})
    void 공백_포함한_자동차이름_생성(String carName) {
        assertThatThrownBy(() -> new RacingCarNames(carName)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName(value = "중복된 자동차이름 생성")
    @ParameterizedTest
    @ValueSource(strings = {"람보르기니,람보르기니", "car,car2,car2", "car3,car1,car2,car3"})
    void 중복된_자동차이름_생성(String carName) {
        assertThatThrownBy(() -> new RacingCarNames(carName)).isInstanceOf(IllegalArgumentException.class);
    }
}
