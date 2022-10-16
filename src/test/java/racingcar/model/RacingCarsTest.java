package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarsTest {

    @Test
    @DisplayName("한 개 이상의 자동차 콜렉션을 생성한다.")
    void generateCar() {
        RacingCars racingCars = new RacingCars("car1,car2");
        List<RacingCar> cars = racingCars.getCars();
        System.out.println(racingCars);

        assertThat(cars.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("자동차 이름을 입력하지 않고 exception을 발생시킨다")
    void generateCarException(){

        assertThatThrownBy(() -> {
            RacingCars racingCars = new RacingCars("");
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("0-9 사이의 랜덤 숫자를 생성한다.")
    void generateRandomNumber(){
        int i = Randoms.pickNumberInRange(0, 9);

        System.out.println("랜덤값 : " +  i);

        assertThat(i >= 0 && i < 10).isTrue();
    }

    @Test
    @DisplayName("레이싱을 1회 한다.")
    void racingOne(){
        RacingCars racingCars = new RacingCars("car1,car2");

        racingCars.race(1);

        assertTrue(true);
    }

    @Test
    @DisplayName("경주 결과를 출력한다.")
    void printRacing(){
        RacingCars racingCars = new RacingCars("car1,car2,car3,car4");

        racingCars.race(4);
        racingCars.printResult();

        assertTrue(true);
    }

}
