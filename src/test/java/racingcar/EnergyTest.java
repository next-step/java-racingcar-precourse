package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class EnergyTest {

    @DisplayName("Energy 는 int 값을 전달 받고 VO 객체이다.")
    @ParameterizedTest
    @CsvSource(value = {"0:0:True", "0:9:False"}, delimiter = ':')
    public void validTest(final int value, final int target, final boolean expectedResult) {
        assertThat(Objects.equals(new Energy(value),new Energy(target))).isEqualTo(expectedResult);
    }


    @DisplayName("Energy 는 서로 비교 할수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"1:9:true", "9:1:false"}, delimiter = ':')
    public void CompareEnergyTest(final int source, final int target, final boolean expectedResult) {
        assertThat(new Energy(source).compareTo(new Energy(target)) < 0).isEqualTo(expectedResult);
    }

    @DisplayName("Energy 를 비교할때 null 값인 경우 IllegalArgument Exception 이 발생한다.")
    @Test
    public void invalidTest() {
        assertThatThrownBy(() -> new Energy(1).compareTo(null))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
