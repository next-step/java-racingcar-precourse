package racinggame;

public class CarController {

    public void createCar(String carName){
        String[] cars = carName.split(",");
        for (String car : cars) {
            Car raceCar = new Car();
            raceCar.setCarName(car);
        }
    }



}
