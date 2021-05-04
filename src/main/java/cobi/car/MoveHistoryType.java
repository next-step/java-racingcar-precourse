package cobi.car;

/**
 * @author cobiyu
 */
public enum MoveHistoryType {
  GO(1),
  STOP(0);

  /**
   * type별 거리
   */
  private final int distance;

  MoveHistoryType(int distance) {
    this.distance = distance;
  }

  public int getDistance() {
    return distance;
  }
}
