package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.regex.PatternSyntaxException;
import racingcar.utils.ValidationUtil;

public class Cars {
    private List<Car> cars = new ArrayList<>();

    public Cars() {
    }

    public Cars(String cars) {
        this.cars = tokenizeCars(cars);
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    private List<Car> tokenizeCars(String cars){
        try{
            return convertCars(cars);
        }catch (PatternSyntaxException exception){
            throw new IllegalArgumentException("car names must be tokenized by comma");
        }
    }

    private List<Car> convertCars(String cars) {
        String[] tokenizedCars = cars.split(",");
        List<Car> carList = new ArrayList<>();
        for(String carName : tokenizedCars){
            ValidationUtil.isCarNameValid(carName);
            Car car = new Car(carName);
            carList.add(car);
        }
        return carList;
    }

    public List<Car> moveForward(){
        this.cars.forEach(car -> car.createSteps(Randoms.pickNumberInRange(0,9)));
        return this.cars;
    }

    public List<Car> getWinners(){
        List<Car> winners = new ArrayList<>();
        PriorityQueue<Car> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.addAll(this.cars);
        getWinners(winners, pq);
        return winners;
    }

    private void getWinners(List<Car> winners, PriorityQueue<Car> pq) {
        Car top = pq.poll();
        winners.add(top);
        while(!pq.isEmpty()){
            Car car = pq.poll();
            if(car.getSteps().intValue() == winners.get(0).getSteps().intValue()){
                winners.add(car);
            }
        }
    }
}
