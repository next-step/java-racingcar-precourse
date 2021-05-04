package cobi.car;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import cobi.car.util.RacingResultTestUtil;

/**
 * @author cobiyu
 */
class RacingResultTest {
  private Cars mockCars;

  @BeforeEach
  void init(){
    mockCars = Mockito.mock(Cars.class);
  }

  @Test
  @DisplayName("1명의 우승자 테스트")
  void oneWinnersTest() {
    // given
    int[][] randomNumberArray = { // 자동차 이동에 사용된 숫자 2차원 배열
      //1st  2nd  3rd  4th  5th  6th
      {1,   7,   3,   3,   9,   2}, // car1
      {7,   8,   9,   5,   1,   9}, // car2
      {3,   9,   5,   1,   9,   5}  // car3
    };
    // randomNumberArray에 따라 자동차가 이동하도록 mock
    List<Car> mockCarList = RacingResultTestUtil.getMockCarListBy(randomNumberArray);
    Mockito.when(mockCars.getCars()).thenReturn(mockCarList);

    // when
    RacingResult racingResult = new RacingResult(mockCars);

    // then
    // 우승자는 1명
    assertEquals(racingResult.getWinnersCar().size(), 1);
    // 1번 index의 차량이 우승자 리스트에 포함되어 있다. 
    assertTrue(racingResult.getWinnersCar().contains(mockCarList.get(1)));
  }

  @Test
  @DisplayName("n명의 우승자 테스트")
  void twoWinnersTest() {
    // given
    int[][] randomNumberArray = {   // 자동차 이동에 사용된 숫자 2차원 배열
      //1st  2nd  3rd  4th  5th  6th
      {1,   7,   3,   3,   9,   2}, // car1
      {7,   8,   9,   5,   1,   9}, // car2
      {3,   9,   5,   8,   9,   5}  // car3
    };

    // randomNumberArray에 따라 자동차가 이동하도록 mock
    List<Car> mockCarList = RacingResultTestUtil.getMockCarListBy(randomNumberArray);
    Mockito.when(mockCars.getCars()).thenReturn(mockCarList);

    // when
    RacingResult racingResult = new RacingResult(mockCars);

    // then
    // 우승자는 2명
    assertEquals(racingResult.getWinnersCar().size(), 2);
    // 1번, 2번 index의 차량이 우승자 리스트에 포함되어 있다.
    assertTrue(racingResult.getWinnersCar().contains(mockCarList.get(1)));
    assertTrue(racingResult.getWinnersCar().contains(mockCarList.get(2)));
  }
}
