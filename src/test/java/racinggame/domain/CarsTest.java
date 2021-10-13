package racinggame.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    public void 우승자_구하기() {
        List<Car> lstCars = new ArrayList<>();

        Car pobi = new Car(new Name("pobi"), new Position(3));
        Car dooly = new Car(new Name("dooly"), new Position(2));
        Car hoit = new Car(new Name("hoit"), new Position(3));

        lstCars.add(pobi);
        lstCars.add(dooly);
        lstCars.add(hoit);

        Cars cars = new Cars(lstCars);
        List<Car> winners = cars.findWinners();

        // 우승자 숫자는 2!
        assertThat(winners.size()).isEqualTo(2);

        // pobi || hoit 이 속해있어야 한다.
        assertThat(winners.contains(pobi)).isTrue();
        assertThat(winners.contains(hoit)).isTrue();

        // dooly 는 속하지 않아야 한다.
        assertThat(winners.contains(dooly)).isFalse();
    }
}