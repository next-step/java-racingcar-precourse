package racinggame.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racinggame.vo.Car;
import racinggame.vo.CarLocation;
import racinggame.vo.Cars;
import racinggame.vo.PlayerName;

public class WinnerMessageBuilderTest {
    @Test
    void 우승자들의_목록을_입력받으면_한_줄의_메시지로_변환한다(){
        Cars winnerCars = new Cars();

        winnerCars.add(new Car(new PlayerName("car1"), new CarLocation(0)));
        winnerCars.add(new Car(new PlayerName("car2"), new CarLocation(0)));
        winnerCars.add(new Car(new PlayerName("car3"), new CarLocation(0)));

        Assertions.assertThat(new WinnerMessageBuilder().build(winnerCars)).isEqualTo("최종 우승자는 car1,car2,car3 입니다.");
    }
}
