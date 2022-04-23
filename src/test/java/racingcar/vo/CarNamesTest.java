package racingcar.vo;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class CarNamesTest {

    @DisplayName("자동차 이름의 길이가 1~5이하 인지 검증")
    @ParameterizedTest
    @ValueSource(strings = {"", "람보르기니79"})
    void validateCarNameLength(String carName) {
        List<String> carNameList = Collections.singletonList(carName);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new CarNames(carNameList))
                .withMessage("[ERROR] 자동차 이름은 길이 1~5 사이로 입력해주세요.");
    }


}