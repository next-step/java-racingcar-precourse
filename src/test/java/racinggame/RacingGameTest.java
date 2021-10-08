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

    @Test
    @DisplayName("이동거리가 가장 긴 자동차의 이동거리를 찾는다.")
    void getMaxDistance(){
        RacingGame game = new RacingGame("pobi,crong,ada");
        game.moveCar(0, 1);
        game.moveCar(1, 7);
        game.moveCar(2, 8);
        assertThat(game.getMaxDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("우승차량인지 확인한다.")
    void isWinner(){
        RacingGame game = new RacingGame("pobi,crong,ada");
        game.moveCar(0, 1);
        game.moveCar(1, 7);
        game.moveCar(2, 8);
        assertThat(game.isWinner(0)).isFalse();
        assertThat(game.isWinner(1)).isTrue();
        assertThat(game.isWinner(2)).isTrue();
    }
}
