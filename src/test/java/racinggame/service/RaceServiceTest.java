package racinggame.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.domain.Cars;
import racinggame.domain.InputCarsName;
import racinggame.domain.Player;

import static org.assertj.core.api.Assertions.*;

public class RaceServiceTest {

    @Test
    @DisplayName("플레이어가 입력한 자동차 이름들 분리하기")
    void splitCarNameWithComma()  {
        //given
        final RaceService raceService = new RaceService();
        final Player player = new Player();
        player.inputCarsName(InputCarsName.of("1번차,2번차,3번차"));
        //when
        final String[] carNameList = raceService.splitNameWithComma(player.getInputCarsName());
        //then
        assertThat(carNameList[0]).isEqualTo("1번차");
        assertThat(carNameList[1]).isEqualTo("2번차");
        assertThat(carNameList[2]).isEqualTo("3번차");
    }

    @Test
    @DisplayName("자동차 경주 리스트 생성하기")
    void makeCar() {
        //given
        final RaceService raceService = new RaceService();
        final String[] carNameList = {"1번차", "2번차", "3번차"};
        //when
        final Cars cars = raceService.createCars(carNameList);
        //then
        assertThat(cars.getCars().size()).isEqualTo(3);
        assertThat(cars.getCars().get(0).getCarName().getName()).isEqualTo("1번차");
    }
    

}
