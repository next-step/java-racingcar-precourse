package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarManagerTest {

    CarManager cm;
    @BeforeEach
    void setUp() {
        cm = new CarManager();
    }

    @Test
    void addCar() {

        //given
        String car1 = "haha";
        String car2 = "hihi";
        String nocar = "haha";

        //when
        cm.addCar(car1);

        //then
        assertThrows(IllegalArgumentException.class,()->{cm.addCar(nocar);},"중복 이름 예외 던지기");
        assertDoesNotThrow(()->cm.addCar(car2),"중복 아닐 시 통과");
    }
}