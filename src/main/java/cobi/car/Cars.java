package cobi.car;

import java.util.List;

import cobi.number.NumberGenerator;

public class Cars {
  private List<Car> cars;
  private final NumberGenerator numberGenerator;
  
  public Cars(List<String> carNames, NumberGenerator numberGenerator) {
    this.numberGenerator = numberGenerator;
  }

  public List<Car> getCars() {
    return null;
  }

  public void moveAll() {
    
  }
}
