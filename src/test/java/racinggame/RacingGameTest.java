package racinggame;

import DTO.Car;
import custom.utils.ValidationUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.CarService;
import service.RacingSevice;

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
    @DisplayName("차량 객체 생성")
    public void setObject () throws Exception {
        CarService carService = new CarService();
        //racingService.createCar("car1,care134");
        carService.createCar("car11,car2,car3,car4,car5");
    }

    @Test
    @DisplayName("랜덤값에 따른 움직이기 처리")
    public void isMove() throws Exception {
        RacingSevice racingSevice = new RacingSevice();
        //assertThat(racingSevice.isMove(10)).isFalse();
        //assertThat(racingSevice.isMove(4)).isTrue();
    }

    @Test
    @DisplayName("차량 움직이기 처리")
    public void mvCarProc() throws Exception {
        CarService carService = new CarService();
        RacingSevice racingSevice = new RacingSevice();
        List<Car> carsInfo = carService.createCar("car11,car2,car3,car4,car5");
        racingSevice.mvCar(carsInfo,9);
    }

    @Test
    @DisplayName("차량 움직이기 처리 결과 리턴")
    public void end() throws Exception {
        CarService carService = new CarService();
        RacingSevice racingSevice = new RacingSevice();
        List<Car> carsInfo = carService.createCar("car1,car2,car3,car4,car5");
        carsInfo = racingSevice.mvCar(carsInfo,5);
        racingSevice.endRacing(carsInfo);
    }

}

