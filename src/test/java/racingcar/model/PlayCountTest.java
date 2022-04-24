package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PlayCountTest {
    PlayCountRule playCountRule;

    @BeforeEach
    void set() {
        playCountRule = new PlayCountRule(0, 9);
    }

    @DisplayName("게임 횟수를 생성할 때, 포지션 값 등록이 성공한다.")
    @ParameterizedTest
    @CsvSource(value = {"1", "2", "3", "0", "9"}, delimiter = ':')
    void createPlayCountSuccess_P01(String inputValue) {
        PlayCount playCount = new PlayCount(inputValue, playCountRule);
        assertThat(playCount.getPlayCount()).isEqualTo(Integer.parseInt(inputValue));
    }

    @DisplayName("포지션에 값을 추가할 때, 규칙에서 정한 범위가 아닐경우, 에러를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"-1", "10", "aa", "b", "10000"}, delimiter = ':')
    void createPlayCountError_N01(String inputValue) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new PlayCount(inputValue, playCountRule));
    }
}
