package racingcar.car;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    public Map<String, Integer> getMoveByName(){
        Map<String, Integer> moveByCar = new LinkedHashMap<>();
        for (Car car : cars){
            moveByCar.put(car.getName(), car.getMove());
        }
        return moveByCar;
    }
    public Map<Integer, List<String>> getNameByMove(){
        Map<Integer, List<String>> nameByMove = new HashMap();
        Map<String, Integer> moveByName = getMoveByName();

        Set<Integer> moveSet = new HashSet(moveByName.values());
        for (Integer move : moveSet){
            nameByMove.put(move, new ArrayList<String>());
        }
        for (String name : moveByName.keySet()){
            nameByMove.get(moveByName.get(name)).add(name);
        }
        
        return nameByMove;
    }

    public int getMoveMax(){
        int moveMax = 0;
        for (Car car : cars){
            moveMax = Math.max(moveMax, car.move);
        }
        return moveMax;
    }

    public List<String> getWinners(){
        int maxVal = getMoveMax();
        return getNameByMove().get(maxVal);
    }
}
