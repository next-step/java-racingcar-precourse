package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomUtilsTest {
    @DisplayName("랜덤 함수가 0~9까지 나오는지 테스트")
    @Test
    public void getRandomNumberReturnZeroBetweenNine(){
        assertThat(RandomUtils.getRandomNumber()).isBetween(0,9);
    }
}
