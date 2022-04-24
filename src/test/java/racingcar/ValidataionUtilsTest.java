package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ValidataionUtilsTest {
    @DisplayName("경주게임_경기횟수_검증_통과")
    @ParameterizedTest
    @CsvSource({"1", "2", "3", "4", "1000", "2000"})
    void validPlayGameCntReturnTrue_P01(String inputPlayCnt) {
        assertThat(ValidataionUtils.validPlayGameCnt(inputPlayCnt)).isTrue();
    }

    @DisplayName("경주게임_경기횟수_검증_숫자범위_벗어남_실패")
    @ParameterizedTest
    @CsvSource({"-1", "0"})
    void validPlayGameCntThrowException_N01(String inputPlayCnt) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> ValidataionUtils.validPlayGameCnt(inputPlayCnt));
    }

    @DisplayName("경주게임_경기횟수_검증_숫자아님_실패")
    @ParameterizedTest
    @CsvSource({"aa", "하이", "숫자아님"})
    void validPlayGameCntThrowException_N02(String inputPlayCnt) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> ValidataionUtils.validPlayGameCnt(inputPlayCnt));
    }
}
