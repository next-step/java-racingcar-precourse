package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberUtilsTest {


    @RepeatedTest(200)
    @DisplayName("레이싱_숫자_범위검증_0_9")
    void 레이싱_자동차_랜덤_숫자() {


        assertThat(NumberUtils.create(0, 9))
                .isGreaterThan(-1)
                .isLessThan(10);

    }

    @Test
    @DisplayName("레이싱_숫자_생성시_입력값의_시작값이_더_큰경우_유효검증")
    void 레이싱_자동차_랜덤_숫자_생성_입력값_유효검증() {

        assertThatThrownBy(() -> {
            NumberUtils.create(10, 9);
        })
                .isInstanceOf(IllegalArgumentException.class);


    }

}
