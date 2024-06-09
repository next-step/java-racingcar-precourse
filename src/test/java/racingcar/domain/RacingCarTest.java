package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static racingcar.domain.ForwardRules.MORE_THAN_FOUR;
import static racingcar.domain.PickNumberRules.RANDOM;
import static racingcar.domain.WinnerRules.HIGHEST_POSITION;

import java.lang.reflect.Field;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("자동차 게임 테스트")
public class RacingCarTest {
    @Test
    void 자동차_게임_생성() {
        Name name1 = new Name("pobi");
        Name name2 = new Name("woni");
        Name name3 = new Name("jun");

        assertDoesNotThrow(() -> new RacingCar(RANDOM, MORE_THAN_FOUR, HIGHEST_POSITION, name1, name2, name3));
    }

    @Test
    void 주어진_N회_동안_자동차를_룰에따라_전진시킨다() throws NoSuchFieldException, IllegalAccessException {
        Name name1 = new Name("pobi");
        Name name2 = new Name("woni");
        RacingCar racingCar = new RacingCar(() -> 4, MORE_THAN_FOUR, HIGHEST_POSITION, name1, name2);

        racingCar.play(3);

        Field field = racingCar.getClass().getDeclaredField("cars");
        field.setAccessible(true);
        Cars cars = (Cars) field.get(racingCar);
        assertThat(cars).isEqualTo(new Cars(new Car(name1, new Position(3)), new Car(name2, new Position(3))));
    }

    @Test
    void 승자를_반환한다() {
        Name name1 = new Name("pobi");
        Name name2 = new Name("woni");
        RacingCar racingCar = new RacingCar(() -> 4, MORE_THAN_FOUR, HIGHEST_POSITION, name1, name2);
        racingCar.play(1);
        Position position1 = new Position(1);
        Car car1 = new Car(new Name("pobi"), position1);
        Car car2 = new Car(new Name("woni"), position1);

        assertThat(racingCar.winner()).isEqualTo(new Cars(car1, car2));
    }
}
