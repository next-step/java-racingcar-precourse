package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.item.Car;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by victorsung.
 * Date: 2022/04/25
 * Time: 9:37 PM
 */
public class Race {

    public static final String INPUT_COUNT_MSG = "시도할 회수는 몇회인가요?";
    public void start() {

        List<Car> cars = new ArrayList<>();
        Game game = new Game();

        System.out.println(INPUT_COUNT_MSG);
        String count = Console.readLine();
        System.out.println(count);

        for (String s : game.getCarName()) {
            Car car = new Car(s, Integer.parseInt(count));

            System.out.println(car.getName()+":"+car.getResult());
            cars.add(car);
        }

        List<String> winner = new ArrayList<>();

        int winnerSize = 0;

        for (Car car : cars) {
            int carGoCountSize = car.CountGoStatus();
//            System.out.println(carGoCountSize);
            if (winnerSize < carGoCountSize) {
                winnerSize = carGoCountSize;
            }
        }

        for (Car car : cars) {
            if (winnerSize == car.CountGoStatus()) {
                winner.add(car.getName());
            }
        }

        System.out.println("최종 우승자: "+ String.join(",",  winner));

    }
}
