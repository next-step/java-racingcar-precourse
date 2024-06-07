package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import model.Car;
import model.CarRepository;
import view.CarView;
import java.util.Random;

public class CarController {
  private int trialCount = 0;
  private CarRepository model;
  private CarView view;

  public CarController(CarRepository model, CarView view){
    this.model=model;
    this.view=view;
  }
  public void AddCar(String cn, int fs){
    model.AddCar(cn,fs);
  }


  public void AddCars(String carNamesInput) {
    String[] carNames = carNamesInput.split(",");
    for (String carName : carNames) {
      if (carName.trim().length() > 5) {
        throw new IllegalArgumentException("[ERROR] length of car name is under 5 charcters.");
      }
      AddCar(carName.trim(), 0);
    }
  }

  public void Print_AllCnAndFs(){
    for(Car c : model.GetAllCar()){
      view.Print_CarNameAndForwardStep(c);
    }
    System.out.println();
  }

  public void Trial() {
    trialCount++;
    System.out.printf("<Trial %d>\n", trialCount);
    for (Car c : model.GetAllCar()) {
      GenerateRandomStep(c);
    }
    Print_AllCnAndFs();
  }
  public void GenerateRandomStep(Car c){
    Random random = new Random();
    int randNumber=random.nextInt(10);
    if (DecisionGo(randNumber)){
      c.SetForwardStep(c.GetForwardStep()+1);
    }
  }

  public boolean DecisionGo(int randNumber){
    if (randNumber>=4){
      return true;
    }
    return false;
  }

  public void printWinners() {
    List<Car> winners = new ArrayList<>();
    int maxStep = 0;
    for (Car car : model.GetAllCar()) {
      if (car.GetForwardStep() > maxStep) {
        maxStep = car.GetForwardStep();
      }
    }
    for (Car car : model.GetAllCar()) {
      if (car.GetForwardStep() == maxStep) {
        winners.add(car);
      }
    }
    view.printWinners(winners);
  }
}
