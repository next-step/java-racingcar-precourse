import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarTest {

    @Test
    @DisplayName("입력받은 자동차가 아무것도 없을때")
    public void NoCar() {
       String car="";
       // 입력받은 자동차의 이름이 빈칸일때
        RacingCarVO race = new RacingCarVO();
        int result = race.ErrorList1(car);
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
        int result = race.ErrorList1(car);
        // 잘못된 자동차 이름이 ErrorList에 걸리는지
        assertEquals(1, result);
        // ErrorList에서 5글자 이상은 1라고 출력시킴
    }
    @Test
    @DisplayName("자동차 이름안에 빈칸이 있을때")
    public void ContainBlack() {
        List Dupl_car = new ArrayList();
        String car="ab ef";
        // 입력받은 자동차의 이름에 빈칸이 포함될때
        RacingCarVO race = new RacingCarVO();
        int result = race.ErrorList2(car , Dupl_car);
        // 잘못된 자동차 이름이 ErrorList에 걸리는지
        assertEquals(3, result);
        // ErrorList에서 빈칸포함은 3라고 출력시킴
    }
    @Test
    @DisplayName("자동차 이름이 중복될때")
    public void Duplicate() {
        List Dupl_car = new ArrayList();
        Dupl_car.add("abc");
        Dupl_car.add("abc");
        String car="abc";
        // 입력받은 자동차의 이름이 5글자를 넘어갈때
        RacingCarVO race = new RacingCarVO();
        int result = race.ErrorList2(car , Dupl_car);
        // 잘못된 자동차 이름이 ErrorList에 걸리는지
        assertEquals(4, result);
        // ErrorList에서 중복은 4라고 출력시킴
    }
    @Test
    @DisplayName("정상적인 자동차 이름 입력시")
    public void CorrectCar() {
        String car="abc";
        // 입력받은 자동차의 이름이 올바를 때
        RacingCarVO race = new RacingCarVO();
        int result = race.ErrorList1(car);
        // 에러리스트를 거쳐도 오류라고 인식되지 않음
        assertEquals(0, result);
        // ErrorList에서 정상은 1이라고 출력시킴
    }







}
