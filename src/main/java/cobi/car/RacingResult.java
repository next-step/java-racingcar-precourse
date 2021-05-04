package cobi.car;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cobiyu
 */
public class RacingResult {
  private Cars cars;
  private List<Car> winnersCar;

  /**
   * constructor
   *
   * @param cars N대의 자동차 정보가 담긴 객체
   */
  public RacingResult(Cars cars) {
    this.cars = cars;
    this.winnersCar = new ArrayList<>();
    setWinnersCar();
  }

  /**
   * N대의 자동차 중 우승 자동차 검사
   */
  private void setWinnersCar(){
    List<Car> allCars = this.cars.getCars();

    int maxPosition = getMaxPosition(allCars);

    for (Car car : allCars) {
      addWinnerCar(car, maxPosition);
    }
  }

  /**
   * 우승 자동차 추가
   * @param car 자동차 정보
   * @param maxPosition N대의 자동차 중 이동거리가 가장 큰 position
   */
  private void addWinnerCar(Car car, int maxPosition){
    if(car.getPosition() == maxPosition){
      winnersCar.add(car);
    }
  }

  /**
   * N대의 자동차 중 최대 이동거리 추출
   *
   * @param allCars N대의 자동차 리스트
   * @return 최대 이동 거리
   */
  private int getMaxPosition(List<Car> allCars){
    int maxPosition = 0;

    for (Car car : allCars) {
      maxPosition = Math.max(maxPosition, car.getPosition());
    }

    return maxPosition;
  }

  /**
   * 우승자 이름 list 추출
   *
   * @return 우승자 이름 list
   */
  public List<String> getWinnersNames(){
    List <String> winnersName = new ArrayList<>();
    for (Car car : winnersCar) {
      winnersName.add(car.getName());
    }

    return winnersName;
  }

  public List<Car> getWinnersCar() {
    return winnersCar;
  }
}
