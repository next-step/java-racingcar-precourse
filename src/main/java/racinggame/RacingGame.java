package racinggame;

import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private List<Car> cars = new ArrayList<Car>();
    private int cnt;

    public RacingGame(String cars){
        String[] arr = cars.split(",");
        for(String item : arr){
            Car car = new Car(item);
            this.cars.add(car);
        }
    }

    public List<Car> getCars(){
        return cars;
    }

    public void setTryCnt(int cnt){
        this.cnt = cnt;
    }

    public int getTryCnt(){
        return cnt;
    }

    public Car moveCar(int index, int number){
        Car car = cars.get(index);
        car.play(number);
        cars.set(index, car);
        return car;
    }

    public int getMaxDistance(){
        int distance = 0;
        for(int i=0;i<cars.size();i++){
            distance = Math.max(distance, cars.get(i).getDistance());
        }
        return distance;
    }


    public boolean isWinner(int index) {
        return getMaxDistance()==cars.get(index).getDistance();
    }

}
