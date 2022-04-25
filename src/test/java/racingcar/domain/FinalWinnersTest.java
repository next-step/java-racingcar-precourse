package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.common.GameMessage;

import static org.assertj.core.api.Assertions.*;

/**
 * FinalWinnersTest
 *
 * @author suji
 * @date 2022-04-24
 **/
class FinalWinnersTest {

    private Cars cars;

    @BeforeEach
    void setUpCars() {
        String carNames = "pobi,woni,jun";
        cars = Cars.newInstance(carNames);
    }

    @Test
    void 우승자_판별() {
        //given
        MoveNumbers moveNumbers = MoveNumbers.newInstance(4, 3, 2);
        cars.moveCars(moveNumbers);

        //when
        Ranking ranking = new Ranking(cars);
        FinalWinners finalWinners = new FinalWinners(ranking);

        //then
        System.out.println(finalWinners.getWinnerNames());
        assertThat(finalWinners.getWinners().size()).isEqualTo(1);
    }

    @Test
    void 우승자가_한명_이상일때_쉼표_구분() {
        //given
        MoveNumbers moveNumbers = MoveNumbers.newInstance(4, 3, 7);
        cars.moveCars(moveNumbers);

        //when
        Ranking ranking = new Ranking(cars);
        FinalWinners finalWinners = new FinalWinners(ranking);

        //then
        System.out.println(finalWinners.getWinnerNames());
        assertThat(finalWinners.getWinnerNames()).contains(GameMessage.WINNER_DELIMITER);
    }
}