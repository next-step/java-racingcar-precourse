package racingcar.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class IntRangeTest {
    @Test
    @DisplayName("IntRange() 10개짜리")
    void IntRange_NewIntRangeWith1To10_SizeOfIntRange_10() {
        List<Integer> range = new IntRange(1, 10).map(Integer::new);

        assertThat(range.size()).isEqualTo(10);
    }

    @Test
    @DisplayName("IntRange() 1개짜리")
    void IntRange_NewIntRangeWith1_SizeOfIntRange_1() {
        List<Integer> range = new IntRange(1).map(Integer::new);

        assertThat(range.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("IntRange() 0을 넘기면 비어있음")
    void IntRange_NewIntRangeWith0_SizeOfIntRange_0() {
        List<Integer> range = new IntRange(0).map(Integer::new);

        assertThat(range.size()).isEqualTo(0);
    }

    @Test
    @DisplayName("IntRange() 음수를 넘기면 비어있음")
    void IntRange_NewIntRangeWithNegative_SizeOfIntRange_0() {
        List<Integer> range = new IntRange(-1).map(Integer::new);

        assertThat(range.size()).isEqualTo(0);
    }

    @Test
    @DisplayName("IntRange() -2,-1을 넘기면 2개짜리")
    void IntRange_NewIntRangeWith1ToMinus2ToMinus1_SizeOfIntRange_2() {
        List<Integer> range = new IntRange(-2, -1).map(Integer::new);

        assertThat(range.size()).isEqualTo(2);
    }
}
