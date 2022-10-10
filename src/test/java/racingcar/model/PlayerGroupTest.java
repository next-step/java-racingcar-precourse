package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerGroupTest {
    PlayerGroup playerGroup;

    @BeforeEach
    void createPlayerGroupAndAppendPlayer() {
        playerGroup = new PlayerGroup();

        playerGroup.append(new Player(new Car(new CarName("leeso"))));
        playerGroup.append(new Player(new Car(new CarName("solee"))));
    }


    @DisplayName("Player 추가")
    @Test
    void player추가_테스트(){
        playerGroup.append(new Player(new Car(new CarName("leeso"))));

        assertEquals(3, playerGroup.getPlayerGroup().size());
    }

    @DisplayName("PlayerGroup 리셋 후 사이즈 테스트")
    @Test
    void 플레이어그룹_리셋_테스트() {
        playerGroup.reset();
        assertEquals(0, playerGroup.getPlayerGroup().size());
    }

    @DisplayName("자동차 점수 출력")
    @Test
    void 플레이어_자동차점수_출력_테스트() {
        for (Player player : playerGroup.getPlayerGroup()) {
            player.getCar().run(4);
        }

        String resultStr = "leeso : -" + "\n" + "solee : -" + "\n";
        assertEquals(resultStr, playerGroup.toStringCarDistanceByPlayer());
    }
}
