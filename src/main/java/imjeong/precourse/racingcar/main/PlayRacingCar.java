package imjeong.precourse.racingcar.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import imjeong.precourse.racingcar.model.RacingCar;
import imjeong.precourse.racingcar.model.RacingCars;
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
  RacingCars racingCars = setRacingInformation();
  System.out.println("\n실행 결과");
  printRacingInformation(racingCars);
  printRacingResult(racingCars.getFinishedCars(FINISH_COUNT));
 }
 
 /**
  * 자동차 경주 결과 출력
  * @param finishedCars
  * @since 2021. 05. 03
  */
 public static void printRacingResult(List<RacingCar> finishedCars) {
  String finishedCarNames = "";
  for(int i=0; i<finishedCars.size(); i++) {
   if(i != 0) finishedCarNames += ", ";
   finishedCarNames += finishedCars.get(i).getName();
  }
  System.out.println(finishedCarNames + "가 최종 우승했습니다.");
 }
 
 /**
  * 레이싱 진행 상황 출력하기<br/>
  * 자동차 이름 : 주행 거리 출력
  * @param racingCars
  * @since 2021. 05. 03
  */
 public static void printRacingInformation(RacingCars racingCars) {
  List<RacingCar> racinCarList = racingCars.getRacingCars();
  for(RacingCar racingCar : racinCarList) {
   moveRacingCar(racingCar);
   System.out.println(racingCar.toString());
  }
  System.out.println();
  if(racingCars.getFinishedCars(FINISH_COUNT).size() == 0) printRacingInformation(racingCars);
 }
 
 /**
  * 자동차가 앞으로 전진<br/>
  * $emsp;- Random 값이 4 이상이면 한칸 전진<br/>
  * $emsp;- Random 값이 4 미만이면 정지<br/>
  * 
  * @param racingCars
  * @since 2021. 05. 02
  */
 public static void moveRacingCar(RacingCar racingCar) {
  int num = (int) (Math.random() * 9 + 1);
  if(num >= 4) racingCar.addMoveCount();
 }
 
 /**
  * 자동차 레이시을 위한 자동차 이름, 완주를 위해 이동해야 할 횟수 설정
  * @return
  * @since 2021. 05. 02
  */
 public static RacingCars setRacingInformation() {
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
 public static RacingCars setRacingCars(String[] carNames) {
  List<RacingCar> racingCars = new ArrayList<RacingCar>();
  for(String carName : carNames) {
   racingCars.add(new RacingCar(carName, 0));
  }
  return new RacingCars(racingCars);
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
