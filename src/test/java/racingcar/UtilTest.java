package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.utils.RacingCarStringUtils;

public class UtilTest {

    @Test
    void 숫자형식테스트() {
        Assertions.assertThat(RacingCarStringUtils.isNumberFormat("3")).isTrue();
    }

    @Test
    void 숫자형식_예외_테스트() {
        Assertions.assertThat(RacingCarStringUtils.isNumberFormat("ee")).isFalse();
    }

    @Test
    void 중복문자테스트() {
        Assertions.assertThat(RacingCarStringUtils.isDuplicate(new String[]{"aa","aa","bb"})).isTrue();
    }

    @Test
    void 중복문자_예외_테스트() {
        Assertions.assertThat(RacingCarStringUtils.isDuplicate(new String[]{"aa","aaa","aaaa"})).isFalse();
    }


    @Test
    void 최대길이제한_테스트() {
        Assertions.assertThat(RacingCarStringUtils.underMaxLength("aaa",3)).isTrue();
    }

    @Test
    void 최대길이제한_예외_테스트() {
        Assertions.assertThat(RacingCarStringUtils.underMaxLength("aaa",2)).isFalse();
    }

    @Test
    void 빈문자열_테스트() {
        Assertions.assertThat(RacingCarStringUtils.isEmpty("aaa")).isFalse();
    }

    @Test
    void 빈문자열_예외_테스트() {
        Assertions.assertThat(RacingCarStringUtils.isEmpty("")).isTrue();
    }
}
