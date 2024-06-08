package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarTest {

    String happy = "happyCar";
    Car car;
    @BeforeEach
    void setUp() {

        car = new Car(happy);
    }

    @Test
    void setExcelCondition() {
        //given

        int changeNum = 5;

        //when

        //전진 조건이 changeNum으로 변경되었을 때
        car.setExcelCondition(changeNum);
        car.doExcel(changeNum+1);

        //then

        //position이 증가해야한다.
        assertEquals(car.getPosition(),1);

    }
    @Test
    void doExcel() {

        //given
        int noExcel = 3;
        int goExcel = 4;
        int conditionNum = 4;

        //when
        car.setExcelCondition(conditionNum);

        //then

        car.doExcel(noExcel);
        assertEquals(car.getPosition(),0);

        car.doExcel(goExcel);
        assertEquals(car.getPosition(),1);

    }
}