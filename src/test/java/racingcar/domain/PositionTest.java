package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PositionTest {
    @DisplayName("생성_테스트")
    @Test
    void 생성_테스트() {
        Position position = new Position(1);
        assertThat(position).isEqualTo(new Position(1));
    }

    @DisplayName("음수가_들어오면_에러")
    @Test
    void 음수가_들어오면_에러() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Position(-1));
    }

    @DisplayName("position간_크기_비교")
    @ParameterizedTest
    @CsvSource(value = {"2:1:true", "1:1:false", "1:2:false"}, delimiter = ':')
    void position간_크기_비교(int num, int otherNum, boolean result) {
        Position testPosition = new Position(num);
        Position otherPosition = new Position(otherNum);
        assertThat(testPosition.isBiggerPosition(otherPosition)).isEqualTo(result);
    }

    @DisplayName("position이_maxPosition인지_값을_반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:1:true", "1:2:false"}, delimiter = ':')
    void position이_maxPosition인지_값을_반환한다(int position, int maxPosition, boolean result) {
        Position testPosition = new Position(position);
        Position expectedPosition = new Position(maxPosition);
        assertThat(testPosition.isMaxPosition(expectedPosition)).isEqualTo(result);
    }

    @DisplayName("plus_함수_체크")
    @Test
    void plus_함수_체크() {
        Position position = new Position(0);
        position.plus(1);
        assertThat(position).isEqualTo(new Position(1));
    }
}
