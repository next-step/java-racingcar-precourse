package model;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private List<Car> carlist;
    private int tryNum;
    public Race(String[] cars){
        addCarlist(cars);
    }

    public int getTryNum() {
        return tryNum;
    }

    public void setTryNum(int tryNum){
        this.tryNum = tryNum;
    }
    public void addCarlist(String[] carNames){
        carlist = new ArrayList<>();
        for(String carname : carNames){
            Car car = new Car(carname);
            carlist.add(car);
        }
    }
    public List<Car> getWinner(){
        int maxMove = getMaxMove();
        return carlist.stream()
                .filter(car->car.getMove() == maxMove)
                .toList();
    }
    public int getMaxMove(){
        return carlist.stream()
                .mapToInt(Car::getMove)
                .max()
                .orElse(0);
    }
    public void moveCarByRandNum(List<Car> cars){
        for(int i =0;i<carlist.size();i++){
            int randNum = (int)(Math.random()*9);
            cars.get(i).moveCar(randNum);
        }
    }
    public List<Car> getCarlist(){
        return carlist;
    }
}
