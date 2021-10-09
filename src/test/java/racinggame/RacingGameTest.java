package racinggame;

import DTO.Car;
import custom.utils.ValidationUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.RacingService;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @Test
    @DisplayName("차량 입력값 검증 null 및 공백제거")
    public void validationCarInfo(){
        assertThat(ValidationUtils.carValiDation(null)).isFalse();
        assertThat(ValidationUtils.carValiDation("")).isFalse();
        assertThat(ValidationUtils.carValiDation("car1,car2,car3,car4,car5")).isTrue();
        System.out.println(ValidationUtils.rmAllSpace("car          1, ca r2,c a r3 , car4,c a r5"));
    }

    @Test
    public void setObject () throws Exception {
        RacingService racingService = new RacingService();
        //racingService.createCar("car1,care134");
        racingService.createCar("car11,car2,car3,car4,car5");
    }

}

