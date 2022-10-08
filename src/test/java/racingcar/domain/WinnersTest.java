package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WinnersTest {
    private final List<CarName> winnerCarNames = new ArrayList<>();

    @BeforeEach
    void setUp() {
        winnerCarNames.add(new CarName("pobi"));
    }

    @Test
    void Winners_생성_테스트() {
        assertThatCode(() -> new Winners(winnerCarNames)).doesNotThrowAnyException();
    }

    @Test
    void 우승자가_한_명일_경우_쉼표로_구분하지_않는다() {
        assertThat(new Winners(winnerCarNames).toString()).contains("pobi");
    }

    @Test
    void 우승자가_여러명_일_경우_쉼표로_구분한다() {
        winnerCarNames.add(new CarName("sun"));
        assertThat(new Winners(winnerCarNames).toString()).contains("pobi, sun");
    }

}