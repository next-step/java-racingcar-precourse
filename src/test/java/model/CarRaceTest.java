package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarRaceTest {

    private CarRace carRace;
    private String[] carNames = {"Car1", "Car2", "Car3"};

    @BeforeEach
    void setUp() {
        carRace = new CarRace(carNames);
    }

    @Test
    @DisplayName("초기화시의 CarRace가 정상인 지 확인")
    void initialCarRaceCheck() {
        //given
        String[] expectedCarNames =carNames;

        //when
        List<Car> cars = carRace.getCarList();

        //then
        for (int i = 0; i < expectedCarNames.length; i++) {
            assertEquals(expectedCarNames[i], cars.get(i).getName());
        }
    }

}
