package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Cars;
import racingcar.model.Car;
import racingcar.model.Rule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GameServiceImpl implements GameService {
    private Cars cars;
    private final Rule rule;

    public GameServiceImpl(){
        cars = new Cars(getCars());
        rule = getRuleCount();
    }

    public List<Car> getCars(){
        while(true){
            try{
                List<Car> carList = new ArrayList<>();
                return inputCars(carList);
            }catch (IllegalArgumentException | IllegalStateException exception){
                System.out.println(exception.getMessage());
            }
        }
    }

    public List<Car> inputCars(List<Car> carList){
        String [] cars = Console.readLine().split(",");
        if(cars.length <= 1) throw new IllegalArgumentException("[ERROR] cars must be over 1");
        HashMap<String, Integer> duplicated = new HashMap<>();
        for (String car : cars) {
            if (duplicated.get(car) != null) throw new IllegalStateException("[ERROR] duplicated user existed!");
            duplicated.put(car, 1);
            carList.add(new Car(car));
        }
        return carList;
    }

    public Rule getRuleCount(){
        while(true){
            try {
                int counts = Integer.parseInt(Console.readLine());
                return new Rule(counts);
            }catch (IllegalArgumentException exception){
                System.out.println(exception.getMessage());
            }
        }
    }

    public void gameEnd(){
        showWinners(rule.getCount());
    }

    public boolean play(){
        boolean isEnd = false;
        List<Car> nextCars = this.cars.getCars();
        for (Car car : nextCars) {
            if(car.getMovement() == rule.getCount()){
                isEnd = true;
                continue;
            }
            car.setMovement(moveForward() + car.getMovement());
        }
        this.cars = new Cars(nextCars);
        return isEnd;
    }

    public int moveForward(){
        return Randoms.pickNumberInRange(0,9) >= 4 ? 1 : 0; //
    }

    public void showScore(){
        for(Car car : cars.getCars()){
            System.out.println(car.getName() + " : " + getScore(car.getMovement()));
        }
        System.out.println();
    }

    public String getScore(int score){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<score;i++){
            sb.append("-");
        }
        return sb.toString();
    }

    public List<Car> getWinners(int count){
        List<Car> list = new ArrayList<>();
        for(Car car : cars.getCars()){
            if(car.getMovement() == count) list.add(car);
        }
        return list;
    }

    public void showWinners(int count){
        List<Car> winners = getWinners(count);
        StringBuilder result = new StringBuilder();
        for(int i=0;i<winners.size();i++){
            result.append(winners.get(i).getName());
            if(i < cars.getCarsSize()-1){
                result.append(", ");
            }
        }
        System.out.println("최종 우승자 : " + result);
    }

}
