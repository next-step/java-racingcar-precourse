package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(String[] participants){
        this.cars = addCar(participants);
    }

    private List<Car> addCar(String[] participants){
        List<Car> cars = new ArrayList<>();
        for (String participant : participants) {
            cars.add(new Car(participant));
        }
        return cars;
    }

    public void goOrStop() {
        for(Car car : cars){
            car.location.goStop();
            System.out.println(car.getName() + " : " + car.getLocation());
        }
        System.out.println();
    }

    public void getWinner() {
        StringBuilder winner = new StringBuilder();
        int max = -1;
        for(Car car : cars){
            if(car.getLocation().length() > max){
                max = car.getLocation().length();
                winner.setLength(0);
                winner.append(car.getName());
                continue;
            }
            if(car.getLocation().length() == max){
                winner.append(", ").append(car.getName());
            }
        }
        System.out.println("최종 우승자 : " + winner);
    }
}
