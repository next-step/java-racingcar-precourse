package imjeong.precourse.racingcar.util;

/**
 * 사용자가 입력한 값이 유효한 값인지 확인하는 유틸 클래스
 * @author In Mook, Jeong
 * @since 2021. 05. 02
 */
public class InputValidationUtil {

 /**
  * 사용자가 입력한 자동차 이름이 5자 이하인지 확인
  * @param carNames - car name array
  * @return
  * @since 2021. 05. 01
  */
 public static boolean isCarName5Characters(String[] carNames) {
  for(String carName : carNames) {
   if(carName.length() > 5) return false;
  }
  return true;
 }
 
 /**
  * 입력한 값이 1 이상의 숫자인지 확인
  * @param number - 숫자 형태의 문자열
  * @return - 1 이상의 숫자면 ture, 아니면 false 반환
  * @since 2021. 05. 02
  */
 public static boolean isValidNumber(String input) {
  return (input.matches("[0-9]*") && Integer.parseInt(input) > 0);
 }
}
