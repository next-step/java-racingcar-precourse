package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NamesTest {

    @DisplayName(",로 나뉘어진 문자열로 Name을 한번에 추가할 수 있다")
    @ParameterizedTest
    @ValueSource(strings = {"miz,marty,kk", "abc,cde,123"})
    void createNamesTest(String input) {
        String[] split = input.split(",");
        List<Name> expect = new ArrayList<>();
        for (String s : split) {
            expect.add(Name.from(s));
        }

        Names actual = Names.from(input);

        assertThat(actual).isEqualTo(Names.from(expect));
    }

}