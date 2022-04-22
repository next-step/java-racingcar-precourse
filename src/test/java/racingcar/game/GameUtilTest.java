package racingcar.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.game.car.CarName;
import racingcar.game.car.CarNames;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameUtilTest {
    @Test
    @DisplayName("repeatString() 3과 문자열을 넘기면, 문자열이 3번 반복")
    void repeatString_Pass3AndString_StringRepeated3Times() {
        String s = GameUtil.repeatString(3, "a");

        assertThat(s).isEqualTo("aaa");
    }

    @Test
    @DisplayName("parseCarNames() a,b,c를 넘기면, CarNames의 사이즈가 3이고 a,b,c 각각의 CarName이 만들어 짐")
    void parseCarNames_PassACommaBCommaC_SizeOfCarNames_3() {
        CarNames carNames = GameUtil.parseCarNames("a,b,c");
        List<String> names = carNames.map(CarName::get);

        assertThat(carNames.size()).isEqualTo(3);
        assertThat(names.get(0)).isEqualTo("a");
        assertThat(names.get(1)).isEqualTo("b");
        assertThat(names.get(2)).isEqualTo("c");
    }
}
