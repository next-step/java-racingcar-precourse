package racingcar.car;


import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarNameTest {

    @Test
    @DisplayName("자동차_이름_5자리_초과할_때_IllegalArgumentException_호출_테스트")
    public void 자동차_이름이_6자리일_때_IllegalArgumentException_발생() throws IllegalArgumentException {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new CarName("pobisi");
        });
        assertThat(exception.getMessage(), containsString("5자 이하만 가능합니다."));
    }

}
