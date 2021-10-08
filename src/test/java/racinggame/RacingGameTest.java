package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
public class RacingGameTest {

    @ParameterizedTest
    @CsvSource(value = {"pobi,1,0","crong,6,1","ada,9,1"}, delimiter = ',')
    @DisplayName("자동차를 이동 시킨다.")
    void move(String carNm, int distance, int result){
        RacingGame game = new RacingGame(carNm);
        game.moveCar(0, distance);
        assertThat(game.getCars().get(0).getDistance()).isEqualTo(result);
    }

}
