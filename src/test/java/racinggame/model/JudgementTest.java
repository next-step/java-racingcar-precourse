package racinggame.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class JudgementTest {

    private ArrayList<Car> carList;
    private int roundCnt;
    private GameHost gameHost;
    private ArrayList<Car> givenList;
    private ArrayList<Car> judgeCarList;

    @BeforeEach
    void setUp() {

        carList = new ArrayList<>();
        roundCnt = 5;

        Car aCar = new Car("aCar");
        Car bCar = new Car("bCar");
        Car cCar = new Car("cCar");

        carList.add(aCar);
        carList.add(bCar);
        carList.add(cCar);

        gameHost = new GameHost(carList, roundCnt);
        givenList = gameHost.getRecordingRaceList();

    }

    @Test
    void 심판_array_생성_테스트() {
        assertThat(givenList.size()).isEqualTo(carList.size() * roundCnt);
    }

    @Test
    void 받은_array로부터_심판_대상_리스트만_관리하기() {
        /*
        * judgeCarList 에서
        * */
        Judgement.configurateJudgeCarList(givenList, roundCnt);

        assertThat(Judgement.judgeCarList.size()).isEqualTo( givenList.size() / roundCnt );
    }



}