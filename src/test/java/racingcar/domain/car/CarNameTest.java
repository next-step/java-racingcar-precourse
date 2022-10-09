package racingcar.domain.car;

import org.junit.jupiter.api.Test;
import racingcar.domain.car.CarName;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarNameTest {

    @Test
    void 등록된_이름을_준다() {
        CarName carName = new CarName("하하핳");
        String actualName = carName.get();
        assertThat(actualName).isEqualTo("하하핳");
        assertThat(actualName).isNotEqualTo("하하핳핳흐");
    }

    @Test
    void 등록되는_이름은_5자_이하만_가능하다() {
        assertDoesNotThrow(() -> {
            CarName carName = new CarName("나으행복나");
        });

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            CarName carName = new CarName("나으행복나으");
        });

        assertThat(exception.getMessage()).isEqualTo("[ERROR] 자동차에 등록되는 이름은 5자 이하만 가능합니다.");
    }
}
