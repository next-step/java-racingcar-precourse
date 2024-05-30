package kim.half.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    void 자동차_목록_생성() {
        Cars cars = new Cars("민성,병현,용진");
        List<Car> carList = cars.getCars();
        assertThat(carList).hasSize(3);
        assertThat(carList).extracting("name").containsExactly("민성", "병현", "용진");
    }

    @Test
    void 우승자_가져오기() {
        Cars cars = new Cars("민성,병현,용진");
        cars.getCars().get(0).run(4);
        cars.getCars().get(1).run(3);
        cars.getCars().get(2).run(4);

        List<Car> winners = cars.getWinners();
        assertThat(winners).extracting("name").containsExactly("민성", "용진");
    }
}
