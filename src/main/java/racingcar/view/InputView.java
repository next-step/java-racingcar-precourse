package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;
import racingcar.model.Round;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    public static List<Car> inputUsers() {
        try {
            System.out.println("-경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)");
            String[] inputs = Console.readLine().split(",");
            List<Car> cars = new ArrayList<>();
            for (String input : inputs) {
                cars.add(new Car(input));
            }
            return cars;
        } catch (IllegalArgumentException e) {
            return inputUsers();
        }
    }

    public static Round inputRound() {
        try {
            System.out.println("-시도할 횟수");
            return new Round(Console.readLine());
        } catch (IllegalArgumentException e) {
            return inputRound();
        }
    }
}
