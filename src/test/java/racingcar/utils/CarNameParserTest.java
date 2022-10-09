package racingcar.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.CarName;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CarNameParserTest {

    @Test
    void 이름_Parser_테스트(){
        String carNameStr = "dong,kim,bro";
        String[] names = CarNameParser.parseCarName(carNameStr);

        Assertions.assertThat(names.length).isEqualTo(3);
    }

    @Test
    void 차_이름_길이_예외_테스트(){
        assertThatIllegalArgumentException().isThrownBy(
                () -> CarNameParser.validateCarNameSize("dongHa")
        );
    }

    @Test
    void 띄어쓰기_예외_테스트(){
        assertThatIllegalArgumentException().isThrownBy(
                () -> CarNameParser.validateBlankInCarName("dong ")
        );
    }
}
