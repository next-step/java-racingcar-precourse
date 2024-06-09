package model;

import static org.junit.jupiter.api.Assertions.*;

import RacingCar.Model.Car;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CarTest {
  @ParameterizedTest()
  @MethodSource("moveCase")
  @DisplayName("move 함수 검사")
  void testMove(int randomValue, int expectedPosition) {
    Car car = new Car("testCar");
    car.move(randomValue);
    assertEquals(expectedPosition, car.getPosition());
  }
  static Stream<Arguments> moveCase() {
    return Stream.of(
        Arguments.of(3, 0),
        Arguments.of(0, 0),
        Arguments.of(5, 1),
        Arguments.of(100, 1)
    );
  }

  @ParameterizedTest()
  @MethodSource("positionCase")
  @DisplayName("getPosition 함수 검사")
  void testGetPosition(int initialPosition, int randomValue, int expectedPosition) {
    Car car = new Car("testCar");
    for (int i = 0; i < initialPosition; i++) {
      car.move(4); // 4 이상이므로 무조건 위치 증가
    }
    car.move(randomValue);
    assertEquals(expectedPosition, car.getPosition());
  }

  static Stream<Arguments> positionCase() {
    return Stream.of(
        Arguments.of(0, 3, 0),
        Arguments.of(0, 4, 1),
        Arguments.of(1, 3, 1),
        Arguments.of(1, 4, 2)

    );
  }

}
