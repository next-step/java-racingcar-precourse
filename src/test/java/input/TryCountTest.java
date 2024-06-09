package input;

import java.util.List;
import model.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.CarRaceService;
import service.InputHandler;

public class TryCountTest {

    private CarRaceService carRace;
    private InputHandler inputHandler;

    @BeforeEach
    public void setUp() {
        carRace = new CarRaceService();
        inputHandler = new InputHandler();
    }

    @Test
    @DisplayName("시도 횟수가 0인 경우")
    public void ZeroNumberCase() {
        //Given
        int count = 0;

        //When & Then
        IllegalArgumentException exception = Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> {
                carRace.race(count);
            });
        Assertions.assertEquals("[ERROR] 시도 횟수는 1 이상의 정수로 입력 가능합니다. 다시 입력해주세요", exception.getMessage());
    }

    


}
