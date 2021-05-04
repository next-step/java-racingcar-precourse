package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class RacingCarsTest {
    RacingCars racingCars;
    @BeforeEach
    void setUp() {
        String names = "pobi,crong,honux";

        racingCars = new RacingCars(names.split(","));
    }

    @DisplayName("자동차 , split 후 생성")
    @Test
    void splitArrayToRacingCarsTest() {
        assertThat(racingCars.carList.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("자동차들 전진 테스트")
    void racingCarsForwardTest() {
        for (Car car : racingCars.carList){
            car.forward(true);
            assertThat(car.getPosition()).isEqualTo(1);
        }
    }

    @DisplayName("전진 조건에 따라 자동차 position을 전진 시켜준다.")
    @Test
    void carEvent() {

        //       racingCars.carEvent(racingCars.carList);
        //        렌덤 값이 따라 전지과 멈춤의 assertThat 테스트를 어떻게 해야될지 어려움.
        for(Car car : racingCars.carList){
            System.out.println(car.getName() +"   //  "+car.getPosition());
        }
    }

    @Test
    @DisplayName("사용자 숫자 만큼 carEvent 실행")
    void startRacing() {
        int count= 5;
        racingCars.startRacing(count);

        for(Car car : racingCars.carList){
            System.out.println(car.getName() +"   //  "+car.getPosition());
        }
    }
}
