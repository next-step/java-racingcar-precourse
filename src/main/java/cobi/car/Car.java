package cobi.car;


import java.util.ArrayList;
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
    if(name.length() > MAX_NAME_LENGTH){
      throw new IllegalArgumentException("name max length is " + MAX_NAME_LENGTH);
    }
    this.name = name;
    this.histories = new ArrayList<>();
  }

  /**
   * 자동차 이동
   *
   * @param number 이동에 사용될 숫자
   */
  public void moveBy(int number) {
    if(number <= MOVE_COMPARE_NUMBER){
      histories.add(MoveHistoryType.STOP);
      return;
    }

    histories.add(MoveHistoryType.GO);
  }

  /**
   * 현재 위치 반환
   *
   * @return 현재 위치
   */
  public int getPosition(){
    int position = 0;

    for (MoveHistoryType history : histories) {
      position += history.getDistance();
    }

    return position;
  }

  public List<MoveHistoryType> getHistories() {
    return histories;
  }

  public String getName() {
    return name;
  }
}
