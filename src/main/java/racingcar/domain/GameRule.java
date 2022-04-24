package racingcar.domain;

import java.util.List;

public class GameRule {
    private final RacingCars racingCars;
    GameRule(RacingCars racingCars){
        this.racingCars = racingCars;
    }
    public String logicOfRule(List<Car> carList, Integer counter){
        List<String> winnerList;
        for(int i=0; i<counter; i++){
            carMoves(carList);
        }
        winnerList = this.racingCars.winnerList();

        return makeMessage(winnerList);
    }
    public void carMoves(List<Car> carList){
        for(Car car:carList) {
            car.move();
        }
    }
    public String makeMessage(List<String> winnerList){
        StringBuilder result = new StringBuilder();
        int index = 0;
        for(String each:winnerList) {
            result.append(each);
            if(index < winnerList.size()-1) {
                result.append(",");
            }
            index ++;
        }
        return result.toString();
    }
}
