package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarNameSplitTest {

    @ParameterizedTest
    @ValueSource(strings = {"ab%dfe", "hrh@fef^sfeg", "hrr_frgeg"})
    void 자동차이름_구분자_체크(String inputValue) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new CarNameSplit(inputValue);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"ab,한글", "자동차1,한글", "자동차a,한글"})
    void 자동차이름_영문_체크(String inputValue) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new CarNameSplit(inputValue);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"ab,cd,ef", "eee,ff,gg", "fef,brrgh"})
    void 자동차이름_정상_분리(String inputValue) {
        assertEquals(new CarNameSplit(inputValue).getCarNames().size(), inputValue.split(",").length);
    }
}
