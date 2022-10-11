package racingcar.race;

import racingcar.car.Car;
import racingcar.car.Cars;
import racingcar.common.factory.RandomFactory;
import racingcar.common.factory.RandomFactoryImpl;
import racingcar.common.util.Input;
import racingcar.common.util.Output;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    private final String DELIMITER = ",";
    private final RandomFactory randomFactory = new RandomFactoryImpl();
    private Race race;

    public RacingCarGame() {
        this.race = new Race(randomFactory);
    }

    public void start() {
        Output.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        try {

            String names = Input.readLine();
            List<Car> cars = nameSplitAndMakeCarList(names);
            for (Car car : cars) {
                race.join(car);
            }

            Output.println("시도할 회수는 몇회인가요?");
            int playCnt = Input.readLineNumber();

            Output.println("실행결과");
            while (playCnt-- > 0) {
                List<Car> result = race.moveCars();
                for (Car car : result) {
                    Output.println(car);
                }
                Output.println();
            }
            Output.print("최종 우승자 : ");
            Output.println(race.winnerName());
        } catch (RuntimeException e) {
            Output.println(e.getMessage());
        }
    }

    public List<Car> nameSplitAndMakeCarList(String carsStr) {

        String[] names = carsStr.split(DELIMITER);
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }
}
