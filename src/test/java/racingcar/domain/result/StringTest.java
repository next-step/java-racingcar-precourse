package racingcar.domain.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    @DisplayName("공동우승자_toString_테스트")
    void toStringTest() {
        List<String> names = Arrays.asList(new String[]{"Jin","Park","Kim"});
        WinNames winNames = new WinNames(names);
        assertThat(winNames.toString()).isEqualTo("Jin, Park, Kim");
    }
}
