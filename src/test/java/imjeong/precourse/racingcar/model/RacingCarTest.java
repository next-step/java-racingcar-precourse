package imjeong.precourse.racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * RacingCar 모델 테스트
 * @author In Mook, Jeong
 * @since 2021. 05. 02
 */
public class RacingCarTest {
 
 public static List<Map<String, Object>> CAR_LIST = new ArrayList<Map<String, Object>>();
 
 @ParameterizedTest
 @CsvSource(value = {"1:false", "4:true", "9:true", "3:false"}, delimiter = ':')
 @DisplayName("Check the car can move forward")
 void moveForward(int moveNumber, boolean expected) {
  assertEquals(moveNumber>3, expected);
 }
 
 @Test
 @DisplayName("Check if the car has finished racing")
 void isFinish() {
  int finishedCount = 9;
  int[] moveCount = {1,4,9,3};
  assertFalse(moveCount[0] == finishedCount);
  assertFalse(moveCount[1] == finishedCount);
  assertTrue(moveCount[2] == finishedCount);
  assertFalse(moveCount[3] == finishedCount);
 }
}
