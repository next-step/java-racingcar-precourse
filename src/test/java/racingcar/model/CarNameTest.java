package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CarNameTest {
    @DisplayName("자동차를 생성할 때, 자동차 이름 등록이 성공한다.")
    @Test
    void setCarNameSuccess_P01() {
        String test = "test1";
        CarName carName = new CarName(test);
        assertThat(carName.getName()).isEqualTo(test);
    }

    @DisplayName("자동차 이름으로 길이가 6이상 값이 들어오면 에러를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"하이브리드1,하이브리드", "하이브리드,번개44444444,번개3", "hi,,hihi"}, delimiter = ':')
    void validCarNameThrowException_N01(String inputName) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new CarName(inputName));
    }

    @DisplayName("자동차 이름으로 빈 값이 들어오면 에러를 반환한다.")
    @Test
    void validCarNameThrowException_N02() {
        String inputName = "";
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new CarName(inputName));
    }

}
