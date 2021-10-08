package racinggame.utils;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static racinggame.utils.RacingGameUtils.*;

public class RacingGameUtilsTest {

    @ParameterizedTest(name = "자동차 이름 [{0}] 쉼표 기준으로 구분하면 배열 사이즈는 {1} 이다")
    @CsvSource(value = {  "pobi,crong,honux:3"
                        , "pobi,crong,honux,elice:4"
                        , "pobi,crong,honux,elice,mark:5" }
                        , delimiter = ':')
    void 입력받은_자동차_이름을_쉼표_기준으로_구분한다(String racingCarNameInput, int lengthInput) {
        assertThat(racingCarNameSplit(racingCarNameInput).length).isEqualTo(lengthInput);
    }

    @ParameterizedTest(name = "자동차 이름 [{0}] 길이가 5자 초과면 False 이다")
    @ValueSource(strings = {  "javaji,javamaster"
                            , "abraham,aaliyah" })
    void 쉼표_기준으로_구분한_자동차_이름의_길이가_5자_초과_False(String racingCarNameInput) {
        for (String racingCarName : racingCarNameSplit(racingCarNameInput)) {
            assertThat(isValidRacingCarNameLength(racingCarName)).isFalse();
        }
    }

    @ParameterizedTest(name = "자동차 이름 [{0}] 길이가 5자 이하면 True 이다")
    @ValueSource(strings = {  "pobi,crong,honux"
                            , "raham,liyah" })
    void 쉼표_기준으로_구분한_자동차_이름의_길이가_5자_이하_True(String racingCarNameInput) {
        for (String racingCarName : racingCarNameSplit(racingCarNameInput)) {
            assertThat(isValidRacingCarNameLength(racingCarName)).isTrue();
        }
    }

    @ParameterizedTest(name = "자동차 이름 [{0}] 공백을 제거한다")
    @CsvSource(value = {  "pobi ,crong ,honux :pobi,crong,honux"
                        , " pobi, crong, honux:pobi,crong,honux"
                        , " pobi , crong , honux :pobi,crong,honux" }
                        , delimiter = ':')
    void 쉼표_기준으로_구분한_자동차_이름의_앞뒤_공백을_제거한다(String before, String after) {
        String[] beforeNames = trim(racingCarNameSplit(before));
        String[] afterNames = racingCarNameSplit(after);

        for (int i = 0; i < beforeNames.length; i++) {
            assertThat(beforeNames[i]).isEqualTo(afterNames[i]);
        }
    }

}
