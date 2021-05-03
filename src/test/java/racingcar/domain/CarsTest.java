package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class CarsTest {

    @Test
    @DisplayName("자동차들 생성")
    void constructor() {
        String userName = "메르세데스,하스,페라리,르노,기아,현대";
        String[] names = userName.split(",");
        Cars cars = new Cars(userName);

        for (int i = 0, max = cars.size(); i < max; i++) {
            assertThat(cars.get(i).getName()).isEqualTo(names[i]);
        }
    }

    @Test
    @DisplayName("자동차 이름 중복")
    void constructor_duplicated() {
        assertThat(catchThrowable(() -> new Cars("메르세데스,하스,페라리,메르세데스,기아,현대")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이동")
    void move() {
        Cars cars = new Cars("메르세데스,하스,페라리,르노,기아,현대");
        for (int i = 0; i < 10; i++) {
            cars.move();
            cars.forEach(car -> System.out.println(car));
            System.out.println();
        }
    }

    @Test
    @DisplayName("우승자 필터")
    void getWinners() {
        Cars cars = new Cars("메르세데스,하스,페라리,르노,기아,현대");
        for (int i = 0; i < 10; i++) {
            cars.move();
        }

        cars.forEach(car -> System.out.println(car));
        System.out.println();

        Cars winners = cars.getWinners();
        System.out.println(winners);
    }

}