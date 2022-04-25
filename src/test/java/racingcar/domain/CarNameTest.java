package racingcar.domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.InvalidParameterError;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("CarName 클래스 테스트 시작")
public class CarNameTest {
    @Test
    @DisplayName("carName이 'eunji'로 유효할 경우 통과")
    public void checkCarName() {
        assertThat(new CarName("eunji").getCarName()).isEqualTo("eunji");
    }

    @Test
    @DisplayName("carName이 1~5 글자가 아닐 경우 오류 발생")
    public void checkCarNameLength() {
        assertThatThrownBy(()-> {
            new CarName("");
        }).isInstanceOf(InvalidParameterError.class).hasMessageContaining("[ERROR] 자동차 이름은 1~5글자만 입력할 수 있습니다.");

        assertThatThrownBy(()-> {
            new CarName("naeunji");
        }).isInstanceOf(InvalidParameterError.class).hasMessageContaining("[ERROR] 자동차 이름은 1~5글자만 입력할 수 있습니다.");
    }

    @Test
    @DisplayName("carName에 알파벳+숫자 외 다른 문자가 입력되었을 경우 오류 발생")
    public void checkCarNameFormat() {
        assertThatThrownBy(()-> {
            new CarName("na!");
        }).isInstanceOf(InvalidParameterError.class).hasMessageContaining("[ERROR] 자동차 이름은 알파벳과 숫자만 입력할 수 있습니다.");

        assertThatThrownBy(()-> {
            new CarName("n a");
        }).isInstanceOf(InvalidParameterError.class).hasMessageContaining("[ERROR] 자동차 이름은 알파벳과 숫자만 입력할 수 있습니다.");
    }
}
