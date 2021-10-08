package racinggame.utils;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingGameUtilsTest {

    @ParameterizedTest(name = "자동차 이름 : {0} / 배열 사이즈 : {1}")
    @CsvSource(value = {  "pobi,crong,honux:3"
                        , "pobi,crong,honux,elice:4"
                        , "pobi,crong,honux,elice,mark:5" }
                        , delimiter = ':')
    void 입력받은_자동차_이름을_쉼표_기준으로_구분한다(String racingCarNameInput, int lengthInput) {
        String regex = ",";
        String[] racingCarNameSplit = RacingGameUtils.racingCarNameSplit(racingCarNameInput, regex);

        assertThat(racingCarNameSplit.length).isEqualTo(lengthInput);
    }
}
