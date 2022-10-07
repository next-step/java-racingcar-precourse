package racingcar.model.race;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.constant.Message;
import racingcar.model.car.Car;
import racingcar.model.race.wrap_variable.NumberOfAttemptMove;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RaceTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setup() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void 우승_Car_결과() {
        Race race = new Race();

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Messi", 5));
        cars.add(new Car("Son", 7));
        cars.add(new Car("Salah", 3));

        race.raceResult(cars);
        assertThat(outputStreamCaptor.toString()).contains(Message.FINAL_WINNER + "Son");
    }

    @Test
    void 공동우승_Car_결과() {
        Race race = new Race();

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Messi", 10));
        cars.add(new Car("Son", 10));
        cars.add(new Car("Salah", 3));

        race.raceResult(cars);
        assertThat(outputStreamCaptor.toString()).contains(Message.FINAL_WINNER + "Messi, Son");
    }

    @Test
    void 입력_시도회수_테스트() {
        assertThatNoException().isThrownBy(() -> new NumberOfAttemptMove("5"));
        assertThatThrownBy(() -> new NumberOfAttemptMove("abc")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new NumberOfAttemptMove("-2")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new NumberOfAttemptMove("0")).isInstanceOf(IllegalArgumentException.class);
    }
}
