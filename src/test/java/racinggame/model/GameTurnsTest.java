package racinggame.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.vo.GameTurnCnt;
import racinggame.vo.PlayerName;

public class GameTurnsTest {
    private Cars cars;

    @BeforeEach
    void setup(){
        this.cars = new Cars();

        this.cars.add(new Car(new PlayerName("car1"), new CarLocation(0)));
        this.cars.add(new Car(new PlayerName("car2"), new CarLocation(0)));
        this.cars.add(new Car(new PlayerName("car3"), new CarLocation(0)));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 9, 10})
    void 입력된_횟수만큼_게임_턴을_진행한다(int turnCnt) {
        Assertions.assertThat(GameTurns.run(this.cars, new GameTurnCnt(turnCnt)).size()).isEqualTo(turnCnt);
    }
}
