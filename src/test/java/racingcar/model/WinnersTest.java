package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinnersTest {
    PlayerGroup playerGroup;

    @BeforeEach
    void createPlayerGroup() {
        playerGroup = new PlayerGroup();
    }


    @DisplayName("최종 우승자 출력 값 확인")
    @Test
    void 최종_우승자_출력값_확인_테스트() {
        Player apple = new Player(new Car(new CarName("apple")));
        Player kiwi = new Player(new Car(new CarName("kiwi")));

        apple.getCar().run(5);
        kiwi.getCar().run(3);

        playerGroup.append(apple);
        playerGroup.append(kiwi);

        Winners winner = new Winners(playerGroup);

        String winners = "최종 우승자 : apple";
        assertEquals(winners, winner.toStringFinalWinnerNames());
    }
}