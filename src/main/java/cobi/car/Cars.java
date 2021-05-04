package cobi.car;


import java.util.ArrayList;
import java.util.List;

import cobi.number.NumberGenerator;

/**
 * @author cobiyu
 */
public class Cars {
  private List<Car> cars;
  private final NumberGenerator numberGenerator;

  /**
   * constructor
   *
   * @param carNames 자동차 이름 list
   * @param numberGenerator 숫자 생성기
   */
  public Cars(List<String> carNames, NumberGenerator numberGenerator) {
    this.numberGenerator = numberGenerator;
    setCarsByCarNames(carNames);
  }

  /**
   * 자동차 생성
   *
   * @param carNames 자동차 이름 list
   */
  private void setCarsByCarNames(List<String> carNames){
    cars = new ArrayList<>();

    for (String carName : carNames) {
      cars.add(new Car(carName));
    }
  }

  /**
   * 모든 자동차 이동
   */
  public  void moveAll(){
    for (Car car : cars) {
      int number = numberGenerator.getNumber();
      car.moveBy(number);
    }
  }

  public List<Car> getCars() {
    return cars;
  }
}
