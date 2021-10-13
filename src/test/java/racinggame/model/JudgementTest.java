package racinggame.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static racinggame.model.Judgement.findHighScore;

class JudgementTest {

    private ArrayList<Car> carList;
    private int roundCnt;
    private GameHost gameHost;
    private ArrayList<Car> givenList;
    private ArrayList<Car> judgeCarList;

    @BeforeEach
    void setUp() {

        carList = new ArrayList<>();
        roundCnt = 15;

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

    @Test
    void 최고_값_구하기() {


        Judgement.configurateJudgeCarList(givenList, roundCnt);

        //Judgement.findHighScore(Judgement.judgeCarList);
        int a = Judgement.findHighScore(Judgement.judgeCarList);

        System.out.println(a);

    }

    @Test
    void 최고값을_가진_네임_구하기() {
        ArrayList<Car> list = new ArrayList<>();

        Car aCar = new Car("aCar");
        aCar.moveForward();
        Car bCar = new Car("bCar");
        bCar.moveForward();
        Car cCar = new Car("cCar");
        list.add(aCar);
        list.add(bCar);
        list.add(cCar);

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).confirmNowPosition() == 1){
                System.out.println("있다.");
            }
        }

    }



}