import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RacingCarTest {

    /**
     * 발생한 난수가 4 이상일 경우 전진, 3 이하일 경우 정지하는지 테스트
     */
    @Test
    void playOneRound() {
        RacingCar car = new RacingCar("TEST");
        int res = car.playOneRound();
        assertTrue(((res>=0 && res<=3)==(car.getCount()==0)));
        assertTrue(((res>=4)==(car.getCount()==1)));
    }

    /**
     * 전진 횟수가 정상적으로 출력 되는지 테스트
     */
    @Test
    void printCurrentCount(){
        RacingCar car = new RacingCar("TEST");
        car.setCount(2);
        assertEquals(car.printCurrentCount(),"TEST : --");
    }
}