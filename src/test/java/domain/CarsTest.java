package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5})
    @DisplayName("전체 전진이 가능하다")
    public void 전체_전진이_가능하다(int move) {
        List<Car> carList = new ArrayList<>();

        CarNames carNames = new CarNames("a,b,c,d,e");
        List<CarName> names = carNames.getNames();

        for(CarName carName : names) {
            carList.add(new Car(carName, () -> true));
        }

        Cars cars = new Cars(carList);

        for(int i = 0; i<move; i++) {
            cars.move();
        }

        Positions positions = cars.getPositions();
        for(Position position : positions.getPositions()) {
            assertThat(position.getPosition())
                    .isEqualTo(move);
        }
    }
}
