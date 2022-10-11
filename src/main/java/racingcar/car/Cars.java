package racingcar.car;

import racingcar.common.exception.ErrorMessage;
import racingcar.common.factory.RandomFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    private final int MOVE_BOUNDARY = 4;
    private List<Car> cars = new ArrayList<>();

    public Cars() {
    }

    public void addCars(Car car){
        validation(car);
        this.cars.add(car);
    }

    public List<Car> carList(){
        return new ArrayList<>(cars);
    }

    private void validation(Car car){
        if(cars.contains(car)){
            throw new IllegalArgumentException(ErrorMessage.CAN_NOT_ADD_SAME_CAR.getMessage());
        }
    }

    public void moveCars(RandomFactory factory){
        for(Car car : cars){
            if(factory.makeRandomNumber() >= MOVE_BOUNDARY){
                car.move();
            }
        }
    }

    public List<Integer> getPositions() {
        List<Integer> positions = new ArrayList<>();
        for(int i=0; i<cars.size(); i++){
            positions.add(cars.get(i).position());
        }
        return positions;
    }

    public List<String> getNames() {
        List<String> names = new ArrayList<>();
        for(int i=0; i<cars.size(); i++){
            names.add(cars.get(i).name());
        }
        return names;
    }

    public String winner() {
        StringBuilder result = new StringBuilder();
        Collections.sort(cars, Collections.reverseOrder());

        Car first = cars.get(0);
        List<String> winnerNames = new ArrayList<>();
        winnerNames.add(first.name());

        for(int i=1; i<cars.size(); i++){
            if(first.compareTo(cars.get(i)) == 0){
                winnerNames.add(cars.get(i).name());
            }
        }
        return String.join(",", winnerNames);
    }
}
