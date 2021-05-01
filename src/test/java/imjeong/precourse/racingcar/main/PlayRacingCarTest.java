package imjeong.precourse.racingcar.main;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * PlayRacingCarTest.<br/>
 * &emsp;- 사용자 입력값 검증 및 테스트.
 * 
 * @author In Mook, Jeong
 * @since 2021. 05. 01
 */
public class PlayRacingCarTest {

 @ParameterizedTest
 @CsvSource(value = {"houdy:true", "banzz:true", "kia:false", "sonata:false"}, delimiter = ':')
 @DisplayName("Test if the car name entered by the user is 5 characters or less")
 void racingCarNameTest(String input, boolean expected) {
  assertEquals(input.length()==5, expected);
 }
 
 @ParameterizedTest
 @CsvSource(value = {"0:false", "9:true", "10:true", "1020:true", "290003:true", "a:false"}, delimiter = ':')
 @DisplayName("Test whether the number of vehicle movements entered by the user is a number")
 void inputMoveCountTest(String input, boolean expected) {
  assertEquals((input.matches("[0-9]*") && Integer.parseInt(input) > 0), expected);
 }
}
