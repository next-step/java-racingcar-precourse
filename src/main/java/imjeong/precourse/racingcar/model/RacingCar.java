package imjeong.precourse.racingcar.model;

/**
 * Racing Car 모델
 * @author In Mook, Jeong
 * @since 2021. 05. 02
 */
public class RacingCar {

 private String name;
 private int moveCount;
 
 public RacingCar(String name, int moveCount) {
  this.name = name;
  this.moveCount = moveCount;
 }

 public String getName() {
  return name;
 }

 public void setName(String name) {
  this.name = name;
 }

 public int getMoveCount() {
  return moveCount;
 }
 
 public void setMoveCount(int moveCount) {
  this.moveCount = moveCount;
 }

 @Override
 public String toString() {
  String move ="";
  for(int i=0; i<this.moveCount; i++) {
   move += "-";
  }
  return name + " : " + move;
 }
 
}
