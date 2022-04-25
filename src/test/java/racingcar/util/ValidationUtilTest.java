package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by victorsung.
 * Date: 2022/04/25
 * Time: 8:29 PM
 */
public class ValidationUtilTest {

    @Test
    @DisplayName("")
    void test_pickNumberInRange(){
    	// given
        for (int j = 0; j < 1000; j++) {
            int i = pickNumberInRange(0, 9);
            System.out.println("i = " + i);
        }
        // when

    	// then

    }

    @Test
    @DisplayName("숫자 validation")
    void 숫자_1_9_까지_validation(){
        // given

        // when

        // then
        assertThat(ValidationUtil.checkNo(9)).isTrue();
        assertThat(ValidationUtil.checkNo(1)).isTrue();
        assertThat(ValidationUtil.checkNo(0)).isTrue();
        assertThat(ValidationUtil.checkNo(10)).isFalse();
    }

    @Test
    @DisplayName("이름 validation")
    void 이름_validation(){
        // given

        // when

        // then
        assertThat(ValidationUtil.checkName("안녕하세요")).isTrue();
        assertThat(ValidationUtil.checkName("안녕")).isTrue();
        assertThat(ValidationUtil.checkName("안녕하세")).isTrue();
        assertThat(ValidationUtil.checkName("안녕하세요요")).isFalse();
    }

}
