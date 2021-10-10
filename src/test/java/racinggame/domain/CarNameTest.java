package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CarNameTest {

    @Test
    @DisplayName("자동차 이름 입력 테스트")
    public void input_car_name_test() {
        //given
        String input = "pobi";

        //when
        CarName carName = new CarName(input);

        //then
        assertThat(carName.getCarName()).isEqualTo(input);
    }

    @Test
    @DisplayName("유효하지 않은 자동차 이름 입력 테스트")
    public void invalid_input_car_name_test() {
        //given
        String input = "invalidName";

        //when
        assertThatIllegalArgumentException().isThrownBy(() -> new CarName(input))
                .withMessage("[ERROR] 자동차 이름은 1글자 이상, 5글자 이하만 가능합니다.");
    }
}
