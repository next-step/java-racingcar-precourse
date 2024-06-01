import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    @Test
    @DisplayName("난수에 따라 전진인지 정지인지 판별")
    public void GoOrStop() {
        boolean go =false;
        int temp=1000;
        // 일단 go에 false를 넣고 정지라고 가정한다.
        RacingCarVO race = new RacingCarVO();
        for (int i=0; i<temp; i++){
            if(race.GoOrStop()==1){
                go = true;
            }
        }
        // 1000번의 표본을 가지고 4이상의 난수가 나온적이 있으면 GoOrStop에서 1이 반환됨
        assertTrue(go, "4이상이면 1반환");
        // 1이 반환된적이 있으면 go를 true로 변환
    }
    @Test
    @DisplayName("자동차 이름을 ,로 잘 구별했는가?")
    public void Seperate() {
        String input = "woni,pobi,jun";
        // input 이라고 사용자에게 입력받고 그걸  , 구분해서 cars에다가 저장할계획이다.
        RacingCarVO race = new RacingCarVO();
        String[] cars=race.GetCar(input);
        // cars 에다가 ,로 구분해서 자동차 이름을 집어 넣음
        String [] array2 ={"woni" , "pobi" , "jun"};
        assertArrayEquals(cars, array2);
        // GetCar에서 저장된 배열이랑 , array2랑 같은지 비교
    }
    @Test
    @DisplayName("Race에 저장된 value(차가 움직인 거리)를 기준으로 가장 큰값은 얼마인가?")
    public void WinnerDistance() {
        String [] cars = {"a","b","c","d"};
        Map<String , Integer> car = new HashMap<>();
        car.put("a" , 5);
        car.put("b" , 3);
        car.put("c" , 2);
        car.put("d" , 4);
        // race와 cars에다가 값 저장
        RacingCarVO race = new RacingCarVO();
        int winner = race.GetWinner(cars , car);
        // 이동거리중 최대값을 구해서 winner에 저장
        assertEquals(5, winner );
        // 실제 출력 값과 예상 출력 값 비교
    }










}
