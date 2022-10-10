package racingcar.model;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    @DisplayName("자동차 목록 입력")
    public void testRegisterCars() {
        String names = "pobi,crong,honux";
        Cars race = new Cars();
        race.generateCars(names);
        List<Car> carList = race.getCars();
        Assertions.assertEquals(3, carList.size());
    }

    @Test
    @DisplayName("자동차 목록 입력 시 공백 문자 입력")
    public void testRegisterEmptyCars() {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
            new Cars().generateCars("");
        });
    }
}
