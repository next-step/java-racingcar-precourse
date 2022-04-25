package racingcar.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DelimiterTest {

    @Test
    void 입력시_차_이름_분리_테스트() {
        String name = "kia,oaudi";

        List<CarName> carNames = Delimiter.separateCarName(name);

        assertThat(carNames.get(0).getName()).isEqualTo("kia");
        assertThat(carNames.get(1).getName()).isEqualTo("oaudi");
    }
}