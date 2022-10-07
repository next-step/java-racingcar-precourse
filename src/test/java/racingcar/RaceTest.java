package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Race;
import racingcar.model.TryCount;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class RaceTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private Race race;
    private Cars cars;

    @BeforeEach
    void setUp() {
        cars = new Cars("test1,test2,test3");
        TryCount count = new TryCount("3");
        race = new Race(cars, count);
    }

    @Test
    @DisplayName("레이스 정보 입력")
    void input_Race_Info() {
        assertThat(race.getCars().get(0).getName().equals("test1")).isTrue();
        assertThat(race.getCount()).isEqualTo(3);
    }

    @Test
    @DisplayName("레이스 진행")
    void race_Run() {
        assertRandomNumberInRangeTest(
                () -> {
                    race.run();
                    assertThat(race.getCars().get(0).getDistance()).isEqualTo(1);
                    assertThat(race.getCars().get(1).getDistance()).isEqualTo(0);
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    @DisplayName("레이스 우승자")
    void race_Get_Winner() {
        Car winner1 =  cars.getCars().get(0);
        Car loser =  cars.getCars().get(1);
        Car winner2 =  cars.getCars().get(2);

        winner1.move(MOVING_FORWARD);
        winner2.move(MOVING_FORWARD);
        loser.move(STOP);

        List<String> winnerNames = race.getWinnerNames();

        assertThat(winnerNames.get(0).equals(winner1.getName())).isTrue();
        assertThat(winnerNames.get(1).equals(loser.getName())).isFalse();
    }
}
