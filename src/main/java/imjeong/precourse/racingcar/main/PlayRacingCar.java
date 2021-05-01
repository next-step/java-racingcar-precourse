package imjeong.precourse.racingcar.main;

import java.util.Scanner;

/**
 * 자동차 경주 게임.
 * @author In Mook, Jeong
 * @since 2021. 05. 01
 */
public class PlayRacingCar {
 
 private static Scanner SCANNER = null; // 사용자 입력을 위한 Scanner 객체 초기화
 
 /**
  * Start Point.
  * @param args
  * @since 2021. 05. 01
  */
 public static void main(String[] args) {
  setScanner();
  startRacing();
  closeScanner();
 }

 /**
  * 사용자가 입력을 받을 수 있도록 Scanner 객체 생성
  * @since 2021. 05. 01
  */
 public static void setScanner() {
  SCANNER = new Scanner(System.in);
 }
 
 /**
  * 자동차 경주 게임을 종료할 때 Scanner 객체 자원 반납
  * @since 2021. 05. 01
  */
 public static void closeScanner() {
  SCANNER.close();
 }
 
 /**
  * 자동차 레이싱 게임 시작
  * @since 2021. 05. 01
  */
 public static void startRacing() {
  String[] carNames = getInputCarNames();
  int moveCount = getMoveCount();
  System.out.println("moveCount : " + moveCount);
 }
 
 /**
  * 사용자가 입력한 자동차의 이름을 배열 형태로 가져오기
  * @return
  * @since 2021. 05. 01
  */
 public static String[] getInputCarNames() {
  System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
  String[] carNames = SCANNER.next().split(",");
  if(!isCarName5Characters(carNames)) return getInputCarNames();
  return carNames;
 }
 
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
  * 사용자가 자동차를 몇 번 이동해야 완주시킬 것인지 입력
  * @return
  * @since 2021. 05. 02
  */
 public static int getMoveCount() {
  System.out.println("시도할 횟수는 몇회인가요?");
  String moveCount = SCANNER.next();
  if(!isValidNumber(moveCount)) return getMoveCount();
  return Integer.parseInt(moveCount);
 }
 
 /**
  * 입력한 값이 1~9 사이의 숫자인지 확인
  * @param number - 숫자 형태의 문자열
  * @return - 1~9 사이의 숫자면 ture, 아니면 false 반환
  * @since 2021. 05. 02
  */
 public static boolean isValidNumber(String input) {
	 return (input.matches("[0-9]*") && Integer.parseInt(input) > 0);
 }
}
