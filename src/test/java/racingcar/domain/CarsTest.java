package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {


    @DisplayName("move 호출 각 자동차들의 moveOrStop()을 호출 한다.")
    @ParameterizedTest
    @CsvSource(value = {"miz,ki,bi:0,1,2:true:1,2,3", "miz,ki,bi:0,1,2:false:0,1,2"}, delimiter = ':')
    void moveTest(String nameStr, String positionStr, boolean move, String expectPositionStr) {
        MoveStrategy moveStrategy = () -> move;
        Cars nowCars = createCars(nameStr, positionStr);

        Cars actualCars = nowCars.move(moveStrategy);

        Cars expect = createCars(nameStr, expectPositionStr);

        assertThat(actualCars).isEqualTo(expect);
    }

    private Cars createCars(String nameStr, String positionStr) {
        List<Car> carList = createCarList(nameStr, positionStr);

        return Cars.from(carList);
    }

    private List<Car> createCarList(String nameStr, String positionStr) {
        String[] positions = positionStr.split(",");
        String[] names = nameStr.split(",");
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < positions.length; i++) {
            carList.add(Car.from(Name.from(names[i]), Position.from(Integer.parseInt(positions[i]))));
        }

        return carList;
    }
}