package racingcar.domain.racetrack;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.Position;
import racingcar.domain.racetrack.FinishLine;

public class FinishLineTest {
    private List<Car> cars;

    @BeforeEach
    void setup() {
        //given
        cars = new ArrayList<>();
        cars.add(new Car("Test1", 3));
        cars.add(new Car("Test2", 1));
        cars.add(new Car("Test3", 4));
        cars.add(new Car("Test4", 4));
    }

    @Test
    @DisplayName("위치값중 가장 큰 값을 찾는다.")
    void 가장_큰_위치값_찺기() {
        //when
        FinishLine finishLine = new FinishLine(cars);

        //then
        Assertions.assertThat(finishLine.getMaxPosition()).isEqualTo(new Position(4));
    }

    @Test
    @DisplayName("우승자를 가려낸다.")
    void 우승자_찾기() {
        //when
        FinishLine finishLine = new FinishLine(cars);
        finishLine.judgeWinners();

        //then
        Assertions.assertThat(finishLine.getWinners()).hasSize(2);
        Assertions.assertThat(finishLine.getWinners().get(0)).isEqualTo(new Car("Test3", 4));
        Assertions.assertThat(finishLine.getWinners().get(1)).isEqualTo(new Car("Test4", 4));

    }


}
