package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.model.Name;

class NameTest {

    @ParameterizedTest
    @CsvSource({"a", "bc", "car", "pobi", "jason"})
    public void 자동차_이름은_1글자_이상_5글자_이하이다(String input) {
        // given & when
        Name name = new Name(input);

        // then
        assertThat(name.getName()).isEqualTo(input);
    }

    @ParameterizedTest
    @CsvSource({"jaason", "jasson1"})
    public void 자동차_이름이_5글자를_초과하면_오류가_발생한다(String input) {
        // given & when & then
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Name(input));
    }

    @Test
    public void 자동차_이름이_공백이면_오류가_발생한다() {
        // given & when & then
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Name(""));
    }
}