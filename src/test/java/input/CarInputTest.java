package input;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import model.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.CarRaceService;

public class CarInputTest {
    private CarRaceService carRace;

    @BeforeEach
    public void setUp() {
        carRace = new CarRaceService();
    }
    @Test
    public void InvalidateNumberCarName() { // Car의 이름 글자수가 기준에 맞지 않을 경우 테스트
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Car("abcdef"); // Car의 이름이 총 6글자
        });
        assertEquals("[ERROR] 자동차 이름은 1자 이상 5자 이하만 가능합니다.", exception.getMessage());
    }

    @Test
    public void DuplicatedCarName() { // 중복된 Car 이름에 대한 테스트

        //Given
        String carName = "carA,carB,carA"; // 중복된 이름

        // When & Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            carRace.createCars(carName);
        });
        assertEquals("[ERROR] 자동차 이름은 중복될 수 없습니다.", exception.getMessage());
    }


}
