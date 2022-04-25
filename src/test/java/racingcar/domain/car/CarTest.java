package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarTest {
    @Test
    @DisplayName("자동차_한대_생성_테스트")
    void 자동차_한대_생성_테스트() {
        assertThat(new Car("Jin").getCarName().getName()).isEqualTo("Jin");
    }

    @Test
    @DisplayName("자동차_이름_overSize_IllegalArgument_테스트")
    void 자동차_이름_overSize_테스트() {
        String input = "Jin,Park,Yongae";
        assertThrows(IllegalArgumentException.class, () -> {
            new Car(input);
        });
    }
    @Test
    @DisplayName("자동차_이름_wrong_Delimiter_IllegalArgument_테스트")
    void 자동차_이름_wrong_Delimiter_테스트() {
        String input = "Jin/Park/Yong";
        assertThrows(IllegalArgumentException.class, () -> {
            new Car(input);
        });
    }
}
