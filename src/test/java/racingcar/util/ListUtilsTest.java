package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ListUtilsTest {

    @DisplayName("입력 리스트에 mapper 함수를 적용한 결과 리스트를 반환한다.")
    @Test
    void mapTest() {
        final List<Integer> source = Arrays.asList(1, 2, 3);
        final List<String> result = ListUtils.map(source, String::valueOf);
        assertThat(result).containsExactly("1", "2", "3");
    }

    @DisplayName("predicate 함수를 만족하는 필터링 된 결과 리스트를 반환한다.")
    @Test
    void filterTest() {
        final List<String> source = Arrays.asList("a", "a", "b", "c");
        final List<String> result = ListUtils.filter(source, "a"::equals);
        assertThat(result).containsExactly("a", "a");
    }
}