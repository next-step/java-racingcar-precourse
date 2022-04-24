package racingcar.missionutil;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PickNumberInRangeTest {

    @DisplayName("pickNumberInRange - 난수 범위 테스트")
    @Test
    void pickNumberInRangeTest() {
        //given:
        int number;
        //then:
        number = Randoms.pickNumberInRange(10, 20);
        //then:
        assertThat(number)
                .isGreaterThan(9)
                .isLessThan(21);
    }

    @DisplayName("pickNumberInRange - 3개의 난수 생성 테스트")
    @Test
    void pickNumberInRangeListTest() {
        //given:
        List<Integer> numberList;
        //when:
        numberList = Arrays.asList(
                Randoms.pickNumberInRange(1, 9)
                , Randoms.pickNumberInRange(1, 9)
                , Randoms.pickNumberInRange(1, 9));
        //then:
        assertThat(numberList)
                .containsAnyOf(1, 2, 3, 4, 5, 6, 7, 8, 9);
    }
}
