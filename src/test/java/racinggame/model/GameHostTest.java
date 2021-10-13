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
    void 한_라운드_종료_후_결과_저장_싸이클() {

        MOVE_FORWARD_RANGE_SETTING();

        Racing.racingAllCars(carList);

        assertThat(gameHost.recordingRaceList.get(0).confirmCarName()).isEqualTo(new Car("aCar").confirmCarName());
        assertThat(gameHost.recordingRaceList.get(0).confirmNowPosition()).isEqualTo(1);
        assertThat(gameHost.recordingRaceList.get(1).confirmCarName()).isEqualTo(new Car("bCar").confirmCarName());
        assertThat(gameHost.recordingRaceList.get(1).confirmNowPosition()).isEqualTo(1);

    }

    @Test
    void 두_라운드_동안_차량_전진만_종료_후_결과_저장_싸이클() {

        MOVE_FORWARD_RANGE_SETTING();

        gameHost.recordByRound(2);

//        assertThat(gameHost.recordingRaceList.get(3).confirmCarName()).isEqualTo(gameHost.recordingRaceList.get(1).confirmCarName());
//        assertThat(gameHost.recordingRaceList.get(3).confirmNowPosition()).isNotEqualTo(gameHost.recordingRaceList.get(1).confirmNowPosition());
    }

}