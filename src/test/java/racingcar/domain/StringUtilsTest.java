package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StringUtilsTest {
    @DisplayName("StringUtils split 테스트")
    @ParameterizedTest
    @CsvSource(value = {"a,22,123:3", ",1,:2", ",:0", "ab,:1", ".,.,.,.,.,.:6"}, delimiter = ':')
    void splitTest(String carNameList, int expect) {
        String[] carNames = StringUtils.splitByComma(carNameList);
        assertThat(carNames).hasSize(expect);
    }

    @DisplayName("StringUtils join 테스트")
    @Test
    void joinTest() {
        List<String> texts = new ArrayList<>();
        texts.add("pobi");
        texts.add("crong");
        String text = StringUtils.joinByComma(texts);
        assertThat(text).isEqualTo("pobi,crong");
    }
}
