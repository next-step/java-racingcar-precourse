package cobi.number;

import java.util.Random;

/**
 * @author cobiyu
 */
public class RandomNumberGenerator implements NumberGenerator {
  private static final int MAX = 10;

  /**
   * 랜덤 숫자 반환
   *
   * @return 랜덤 1자리 숫자
   */
  @Override
  public int getNumber() {
    return new Random().nextInt(MAX);
  }
}
