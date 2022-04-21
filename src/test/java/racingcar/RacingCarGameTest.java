package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarGameTest {
    private String carNameList;

    @BeforeEach
    void setup() {
        carNameList = "ck87,gater,atube";
    }

    @Test
    @DisplayName("자동차 이름은 쉼표(,)를 기준으로 구분하여 경주용 차를 생성한다.")
    void create_car(){
        RacingCarGame racingCarGame = new RacingCarGame(carNameList);
        assertThat(racingCarGame).isNotNull();
    }

    @Test
    @DisplayName("우승자 이름을 출력한다. 한명 이상일 경우 쉼표(,)로 구분한다.")
    void print_winner_name(){
        String carNameList = "ck87,gater,atube";
        RacingCarGame racingCarGame = new RacingCarGame(carNameList);
        String winnerNames = racingCarGame.getWinnerNames();
        assertThat(winnerNames).startsWith("최종 우승자: ")
                .containsAnyOf(carNameList.split(",")[0],
                        carNameList.split(",")[1],
                        carNameList.split(",")[2]);
    }

    @Test
    @DisplayName("주어진 횟수 동안 n대의 자동차들이 전진 또는 멈추며 결과 값을 출력한다.")
    void repeated_move(){
        RacingCarGame racingCarGame = new RacingCarGame(carNameList);
        racingCarGame.racing(5);
        assertThat(racingCarGame).isNotNull();
    }


}
