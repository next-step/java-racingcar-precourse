package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class RaceTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private Race race;

    @BeforeEach
    void init() {
        race = new Race();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 2", "abcefgh, abcefgi", ",  ", "\\n", ""})
    @DisplayName("자동차 이름 값이 잘못된 경우 IllegalArgumentException을 발생시킨다.")
    void input_invalid_carname(String givenText){
        assertThatThrownBy(
            () -> race.joinRacing(givenText)
        ).isInstanceOf(IllegalArgumentException.class);
    }


    @ParameterizedTest
    @ValueSource(strings = {"", "a", "0", "-2", "**", "2147483648"})
    @DisplayName("시도 횟수 값이 잘못된 경우 IllegalArgumentException을 발생시킨다.")
    void input_invalid_round(String givenText){
        assertThatThrownBy(
            () -> race.initRound(givenText)
        ).isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    @DisplayName("남은 횟수가 0 이하이면 false 리턴한다.")
    void is_open(){
        // given
        race.joinRacing("aaa, bbb, ccc");
        /* 0 이하로는 초기화가 안되기 때문에 1로 생성후 한 횟수를 진행한다. */
        race.initRound("1");
        race.run();
        // when
        boolean open = race.open();
        // then
        assertThat(open).isFalse();
    }

    @Test
    @DisplayName("우승자를 리턴한다.")
    void end(){
        // given
        RaceResult car1 = new RaceResult("aaa", 5);
        RaceResult car2 = new RaceResult("bbb", 5);
        RaceResult car3 = new RaceResult("ccc", 3);
        RaceResults raceResults = new RaceResults(Arrays.asList(car1, car2, car3));
        // when
        Winners end = race.end(raceResults);
        // then
        assertAll(
            () -> assertThat(end).isNotNull(),
            () -> assertThat(end).extracting("winners")
                .asList()
                .contains("aaa","bbb")
        );
    }

    @Test
    @DisplayName("한 회차에 대한 결과를 리턴한다.")
    void run(){
        RaceResult car1 = new RaceResult("aaa", 1);
        RaceResult car2 = new RaceResult("bbb", 1);
        RaceResult car3 = new RaceResult("ccc", 0);
        List<RaceResult> givenResults = Arrays.asList(car1, car2, car3);
        race.joinRacing("aaa, bbb, ccc");
        race.initRound("1");

        assertRandomNumberInRangeTest(
            () -> {
                RaceResults results = race.run();
                assertAll(
                    () -> assertThat(results).isNotNull(),
                    () -> assertThat(results)
                        .extracting("raceResults")
                        .isEqualTo(givenResults)
                );
            },
            MOVING_FORWARD, MOVING_FORWARD, STOP
        );
    }
}
