import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TrialCountTest {

    @ParameterizedTest
    @CsvSource(value = {"12:12", "1234:1234", "43:43", "5:5", "23:23"}, delimiter = ':')
    @DisplayName("사용자가 정상적인 시도 횟수를 입력할 경우 TrialCount 객체에 입력값을 보관한다.")
    void store_when_user_input_trial_count_is_valid(String trialCntInput, int trialCount) {
        Assertions.assertThat(new TrialCount(trialCntInput).getTrialCount()).isEqualTo(trialCount);
        Assertions.assertThatNoException()
                .isThrownBy(() -> new TrialCount(trialCntInput));
    }

    @ParameterizedTest
    @CsvSource(value = {"!2", "432Zv", "333Ab", "_22"})
    @DisplayName("사용자가 비정상적인 시도 횟수를 입력할 경우 NumberFormatException 예외를 던진다.")
    void throw_number_format_exception_when_user_input_trial_count_is_invalid(String trialCntInput) {
        Assertions.assertThatExceptionOfType(NumberFormatException.class)
                .isThrownBy(() -> new TrialCount(trialCntInput));
    }
}
