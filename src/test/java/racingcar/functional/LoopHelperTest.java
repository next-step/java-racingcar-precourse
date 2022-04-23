package racingcar.functional;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;

class LoopHelperTest {

    @Test
    void function_helper_list_forEach_기능_테스트() {
        List<Integer> original = Arrays.asList(1, 2, 3, 4, 5);
        AtomicInteger index = new AtomicInteger();

        LoopHelper.listForEach(original, (value) -> {
            assertThat(value).isEqualTo(original.get(index.getAndIncrement()));
        });
    }

    @Test
    void function_helper_list_map_기능_테스트() {
        int index = 0;
        List<Integer> original = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> doubleMapResult = LoopHelper.listMap(original, (value) -> value * 2);

        for (Integer value: original) {
            assertThat(value * 2).isEqualTo(doubleMapResult.get(index++));
        }
    }

    @Test
    void function_helper_list_filter_기능_테스트() {
        List<Integer> original = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> filterResult = LoopHelper.listFilter(original, (value) -> value % 2 == 0);

        assertThat(filterResult).containsAll(Arrays.asList(2, 4));
    }

    @Test
    void function_helper_max_value_in_integer_list_기능_테스트() {
        List<Integer> original = Arrays.asList(1, 5, 8, 1, 3);

        Integer max = LoopHelper.maxValueInIntegerList(original);

        assertThat(max).isEqualTo(8);
    }
}