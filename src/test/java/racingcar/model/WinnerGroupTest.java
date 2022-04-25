package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WinnerGroupTest {

    RacerGroup racerGroup;

    @BeforeEach
    void createRacerGroup() {
        racerGroup = new RacerGroup();
    }


    @DisplayName("최종 우승자 이름 매치")
    @Test
    void matchWinnerInRacerGroup() {
        Racer redRacer = new Racer(new Car(new CarName("red")));
        Racer greenRacer = new Racer(new Car(new CarName("green")));

        redRacer.getCar().run(5);
        greenRacer.getCar().run(3);

        racerGroup.append(redRacer);
        racerGroup.append(greenRacer);

        WinnerGroup winnerGroup = new WinnerGroup(racerGroup);

        String winner = "최종 우승자: red";
        assertEquals(winner, winnerGroup.toStringFinalWinnerNames());
    }
}
