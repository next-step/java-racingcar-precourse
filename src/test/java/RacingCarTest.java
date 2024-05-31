import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarTest {

    @Test
    @DisplayName("입력받은 자동차가 아무것도 없을때")
    public void NoCar() {
       String car="";
       // 입력받은 자동차의 이름이 빈칸일때
        RacingCarVO race = new RacingCarVO();
        int result = race.ErrorList(car);
        // 빈칸으로 입력된 자동차 이름이 ErrorList에 걸리는지
        assertEquals(2, result);
        // ErrorList에서 빈칸은 2라고 출력시킴
    }
    @Test
    @DisplayName("자동차 이름이 5글자를 넘어갈때")
    public void OverFive() {
        String car="abcdef";
        // 입력받은 자동차의 이름이 5글자를 넘어갈때
        RacingCarVO race = new RacingCarVO();
        int result = race.ErrorList(car);
        // 잘못된 자동차 이름이 ErrorList에 걸리는지
        assertEquals(1, result);
        // ErrorList에서 5글자 이상은 1라고 출력시킴
    }





}
