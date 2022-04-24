package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    @DisplayName("자동차들의 이름을 설정해준다")
    void setCarNames() {
        Cars cars = Cars.create(Names.valueOf("mond,latte,bana"));
        assertThat(cars.getCars()).hasSize(3);
    }

    @Test
    @DisplayName("자동차들을 입력받아 설정해준다")
    void setCarList() {
        List<Car> inputCars = Arrays.asList(
                Car.create(Name.valueOf("mond")),
                Car.create(Name.valueOf("latte")),
                Car.create(Name.valueOf("bana")),
                Car.create(Name.valueOf("choco"))
        );

        Cars cars = Cars.valueOf(inputCars);
        assertThat(cars.getCars()).hasSize(4);
    }

    @Test
    @DisplayName("자동차들이 랜덤 값을 받아 움직이거나 안움직인다")
    void moveCars() {
        Cars cars = Cars.create(Names.valueOf("pink,blue,lemon"));
        cars.move();

        Cars positionOf0Cars = cars.getParticularPosition(Position.valueOf(0));
        Cars positionOf1Cars = cars.getParticularPosition(Position.valueOf(1));

        assertAll(
                () -> assertThat(positionOf0Cars.getCars()).hasSizeGreaterThanOrEqualTo(0),
                () -> assertThat(positionOf1Cars.getCars()).hasSizeGreaterThanOrEqualTo(0),
                () -> assertThat(cars.getCars())
                        .hasSize(positionOf0Cars.getCars().size() + positionOf1Cars.getCars().size())
        );
    }

    @Test
    @DisplayName("자동차들이 한 번 움직이면 최대 위치는 0이거나 1이다")
    void maxPositionOfCars() {
        Cars cars = Cars.create(Names.valueOf("5714,503,5536"));
        cars.move();

        assertThat(cars.getMaxPosition()).isIn(Position.valueOf(0), Position.valueOf(1));
    }

    @Test
    @DisplayName("최대 위치의 자동차들의 리스트는 1이상 이다")
    void getListMaxPositionCars() {
        Cars cars = Cars.create(Names.valueOf("mond,latte,bana"));
        cars.move();

        Cars maxPositionCarList = cars.getParticularPosition(cars.getMaxPosition());
        assertThat(maxPositionCarList.getCars()).hasSizeGreaterThanOrEqualTo(1);
    }
}
