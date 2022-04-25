package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarValidationTest {

    @DisplayName("경주에 참가하는 자동차는 2대 이상이다.")
    @Test
    void 경주에_참가하는_자동차는_2대이상이다() {

        // given when
        boolean moreThanTwoCar = CarValidation.validateCarName("pobi,hyang");

        // then
        assertThat(moreThanTwoCar).isTrue();
    }

    @DisplayName("경주에 참가하는 자동차는 1대이면 안된다.")
    @Test
    void 경주에_참가하는_자동차는_1대는_안된다() {

        // given, then
        assertThatThrownBy(() -> CarValidation.validateCarName("pobi,"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("경주에 참가하는 자동차의 이름에 공백이 있으면 안된다.")
    @Test
    void 경주에_참가하는_자동차의_이름은_공백이_있으면_안된다() {

        // given, then
        assertThatThrownBy(() -> CarValidation.validateCarName("pobi, Hyan"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("경주에 참가하는 자동차의 이름은 1자 이상 5자 이하이다")
    @Test
    void 경주에_참가하는_자동차의_이름은_1자_이상_5자_이하이다() {

        // given, then
        assertThatThrownBy(() -> CarValidation.validateCarName(",HyanA"))
                .isInstanceOf(IllegalArgumentException.class);

        // given when
        assertThatThrownBy(() -> CarValidation.validateCarName("pobi,HyangKeun"))
                .isInstanceOf(IllegalArgumentException.class);

    }

}