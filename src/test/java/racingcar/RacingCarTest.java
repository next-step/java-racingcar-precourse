package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.service.RacingCarGame;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingCarTest {

    @Test
    void 우승자_확인() {
        String winner = RacingCarGame.getWinner();
        assertThat(winner).isEqualTo("1");
    }

    @Test
    void MAX값을_가진_자동차_찾기(){
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("a", 1);
        map.put("b", 3);
        map.put("c", 3);
        String carName = RacingCarGame.getMaxMovingCarName(map);

        assertThat(carName).isEqualTo("b, c");
        assertThat(RacingCarGame.getWinner()).isEqualTo("b, c");
    }

    @Test
    void 자동차_전진_합계() {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 3);
        map.put("c", 3);
        map.put("a", 0);
        System.out.println(map);



        int currentMovingNum = map.get("a");
        map.put("a", ++currentMovingNum);
        System.out.println(map);

    }

}
