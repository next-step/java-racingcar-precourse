package imjeong.precourse.racingcar.model;

/**
 * 사용자가 입력한 이동 횟수를 담는 모델(Wrapper)
 * @author In Mook, Jeong
 * @since 2021. 05. 03
 */
public class RacingCount {

 private int moveCount;
 
 public RacingCount(int moveCount) {
  if(moveCount <= 0) throw new IllegalArgumentException("0 이상의 숫자를 입력하세요.");
  this.moveCount = moveCount;
 }

 public int getMoveCount() {
  return moveCount;
 }

 public void setMoveCount(int moveCount) {
  this.moveCount = moveCount;
 }
}
