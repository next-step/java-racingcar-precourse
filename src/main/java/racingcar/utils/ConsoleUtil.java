package racingcar.utils;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.Constant;
import racingcar.constant.ConsoleMessage;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Repeat;

public class ConsoleUtil {

    public static Repeat readRepeatTime() {
        return new Repeat(Console.readLine());
    }

    public static Cars readCarsName() {
        return new Cars(Console.readLine());
    }

    public static void print(ConsoleMessage message) {
        System.out.printf("%s", message.getValue());
    }

    public static void print(String message) {
        System.out.printf("%s", message);
    }

    public static void printStep(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.printf("%s : %s\n", car.getName(), StringUtil.repeat(Constant.POSITION_MARK, car.getPosition()));
        }
        System.out.println();
    }

    public static void printError(Exception exception) {
        System.out.println(exception.getMessage());
    }
}
