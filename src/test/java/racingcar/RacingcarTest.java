package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingcarTest {

    @Test
    void n대의_차_이름_입력() {
        String[] names = new String[]{"ping1", "ping2", "ping3"};
        String input = String.join(",", names);

        RaceGame raceGame = new RaceGame(input);
        List<Car> cars = raceGame.getCars();

        for (int i = 0; i<cars.size(); i++) {
            assertThat(cars.get(i).getName()).isEqualTo(names[i]);
        }
    }

    @Test
    void 차의_이름은_5자_이하여야_한다() {
        String[] names = new String[]{"ping1", "ping2", "ping1123123"};
        String input = String.join(",", names);

        assertThatThrownBy(() -> new RaceGame(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    void 몇_번의_이동을_할_것인지_입력할_수_있다() {
        String[] names = new String[]{"ping1", "ping2", "ping3"};
        String input = String.join(",", names);
        int moveCount = 5;

        RaceGame raceGame = new RaceGame(input);
        raceGame.setMoveCount(moveCount);

        assertThat(raceGame.getMoveCount()).isEqualTo(moveCount);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:0", "1:0", "2:0", "3:0", "4:1", "5:1", "6:1", "7:1", "8:1", "9:1"}, delimiter = ':')
    void 한_번의_이동에_전진_또는_멈추는_행동을_할_수_있다(int number, int expected) {
        Car car = new Car("ping1");
        car.setRandomNumber(number);
        assertThat(car.move()).isEqualTo(expected);
    }

    @Test
    void 레이싱에서_누가_우승했는지_알려준다() {
        String[] names = new String[]{"ping1", "ping2", "ping3"};
        String input = String.join(",", names);
        Map<Integer, Round> race = new HashMap<>();
        Map<String, Integer> round = new HashMap<>();
        round.put("ping1", 1);
        round.put("ping2", 1);
        round.put("ping3", 1);
        race.put(1, new Round(round));
        int moveCount = 1;

        RaceGame raceGame = new RaceGame(input);
        raceGame.setMoveCount(moveCount);
        raceGame.setRace(new Race(race));

        assertThat(raceGame.getWinners()).contains("ping1", "ping2", "ping3");
    }
}
