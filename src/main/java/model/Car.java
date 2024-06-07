package model;

public class Car {
  private String carName;
  private int forwardStep;
  public Car(String carName, int forwardStep) {
    if (carName.length() > 5) {
      throw new IllegalArgumentException("[ERROR] length of car name is under 5 charcters.");
    }
    this.carName = carName;
    this.forwardStep = forwardStep;
  }

  public void SetCarName(String carName) {
    if (carName.length() > 5) {
      throw new IllegalArgumentException("[ERROR] length of car name is under 5 charcters.");
    }
    this.carName = carName;
  }
  public String GetCarName(){
    return this.carName;
  }

  public void SetForwardStep(int goStep){
    this.forwardStep=goStep;
  }

  public int GetForwardStep(){
    return this.forwardStep;
  }
}

