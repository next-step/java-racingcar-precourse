package racingcar.model.car;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.CarNameSplit;
import racingcar.model.GameRule;
import racingcar.model.TryCount;

public class CarsTest {

    private static final String INPUT_TRY_COUNT = "3";
    private GameRule gameRule;

    @BeforeEach
    void setUp() {
        gameRule = new GameRule(new TryCount(INPUT_TRY_COUNT));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "null"})
    void 입력_NULL(String inputValue) {
        assertThatIllegalArgumentException().isThrownBy(() ->
                new Cars(new CarNameSplit(inputValue)));
    }

    @ParameterizedTest
    @ValueSource(strings = {"ab,cd", "ef,fge"})
    void 정상_게임_실행(String inputValue) {
        Cars cars = new Cars(new CarNameSplit(inputValue));
        cars.runGame(gameRule);

    }
}
