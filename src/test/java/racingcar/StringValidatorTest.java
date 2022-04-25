package racingcar;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.utils.StringValidator;

public class StringValidatorTest {

    @ParameterizedTest
    @CsvSource(value = {"pobi,jason", "pobi", "pobi,jason,racer"}, delimiter = ':')
    public void 자동차_이름들은_중복이_없으며_쉼표로_구분된다(String input) {
        // given & when
        boolean result = StringValidator.isValidCarInput(input);

        // then
        Assertions.assertThat(result).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"racing,car,celina", "race,jason2,run", "car,race,moving"}, delimiter = ':')
    public void 자동차_이름이_하나이상_5글자_이상인_경우_실패를_반환한다(String input) {
        // given & when & then
        assertThatIllegalArgumentException().isThrownBy(
                () -> StringValidator.validCarListCheck(Arrays.asList(input.split(",", -1))));
    }

    @ParameterizedTest
    @CsvSource(value = {"jason,", ",jason", "jason,,pobi"}, delimiter = ':')
    public void 자동차_이름이_하나이상_공백인_경우_실패를_반환한다(String input) {
        // given & when & then
        assertThatIllegalArgumentException().isThrownBy(
                () -> StringValidator.validCarListCheck(Arrays.asList(input.split(",", -1))));
    }

    @ParameterizedTest
    @CsvSource(value = {"pobi,pobi,jason", "jason,pobi,jason", "jason,pobi,pobi"}, delimiter = ':')
    public void 자동차_이름이_중복되는_경우_실패를_반환한다(String input) {
        // given & when & then
        assertThatIllegalArgumentException().isThrownBy(
                () -> StringValidator.duplicateCarListCheck(Arrays.asList(input.split(",", -1))));
    }
}
