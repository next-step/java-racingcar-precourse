package nextstep.test.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.Enum.Error;
import racinggame.car.domain.CarName;
import racinggame.car.utils.CarsUtil;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsNameTest {
    @Test
    @DisplayName("자동차명_분리")
    void 자동차명_분리() {
        String[] result = CarsUtil.makeCarStringToAry("abc, dejf,test code ,hiro");
        assertThat(result).isEqualTo(new String[]{"abc", "dejf", "test code", "hiro"});
    }


    @Test
    @DisplayName("자동차_객체_테스트")
    void 자동차_객체_테스트_공백확인() {
        assertThatThrownBy(() -> new CarName("  "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Error.ERROR_MSG_CARNAME.getMsg());
    }

    @Test
    @DisplayName("자동차_객체_테스트")
    void 자동차_객체_테스트_길이초과() {
        assertThatThrownBy(() -> new CarName("abcdef"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Error.ERROR_MSG_CARNAME.getMsg());
    }

    @Test
    @DisplayName("자동차_객체_테스트")
    void 자동차_객체_테스트_정상() {
        assertThat("abcde").isEqualTo(new CarName("abcde").getName());
    }

}
