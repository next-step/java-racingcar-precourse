package cobi.car;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * @author cobiyu
 */
class CarTest {
  private Car car;

  @BeforeEach
  void init(){
    car = new Car("car1");
  }

  @ParameterizedTest
  @DisplayName("자동차 생성 테스트")
  @ValueSource(strings = {"car1", "car2", "car3"})
  void createCarTest(String name){
    Car car = new Car(name);

    // name과 생성된 자동차의 name이 동일하다.
    assertEquals(car.getName(), name);
  }

  @ParameterizedTest
  @DisplayName("자동차 이름 길이 오류 테스트")
  @ValueSource(strings = {"car1car1", "car2car2", "car3car3"})
  void createCarNameErrorTest(String name){
    // 긴 자동차 이름에 대해 IllegalArgumentException 발생
    assertThrows(IllegalArgumentException.class, () -> new Car(name));
  }

  @Test
  @DisplayName("숫자별 차량 이동 테스트")
  void moveCarTest(){
    int[] testMoveNumbers = {5,3,9};
    for (int testMoveNumber : testMoveNumbers) {
      car.moveBy(testMoveNumber);
    }

    List<MoveHistoryType> resultHistories = car.getHistories();

    // 생성된 history의 size는 테스트한 횟수와 동일
    assertEquals(resultHistories.size(), testMoveNumbers.length);
    // 생성된 history는 go, stop, go
    assertEquals(resultHistories, Arrays.asList(MoveHistoryType.GO, MoveHistoryType.STOP, MoveHistoryType.GO));
    // 자동차는 2만큼 이동한 상태
    assertEquals(car.getPosition(), 2);
  }

}
