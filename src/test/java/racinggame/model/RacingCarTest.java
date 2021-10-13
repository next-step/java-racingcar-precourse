package racinggame.model;

import org.junit.jupiter.api.DisplayName;
import racinggame.view.RacingCarInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import java.util.ArrayList;
import racinggame.view.RacingCarInput;

public class RacingCarTest {
    private RacingCar racingCar;

    @BeforeEach
    void setup(){
        racingCar = new RacingCar();
    }

    @DisplayName("차이름부여확인")
    @Test
    void checkSetCarName(){
        String testCarName = "Red";
        racingCar.setCarName(testCarName);
        assertThat(racingCar.getCarName()== testCarName);
    }

}
