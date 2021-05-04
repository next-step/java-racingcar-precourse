package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class RacingPlayerTest {


    private List<String> carNameList;
    private RacingPlayer racingPlayer;

    @BeforeEach
    void setUp() {
        carNameList = new ArrayList<>();
        carNameList.add("pobi");
        carNameList.add("crong");
        carNameList.add("honux");
        racingPlayer = new RacingPlayer(carNameList);

    }

    @RepeatedTest(30)
    @DisplayName("우승자가 정상적으로 계산되는지 테스트")
    void 우승자_정상_계산_검증() {
        for (int i = 0; i < 3; i++) {
            racingPlayer.turn();
        }
        assertAll(() -> assertThat(racingPlayer.maxPosition()).isBetween(0, 3),
                () -> assertThat(racingPlayer.whoIsWinner()).containsAnyElementsOf(carNameList)
        );
    }


}
