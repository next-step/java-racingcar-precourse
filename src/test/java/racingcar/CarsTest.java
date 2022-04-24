package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.cars.Car;
import racingcar.cars.Cars;
import racingcar.firstcollections.Positive;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarsTest {

    List<Car> carList = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        carList.add(new Car("홍길동", new Positive(2L)));
        carList.add(new Car("pobi", new Positive(0L)));
        carList.add(new Car("jun", new Positive(1L)));
    }

    @Test
    @DisplayName("자동차 이름은 쉼표(,)를 기준으로 입력받은 문자열을 나누어 생성")
    public void test01() {
        String input = "pobi,woni,jun";
        Cars cars = new Cars(input);
        List<Car> list = cars.getCars();
        assertThat(list.get(0).getName()).isEqualTo("pobi");
        assertThat(list.get(1).getName()).isEqualTo("woni");
        assertThat(list.get(2).getName()).isEqualTo("jun");
    }

    @Test
    @DisplayName("각 자동차 위치 조회")
    public void test02() {
        Cars cars = new Cars(carList);
        List<Car> list = cars.getCars();
        assertThat(list.get(0).getDistance()).isEqualTo(2L);
        assertThat(list.get(1).getDistance()).isEqualTo(0L);
        assertThat(list.get(2).getDistance()).isEqualTo(1L);
    }

    @Test
    @DisplayName("가장 멀리 간 자동차 조회")
    public void test03() {
        Cars cars = new Cars(carList);
        List<Car> winners = cars.getWinners();
        assertThat(winners.get(0).getName()).isEqualTo("홍길동");
    }

    @Test
    @DisplayName("',' 연속 입력 시 에러 발생")
    public void test04() {
        assertThrows(IllegalArgumentException.class, () -> new Cars("1,,"));
    }
}
