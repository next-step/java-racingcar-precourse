package imjeong.precourse.racingcar.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import imjeong.precourse.racingcar.model.RacingCar;
import imjeong.precourse.racingcar.util.InputValidationUtil;

/**
 * 자동차 경주 게임.
 * @author In Mook, Jeong
 * @since 2021. 05. 01
 */
public class PlayRacingCar {
 
 private static Scanner SCANNER = null; // 사용자 입력을 위한 Scanner 객체 초기화
 private static int FINISH_COUNT = 0;
 
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
  List<RacingCar> racingCars = setRacingInformation();
 }
 
 /**
  * 자동차 레이시을 위한 자동차 이름, 완주를 위해 이동해야 할 횟수 설정
  * @return
  * @since 2021. 05. 02
  */
 public static List<RacingCar> setRacingInformation() {
  String[] carNames = getInputCarNames();
  FINISH_COUNT = getMoveCount();
  return setRacingCars(carNames);
 }
 
 /**
  * 사용자가 입력한 자동차 이름을 통해 자동차 객체가 담긴 리스트 생성
  * @param carNames
  * @return
  * @since 2021. 05. 02
  */
 public static List<RacingCar> setRacingCars(String[] carNames) {
  List<RacingCar> racingCars = new ArrayList<RacingCar>();
  for(String carName : carNames) {
   racingCars.add(new RacingCar(carName, 0));
  }
  return racingCars;
 }
 
 /**
  * 사용자가 입력한 자동차의 이름을 배열 형태로 가져오기
  * @return
  * @since 2021. 05. 01
  */
 public static String[] getInputCarNames() {
  System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
  String[] carNames = SCANNER.next().split(",");
  if(!InputValidationUtil.isCarName5Characters(carNames)) return getInputCarNames();
  return carNames;
 }
 
 /**
  * 사용자가 자동차를 몇 번 이동해야 완주시킬 것인지 입력
  * @return
  * @since 2021. 05. 02
  */
 public static int getMoveCount() {
  System.out.println("시도할 횟수는 몇회인가요?");
  String moveCount = SCANNER.next();
  if(!InputValidationUtil.isValidNumber(moveCount)) return getMoveCount();
  return Integer.parseInt(moveCount);
 }
}
