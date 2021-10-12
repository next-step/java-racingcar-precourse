package racinggame.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racinggame.model.Car;
import racinggame.model.Cars;

public class WinnerMessageBuilderTest {
    @Test
    void 우승자들의_목록을_입력받으면_한_줄의_메시지로_변환한다(){
        Cars winnerCars = new Cars();

        winnerCars.add(new Car("car1", 0));
        winnerCars.add(new Car("car2", 0));
        winnerCars.add(new Car("car3", 0));

        Assertions.assertThat(new WinnerMessageBuilder().build(winnerCars)).isEqualTo("최종 우승자는 car1,car2,car3 입니다.");
    }
}
