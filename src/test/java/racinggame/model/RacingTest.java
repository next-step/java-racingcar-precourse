package racinggame.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RacingTest {

    static final void MOVE_FORWARD_RANGE_SETTING() {
        Racing.START_INCLUSIVE = 4;
        Racing.END_INCLUSIVE = 9;
    }

    static final void MOVE_STAY_RANGE_SETTING() {
        Racing.START_INCLUSIVE = 1;
        Racing.END_INCLUSIVE = 3;
    }

    @Test
    void 이동_명령_4_to_9() {
        assertThat(Racing.validateMoveFoward(0)).isFalse();
        assertThat(Racing.validateMoveFoward(1)).isFalse();
        assertThat(Racing.validateMoveFoward(3)).isFalse();
        assertThat(Racing.validateMoveFoward(4)).isTrue();
        assertThat(Racing.validateMoveFoward(9)).isTrue();
        assertThat(Racing.validateMoveFoward(10)).isFalse();
    }

    @Test
    void valid_true_일때_차량_이동_valid_false_일때_stay_한다() {
        boolean resultByRandomNumber;
        Car aCar = new Car("aCar");

        Racing.moveFowardOrStay(aCar, 4);

        assertThat(aCar.confirmNowPosition()).isEqualTo(1);
    }

    @Test
    void Host_객체에서_Racing_로직_두_대의_차량_앞으로_전진만() {

        MOVE_FORWARD_RANGE_SETTING();

        ArrayList<Car> carList = new ArrayList<Car>();

        Car aCar = new Car("aCar");
        Car bCar = new Car("bCar");

        carList.add(aCar);
        carList.add(bCar);

        Racing.racingAllCars(carList);

        Assertions.assertThat(carList.get(0).confirmNowPosition()).isEqualTo(1);
        Assertions.assertThat(carList.get(1).confirmNowPosition()).isEqualTo(1);
    }

    @Test
    void Host_객체에서_Racing_로직_두_대의_차량_앞으로_제자리_유지만() {

        MOVE_STAY_RANGE_SETTING();

        ArrayList<Car> carList = new ArrayList<Car>();

        Car aCar = new Car("aCar");
        Car bCar = new Car("bCar");

        carList.add(aCar);
        carList.add(bCar);

        Racing.racingAllCars(carList);

        Assertions.assertThat(carList.get(0).confirmNowPosition()).isEqualTo(0);
        Assertions.assertThat(carList.get(1).confirmNowPosition()).isEqualTo(0);
    }

    @Test
    void 주워진_게임_수_만큼_Racing을_진행_후_기록_Array_생성() {
        MOVE_FORWARD_RANGE_SETTING();

        ArrayList<Car> carList = new ArrayList<Car>();

        Car aCar = new Car("aCar");
        Car bCar = new Car("bCar");

        carList.add(aCar);
        carList.add(bCar);

        int roundCnt = 5;

        Racing.racingByRound(carList, roundCnt);

        assertThat(Racing.recordingRaceList.size()).isEqualTo(carList.size() * roundCnt);
//        assertThat(Racing.recordingRaceList.get(0).confirmNowPosition()).isEqualTo(1);

    }
}