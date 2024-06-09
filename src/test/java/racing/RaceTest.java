package racing;

import java.util.List;
import model.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.CarRaceService;

public class RaceTest {
    private CarRaceService carRace;
    @BeforeEach
    public void setUp() {
        carRace = new CarRaceService();
    }
    @Test
    @DisplayName("차량 이름이 알맞게 입력됐을 때 차량의 갯수 확인하는 테스트")
    public void racing() {
        //Given
        String carName = "carA, carB, carC";

        //When
        carRace.createCars(carName);

        //Then
        List<Car> cars = carRace.getCars();
        Assertions.assertEquals(3, cars.size());
    }

    
}
