package racing.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.vo.Car;
import racing.vo.Racing;
import racing.vo.Reception;
import racing.vo.Rule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingGameTest {

    private List<Car> cars;
    private Reception reception;
    private Rule rule;
    @BeforeEach
    void setUp() {
        List<String> list = Arrays.asList("lucas","son","kane","mane");
        cars = new ArrayList();
        for(String str:list){
            Car car = new Car(str);
            cars.add(car);
        }
        reception = new Reception(cars);
        rule= new Rule(5);
    }

    @Test
    @DisplayName("자동차경주 라운드별 이동 출력")
    public void movingCar(){
        Racing racing = new Racing(rule,reception);
        RacingGame racingGame = new RacingGame(racing);
        racingGame.startRound();
    }
}
