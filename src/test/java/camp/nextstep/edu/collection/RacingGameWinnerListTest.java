package camp.nextstep.edu.collection;

import camp.nextstep.edu.game.RacingCar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameWinnerListTest {

    private List<RacingCar> racingCarList;

    @BeforeEach
    void init() {
        racingCarList = new ArrayList<>();
        racingCarList.add(new RacingCar("pobi"));
        racingCarList.add(new RacingCar("crong"));
        racingCarList.add(new RacingCar("honux"));
    }

    @ParameterizedTest
    @CsvSource(value = {"0:0:0:3", "3:3:3:3", "3:3:4:1", "3:4:4:2", "4:4:4:3"}, delimiter = ':')
    @DisplayName("게임 우승자 목록 반환 - 성공 테스트")
    void winnerList_size_successTest(int number1, int number2, int number3, int winnerCount) {
        // given
        racingCarList.get(0).move(number1);
        racingCarList.get(1).move(number2);
        racingCarList.get(2).move(number3);

        // when
        RacingGameWinnerList racingGameWinnerList = new RacingGameWinnerList(racingCarList);

        // then
        assertThat(racingGameWinnerList.getWinnerList().size()).isEqualTo(winnerCount);
    }
}
