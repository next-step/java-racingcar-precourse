package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Move;
import racingcar.model.RacingCars;
import racingcar.utils.CarGeneratorUtils;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    private RacingGame racingGame;
    private OutputStream captor;

    @BeforeEach
    void setUp() {
        final List<Car> cars = CarGeneratorUtils.getCars("이런,안돼,중복,한다");
        final RacingCars racingCars = new RacingCars(cars);
        final Move move = new Move("1");
        this.racingGame = new RacingGame(racingCars, move);
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @Test
    void 차수_별_실행했을_시_전진한_횟수만큼_대시를_출력한다() {
        racingGame.start();
        assertThat(output()).contains("이런");
        assertThat(output()).contains("안돼");
        assertThat(output()).contains("중복");
        assertThat(output()).contains("한다");
    }

    protected final String output() {
        return captor.toString().trim();
    }

}
