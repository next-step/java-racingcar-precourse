package racinggame.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;

public class GameTurnsTest {
    private ArrayList<Car> cars;

    @BeforeEach
    void setup(){
        this.cars = new ArrayList<>();

        this.cars.add(new Car("car1", 0));
        this.cars.add(new Car("car2", 0));
        this.cars.add(new Car("car3", 0));

    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 9, 10})
    void 입력된_횟수만큼_게임_턴을_진행한다(int turnCnt) {
        Assertions.assertThat(GameTurns.run(this.cars, turnCnt).size()).isEqualTo(turnCnt);
    }
}
