package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarNameTest {

    @Test
    void 자동차_이름을_잘꺼내오는지_테스트() {

        // given when
        CarName carName = new CarName("pobi");

        // then
        assertThat(carName.getName()).isEqualTo("pobi");
    }

    @Test
    void 자동차_이름_같으면_같은객체이다() {

        // given, when
        CarName carName = new CarName("pobi");

        // then
        assertThat(new CarName("pobi")).isEqualTo(carName);
    }
}
