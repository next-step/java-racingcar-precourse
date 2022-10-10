package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    private String racingCarName;
    private int racingCarPosition;
    private RacingCar racingCar;
    private RandomAction randomAction;

    @BeforeEach
    void setUp(){
        racingCarName = "pobi";
        racingCarPosition = 0;
        randomAction = new RandomAction();
    }

    @Test
    @DisplayName("레이싱카 생성")
    void makeRacingCarTest(){
        racingCar = new RacingCar(racingCarName, racingCarPosition);
        assertThat(racingCar.getRacingCarName()).isEqualTo(racingCarName);
        assertThat(racingCar.getRacingCarPosition()).isEqualTo(racingCarPosition);
    }

    @Test
    @DisplayName("전진 테스트")
    void goTest(){
        racingCar = new RacingCar(racingCarName, racingCarPosition);
        int randomNum = 5;
        int nowPosition = racingCar.getRacingCarPosition();
        RacingCarAction action = randomAction.getRandomCarAction(randomNum);
        racingCar.checkCarAction(action);
        assertThat(racingCar.getRacingCarPosition()).isEqualTo(nowPosition + 1);
    }


    @Test
    @DisplayName("스탑 테스트")
    void spotTest(){
        racingCar = new RacingCar(racingCarName, racingCarPosition);
        int randomNum = 3;
        int nowPosition = racingCar.getRacingCarPosition();
        RacingCarAction action = randomAction.getRandomCarAction(randomNum);
        racingCar.checkCarAction(action);
        assertThat(racingCar.getRacingCarPosition()).isEqualTo(nowPosition);
    }
}
