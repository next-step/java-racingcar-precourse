package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacerGroupTest {
    RacerGroup racerGroup;

    @BeforeEach
    void createRacerGroupAndAppendRacer() {
        racerGroup = new RacerGroup();

        racerGroup.append(new Racer(new Car(new CarName("red"))));
        racerGroup.append(new Racer(new Car(new CarName("green"))));
    }


    @DisplayName("Racer 추가")
    @Test
    void matchAppendRacer(){
        racerGroup.append(new Racer(new Car(new CarName("pink"))));

        assertEquals(3, racerGroup.getRacerGroup().size());
    }

    @DisplayName("RacerGroup 리셋 후 사이즈 테스트")
    @Test
    void matchRacerGroupSizeAfterReset() {
        racerGroup.reset();
        assertEquals(0, racerGroup.getRacerGroup().size());
    }

    @DisplayName("레이서 별 자동차 점수 출력")
    @Test
    void matchCarScorePrintByRacer() {
        for (Racer racer : racerGroup.getRacerGroup()) {
            racer.getCar().run(4);
        }

        String resultStr = "red : -" + "\n" + "green : -" + "\n";
        assertEquals(resultStr, racerGroup.toStringCarDistanceByRacer());
    }
}
