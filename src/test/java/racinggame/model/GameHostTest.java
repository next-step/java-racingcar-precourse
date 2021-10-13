package racinggame.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static racinggame.model.RacingTest.MOVE_FORWARD_RANGE_SETTING;

class GameHostTest {

    GameHost gameHost;
    ArrayList<Car> carList;

    @BeforeEach
    void setUp() {
        Car aCar = new Car("aCar");
        Car bCar = new Car("bCar");

        carList = new ArrayList<Car>();

        carList.add(aCar);
        carList.add(bCar);

        gameHost = new GameHost(carList, 5);
    }

    @Test
    void 두_차량_5_라운드_게임_결과_리스트_확인하기() {
        assertThat(gameHost.recordingRaceList.get(gameHost.recordingRaceList.size() - carList.size()).confirmCarName()).isEqualTo("aCar");
        assertThat(gameHost.recordingRaceList.get(gameHost.recordingRaceList.size() - carList.size()+1).confirmCarName()).isEqualTo("bCar");
    }

}