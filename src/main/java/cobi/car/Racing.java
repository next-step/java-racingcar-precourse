package cobi.car;

import java.util.List;

import cobi.number.NumberGenerator;
import cobi.view.ConsoleView;

/**
 * @author cobiyu
 */
public class Racing {
  private final ConsoleView view;
  private final NumberGenerator numberGenerator;

  /**
   * constructor
   *
   * @param view 입출력 담당 view
   * @param numberGenerator 숫자 생성기
   */
  public Racing(ConsoleView view, NumberGenerator numberGenerator) {
    this.view = view;
    this.numberGenerator = numberGenerator;
  }

  /**
   * racing 시작
   */
  public void start(){
    List<String> carNames = view.inputCarName();
    int moveCount = view.inputCount();

    Cars cars = generateCarsBy(carNames);

    moveAll(cars, moveCount);
    printWinners(cars);
  }

  /**
   * 전달된 자동차 이름 리스트에 맞는 Cars 생성
   * 
   * @param carNames 자동차 이름 리스트
   * @return 모든 자동차 관리 객체
   */
  public Cars generateCarsBy(List<String> carNames){
    return new Cars(carNames, numberGenerator);
  }

  /**
   * 입력된 회수 N번에 따라 모든 자동차 N번 이동
   * 
   * @param cars 모든 자동차 관리 객체
   * @param moveCount 이동할 회수
   */
  public void moveAll(Cars cars, int moveCount){
    for (int i = 0; i < moveCount; i++) {
      cars.moveAll();
      view.printRacingProcess(cars);
    }
  }

  /**
   * 우승자 출력
   * 
   * @param cars 모든 자동차 관리 객체
   */
  public void printWinners(Cars cars){
    view.printWinners(cars.getRacingResult().getWinnersNames());
  }
}
