package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarTest {

    @Test
    @DisplayName("이름을 가진 자동차 객체를 생성한다")
    void generateCar(){
        RacingCar racingCar = new RacingCar("car1");

        assertThat(racingCar.getName()).isEqualTo("car1");

    }

    @Test
    @DisplayName("1-5자의 이름을 가진 자동차 객체를 생성한다.")
    void generateCarNameValid1to5length(){
        RacingCar racingCar1 = new RacingCar("12345");

        assertTrue(racingCar1.getName().length() <= 5);

    }

    @Test
    @DisplayName("자동차 생성중 이름 5자를 초과하여 IllegalArgumentException을 발생시킨다.")
    void generateCarThrowException(){

        assertThatThrownBy(() -> {
            RacingCar racingCar3 = new RacingCar("12345");
            RacingCar racingCar4 = new RacingCar("123456");
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");

    }

    @Test
    @DisplayName("전진 횟수 필드를 가진 자동차 객체를 생성한다.")
    void generateCarForwardCount(){
        RacingCar racingCar = new RacingCar("car1");
        String raceStatus = racingCar.getRaceStatus();

        assertThat(raceStatus).isInstanceOf(String.class);

    }

    @Test
    @DisplayName("자동차를 1회 전진한다.")
    void forwardOneCar(){
        RacingCar racingCar = new RacingCar("car1");
        racingCar.forward();

        assertThat(racingCar.getRaceStatus()).isEqualTo("-");

    }

    @Test
    @DisplayName("0-9 사이의 랜덤 숫자를 생성한다.")
    void generateRandomNumber(){
        RacingCar racingCar = new RacingCar("car1");
        int i = racingCar.generateRandomNumber();

        System.out.println("랜덤값 : " +  i);

        assertThat(i >= 0 && i < 10).isTrue();
    }

    @Test
    @DisplayName("숫자가 4 이상이면 전진 카운트를 1 증가한다.")
    void forwardCRacingCar(){
        RacingCar racingCar = new RacingCar("car1");

        if(racingCar.isForward(4)){
            racingCar.forward();
        }

        assertThat(racingCar.getRaceStatus()).isEqualTo("-");

    }

    @Test
    @DisplayName("숫자가 3 이하이면 전진 카운트를 증가시키지 않는다.")
    void stopRacingCar(){
        RacingCar racingCar = new RacingCar("car1");

        if(racingCar.isForward(3)){
            racingCar.forward();
        }

        assertThat(racingCar.getRaceStatus().equals("")).isTrue();

    }

}
