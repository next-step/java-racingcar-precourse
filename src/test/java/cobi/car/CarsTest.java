package cobi.car;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;

import cobi.number.NumberGenerator;

/**
 * @author cobiyu
 */
public class CarsTest {
  private Cars cars;
  private NumberGenerator mockNumberGenerator;
  private List<String> carNames;

  @BeforeEach
  void init(){
    carNames = Arrays.asList("car1", "car2", "car3");
    mockNumberGenerator = Mockito.mock(NumberGenerator.class);

    cars = new Cars(carNames, mockNumberGenerator);
  }

  @Test
  @DisplayName("전달된 name List로 N대의 자동차 생성 테스트")
  void createCarsTest(){
    Cars cars = new Cars(carNames, ArgumentMatchers::anyInt);

    // Cars에게 전달된 자동차 이름의 개수와 생성된 자동차의 개수는 같다.
    List<Car> carList = cars.getCars();
    assertEquals(carNames.size(), carList.size());
    assertEquals(carList.get(0).getPosition(), 0); // 이동하지 않은 car1
    assertEquals(carList.get(1).getPosition(), 0); // 이동하지 않은 car2
    assertEquals(carList.get(2).getPosition(), 0); // 이동하지 않은 car3
  }

  @Test
  @DisplayName("모든 자동차 1회 이동 테스트")
  void moveAllOneTimeTest(){
    // given
    int [] carMoveNumbers = {
      1,  // car1 이동 number  
      4,  // car2 이동 number
      8   // car3 이동 number
    };

    Mockito.when(mockNumberGenerator.getNumber())
      .thenReturn(carMoveNumbers[0])
      .thenReturn(carMoveNumbers[1])
      .thenReturn(carMoveNumbers[2]);


    // when : 한번 전체 이동
    cars.moveAll();


    // then
    List<Car> carList = cars.getCars();
    assertEquals(carList.get(0).getPosition(), 0); // car1 이동 0회
    assertEquals(carList.get(1).getPosition(), 1); // car2 이동 1회
    assertEquals(carList.get(2).getPosition(), 1); // car3 이동 1회
  }

  @Test
  @DisplayName("모든 자동차 n회 이동 테스트")
  void moveMultipleTest(){
    //given
    int [] carMoveNumbers = {
      //car1 car2  car3
      1,    4,    2,  //1st
      2,    3,    1,  //2nd
      4,    5,    9,  //3rd
      5,    8,    1   //4st
    };
    OngoingStubbing<Integer> numberGeneratorStub = Mockito.when(mockNumberGenerator.getNumber());
    for (int carMoveNumber : carMoveNumbers) {
      numberGeneratorStub = numberGeneratorStub.thenReturn(carMoveNumber);
    }

    // when
    for (int i = 0; i < carMoveNumbers.length / 3; i++) {
      cars.moveAll();
    }

    // then
    List<Car> carList = cars.getCars();
    assertEquals(carList.get(0).getPosition(), 2); // car1 이동 2회
    assertEquals(carList.get(1).getPosition(), 3); // car2 이동 3회
    assertEquals(carList.get(2).getPosition(), 1); // car3 이동 1회
  }
}
