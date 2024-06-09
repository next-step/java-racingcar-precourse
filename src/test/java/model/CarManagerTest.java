package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;
import java.util.Objects;
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

    @Test
    void getRaceLog() {
        //given
        String car1 = "hah";
        String car2 = "ooo";
        String car3 = "ijij";
        Map<String,Integer> log;

        cm.addCar(car1);
        cm.addCar(car2);
        cm.addCar(car3);

        //when
        cm.race();
        log = cm.getRaceLog();

        //then
        assertNotNull(log.get(car1));
        assertNotNull(log.get(car3));

        assertTrue(log.get(car1)>=0);



    }

    @Test
    void getFastCarName() {
        //given
        String car1 = "hh";
        String car2 = "ss";
        String car3 = "dd";
        Map<String,Integer> log;

        cm.addCar(car1);
        cm.addCar(car2);
        cm.addCar(car3);
        //when

        cm.race();
        cm.race();
        cm.race();
        log = cm.getRaceLog();

        //then
        assertNotNull(cm.getFastCarName());
        assertTrue(cm.getFastCarName().stream().anyMatch(e->
                e.equals(car1) || e.equals(car2) || e.equals(car3)
            ));

    }
}