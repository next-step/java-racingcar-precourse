package imjeong.precourse.racingcar.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 일급 컬렉션을 활용한 RacingCars Model
 * @param finishCount
 * @return
 * @since 2021. 05. 03
 */
public class RacingCars {

 private List<RacingCar> racingCars;
 
 public RacingCars(List<RacingCar> racingCars) {
  this.racingCars = racingCars;
 }
 
 public List<RacingCar> getRacingCars() {
  return racingCars;
 }
 
 /**
  * 완주한 자동차 목록 가져오기
  * @param finishCount
  * @return
  * @since 2021. 05. 03
  */
 public List<RacingCar> getFinishedCars(int finishCount) {
  List<RacingCar> finishedCars = new ArrayList<RacingCar>();
  for(RacingCar racingCar : racingCars) {
   if(racingCar.getMoveCount() == finishCount) finishedCars.add(racingCar);
  }
  return finishedCars;
 }

}
