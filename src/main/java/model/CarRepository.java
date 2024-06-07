package model;

import java.util.ArrayList;
import java.util.List;

public class CarRepository{
  private List<Car> cr = new ArrayList<>();
  public void AddCar(String cn, int fs){
    Car car = new Car(cn,fs);
    cr.add(car);
  }


  public List<Car> GetAllCar(){
    return cr;
  }

  public Car GetCar(String cn){
    for (Car c : cr){
      if(cn.equals(c.GetCarName())){
        return c;
      }
    }
    return null;
  }
}