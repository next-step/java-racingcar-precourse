package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CarNameTest {

    @Test
    void 차_이름_생성_테스트(){
        CarName dong = new CarName("dong");
        assertThat(dong).isNotNull();
    }
}
