package racinggame.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.vo.Car;
import racinggame.vo.CarLocation;
import racinggame.vo.PlayerName;

public class CarTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 100, 5000, 99999999})
    void 전진을_명령받은_경우_현재_위치가_1_증가한다(int prevLocation){
        Assertions.assertThat(new Car(new PlayerName("test"), new CarLocation(prevLocation)).forward()).isEqualTo(new CarLocation(prevLocation + 1));
    }
}
