package domain;

import java.util.ArrayList;
import java.util.List;

public class Track {
    private final List<Car> cars;

    public Track() {
        this.cars = new ArrayList<>();
    }

    public void addCar(String carName){
        cars.add(new Car(carName));
    }
    public void step(List<Integer> seeds){
        validateSeedSize(seeds);
        for(int i = 0; i < seeds.size(); i++){
            cars.get(i).move(seeds.get(i));
        }
    }

    public List<Car> getWinners(){
        int maxPosition = 0;

        List<Car> winner = new ArrayList<>();
        for(Car car : cars){
            if(car.getPosition() == maxPosition){
                winner.add(car);
                continue;
            }
            if(car.getPosition() > maxPosition){
                winner.clear();
                maxPosition = car.getPosition();
                winner.add(car);
            }
        }
        return winner;
    }
    private void validateSeedSize(List<Integer> seeds){
        if(seeds.size() != cars.size()){
            throw new IllegalArgumentException("[ERROR]: Seed 개수가 차량 개수와 일치하지 않습니다");
        }
    }
}
