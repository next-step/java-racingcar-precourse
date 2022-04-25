package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static org.assertj.core.api.Assertions.*;

@DisplayName("차량 이름 테스트")
public class CarNameTest {

    CarName carName = new CarName();

    @ParameterizedTest
    @ValueSource(strings = {"kaman123"})
    @DisplayName("차량 이름 " + CarName.NAME_LENGTH_LIMIT + "글자 초과인지 테스트")
    void carName_Length(String s) {
        assertThatThrownBy(() -> {
            carName.isCarNameUpperLength(s);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }


}
