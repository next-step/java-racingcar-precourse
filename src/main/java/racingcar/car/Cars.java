package racingcar.car;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;

public class Cars {
    List<Car> cars;
    public Cars(List<Car> cars){
        this.cars = cars;
    }
    public void inputScores(){
        for (Car car : cars){
            car.inputScore(Randoms.pickNumberInRange(0, 9));
        }
    }

    public Map<String, Integer> getCarMoves(){
        Map<String, Integer> moveByCar = new HashMap<String, Integer>();
        for (Car car : cars){
            moveByCar.put(car.getName(), car.getMove());
        }
        return moveByCar;
    }
}
