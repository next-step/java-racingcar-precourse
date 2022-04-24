package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.*;
import racingcar.domain.dto.CarsDto;
import racingcar.domain.dto.GameHistoryDto;
import racingcar.domain.dto.Winners;
import racingcar.domain.strategy.MoveStrategy;
import racingcar.service.dto.GameInformation;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {

    @DisplayName("매번 움직이는 정상 케이스 동작 테스트")
    @Test
    void moveAlwaysTest() {
        String namesStr = "miz,ki,bi";
        Names names = Names.from(namesStr);
        Winners winners = Winners.from(names);

        Integer time = 3;
        Game game = Game.of(GameInformation.from(namesStr, time), () -> true);

        GameHistoryDto gameHistoryDto = game.start();

        String positionOne = "1,1,1";
        String positionTwo = "2,2,2";
        String positionThree = "3,3,3";
        Cars oneStep = createCars(namesStr, positionOne);
        Cars twoStep = createCars(namesStr, positionTwo);
        Cars threeStep = createCars(namesStr, positionThree);

        assertThat(gameHistoryDto.getHistory().get(1)).isEqualTo(CarsDto.from(oneStep));
        assertThat(gameHistoryDto.getHistory().get(2)).isEqualTo(CarsDto.from(twoStep));
        assertThat(gameHistoryDto.getHistory().get(3)).isEqualTo(CarsDto.from(threeStep));
        assertThat(gameHistoryDto.getWinners()).isEqualTo(winners);
    }

    private Cars createCars(String nameStr, String positionStr) {
        MoveStrategy moveStrategy = () -> true;
        Names names = Names.from(nameStr);

        List<Name> namesList = names.getNames();
        String[] positions = positionStr.split(",");

        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < positions.length; i++) {
            carList.add(Car.from(namesList.get(i), Position.from(Integer.parseInt(positions[i]))));
        }

        return Cars.from(carList);
    }
}