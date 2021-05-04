package cobi.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import cobi.car.Car;
import cobi.car.Cars;

/**
 * @author cobiyu
 */
public class ConsoleView {
  private final Scanner scanner = new Scanner(System.in);
  private final static String POSITION_STRING = "-";

  /**
   * 이름 입력
   * @return 이름 list
   */
  public List<String> inputCarName(){
    System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분) : ");

    String carNameString = scanner.nextLine();
    String[] split = carNameString.split(",");

    return Arrays.asList(split);
  }

  /**
   * 회수 입력
   *
   * @return 시도 회수
   */
  public int inputCount(){
    System.out.println("시도할 회수는 몇회인가요? : ");

    return scanner.nextInt();
  }

  /**
   * 레이싱 주행 과정 출력
   *
   * @param cars N대의 차량 정보가 담긴 객체
   */
  public void printRacingProcess(Cars cars){
    System.out.println("실행결과");

    List<Car> realCars = cars.getCars();
    for (Car car : realCars) {
      System.out.print(car.getName() + " : ");
      System.out.println(getPositionStringByCount(car.getPosition()));
    }
    System.out.println(); // 개행
  }

  /**
   * 우승자 출력
   *
   * @param winnersName 우승자 이름 list
   */
  public void printWinners(List<String> winnersName){
    String joinName = String.join(",", winnersName);

    System.out.println(joinName + "가 최종 우승했습니다.");
  }

  /**
   * 현재 위치를 표현할 문자열 생성
   *
   * @param position 현재 위치
   * @return 위치를 나타내는 문자열
   */
  private String getPositionStringByCount(int position){
    StringBuilder repeatDash = new StringBuilder();
    for (int i = 0; i < position; i++) {
      repeatDash.append(POSITION_STRING);
    }

    return repeatDash.toString();
  }
}
