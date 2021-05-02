package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;
import static util.RandomUtil.getRandom;

class RandomUtilTest {

    @DisplayName("랜덤 숫자 생성 테스트")
    @RepeatedTest(5)
    void TEST_getRandom(){
        assertThat(getRandom()).isBetween(0,9);
        System.out.println(getRandom());
    }
}
