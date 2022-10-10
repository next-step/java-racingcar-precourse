package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"붕붕이", "씽씽이", "쌩썡이", "슝슝이"})
    void 자동차에_이름을_부여한다(final String carName) {
        Car car = new Car(carName);
        Assertions.assertThat(car).isEqualTo(new Car(carName));
    }

    @Test
    void 자동차의_전진조건에_충족하면_전진하도록_한다() {
        Car car = new Car("붕붕이");
        AlwaysMovingStrategy movingStrategy = new AlwaysMovingStrategy();
        car.move(movingStrategy);
        Assertions.assertThat(car).isEqualTo(new Car("붕붕이", new Location(1)));
    }

    @Test
    void 자동차를_비교하여_우승자_조회() {
        Car 붕붕이 = new Car("붕붕이", new Location(3));
        Car 씽씽이 = new Car("씽씽이", new Location(1));
        Car winner = 붕붕이.whoIsWinner(씽씽이);
        Assertions.assertThat(winner).isEqualTo(붕붕이);
    }

    @Test
    void 자동차가_동일한_값을_가지고_있는지_확인(){
        Car 붕붕이 = new Car("붕붕이", new Location(1));
        Car 씽씽이 = new Car("씽씽이", new Location(1));
        Assertions.assertThat(붕붕이.isTie(씽씽이)).isTrue();
    }
}
