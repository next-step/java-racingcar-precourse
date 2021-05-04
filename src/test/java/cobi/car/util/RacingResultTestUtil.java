package cobi.car.util;

import java.util.ArrayList;
import java.util.List;

import cobi.car.Car;

/**
 * @author cobiyu
 */
public class RacingResultTestUtil {
  /**
   * Cars.getCars()에서 사용할 car 리스트
   * randomNumberArray을 기반으로 생성한다.
   *
   * @param randomNumberArray
   * 자동차 레이스에 사용될 숫자가 담긴 2차원 배열
   * {
   * -> 1st  2nd  3rd  4th  5th  6th
   *   {1,   7,   3,   3,   9,   2}, // car1
   *   {7,   8,   9,   5,   1,   9}, // car2
   *   {3,   9,   5,   1,   9,   5}  // car3
   * }
   */
  public static List<Car> getMockCarListBy(int [][] randomNumberArray){
    // when
    List<Car> carList = new ArrayList<>();

    // 2차 배열을 순회하기 위한 이중 for 문
    // depth가 2를 넘지 않고 2차원 배열을 순회할 수 있는 방안 모색 필요
    for (int carIndex = 0; carIndex < randomNumberArray.length; carIndex++) {
      carList.add(new Car("car"+carIndex));

      for (int moveIndex = 0; moveIndex < randomNumberArray[carIndex].length; moveIndex++) {
        carList.get(carIndex).moveBy(randomNumberArray[carIndex][moveIndex]);
      }

    }

    return carList;
  }
}
