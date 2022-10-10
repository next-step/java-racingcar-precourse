package racingcar.game.status;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.game.GameContext;
import racingcar.view.status.EnterCarNameList;
import racingcar.view.status.EnterRetryCount;

class MakeCarListTest {

    @Test
    @DisplayName("차이름중 5개 초과의 크기의 이름이 입력된 경우 재입력")
    void put_greater_than_5_car_name_in_list() {
        GameContext gameContext = new GameContext();
        gameContext.setCarNameList("abcdefg,asd,efe");
        MakeCarList makeCarList = new MakeCarList();
        assertThat(makeCarList.next(gameContext)).isInstanceOf(EnterCarNameList.class);
    }

    @Test
    @DisplayName("차이름중 5개 미만의 크기의 이름이 입력된 경우 재시도 횟수 입력")
    void put_5_or_less_car_name_in_list() {
        GameContext gameContext = new GameContext();
        gameContext.setCarNameList("abcdefg,asd,efe");
        MakeCarList makeCarList = new MakeCarList();
        assertThat(makeCarList.next(gameContext)).isInstanceOf(EnterCarNameList.class);
    }
}