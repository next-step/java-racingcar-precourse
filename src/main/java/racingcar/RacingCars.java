package racingcar;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingCars {

    Map<Car, List<Integer>> racingHistory = new HashMap<>();


    public RacingCars(String[] cars) {
        for(String name : cars){
            racingHistory.put(new Car(name), new ArrayList<>());
        }

    }

    public void carEvent() {
        for (Car car : racingHistory.keySet()){
            car.forward(new Forward().isForwardCondition());
            racingHistory.get(car).add(car.getPosition());
        }
    }

    public void startRacing(int count) {
        for(int i=0; i<count; i++){
            carEvent();
        }
    }


    Map<Car,List<Integer>> getRacingHistory() {
        return racingHistory;
    }

    List<String> getWinnerNames(Map<Car, List<Integer>> racingHistory) {
        List<String> winners = new ArrayList<>();
        int max = 0;

        for (Car car : racingHistory.keySet()) {
            max = Math.max(max, car.getPosition());
        }

        for (Car car : racingHistory.keySet()){
            if(car.getPosition() == max){
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
