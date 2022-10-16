package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Name;

import java.util.StringTokenizer;

public class GameFactory {
    public Cars makeCars(String names) {
        Cars cars = new Cars();
        StringTokenizer st = new StringTokenizer(names,",");
        validateNotNull(st.countTokens());

        while(st.countTokens() > 0 ){
            try {
                cars.addCar(new Car(new Name(st.nextToken().trim())));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return cars;
    }

    public GamePlayer startGame(String number) {
        validateNumber(number);
        return new GamePlayer(Integer.parseInt(number));
    }
    private void validateNotNull(int count){
        if(count==0) throw new IllegalArgumentException("[ERROR] 이름은 공백일 수 없습니다.");
    }

    private void validateNumber(String number){
        try {
            Integer.parseInt(number);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력가능합니다.");
        }
    }


}
