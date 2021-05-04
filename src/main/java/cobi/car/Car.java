package cobi.car;

import java.util.List;

/**
 * @author cobiyu
 */
public class Car {
  private String name;
  private List<MoveHistoryType> histories;

  /**
   * 이동 여부 판단에 사용되는 number
   */
  private static final int MOVE_COMPARE_NUMBER = 3;
  /**
   * 이름의 최대 길이
   */
  private static final int MAX_NAME_LENGTH = 5;

  /**
   * constructor
   *
   * @param name 자동차 이름
   */
  public Car(String name) {
    
  }

  /**
   * 자동차 이동
   *
   * @param number 이동에 사용될 숫자
   */
  public void moveBy(int number) {
    
  }

  /**
   * 현재 위치 반환
   *
   * @return 현재 위치
   */
  public int getPosition(){
    return 0;
  }

  public String getName() {
    return name;
  }

  public List<MoveHistoryType> getHistories() {
    return histories;
  }
}
