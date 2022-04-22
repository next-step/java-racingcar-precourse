package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.model.Car;

public class View {

    private View() {
    }

    public static String getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine().trim();
    }

    public static String getCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Console.readLine().trim();
    }

    public static void printCars(List<Car> cars) {
        System.out.println("실행 결과");

        for (Car car : cars) {
            printCar(car);
        }
    }

    public static void printCar(Car car) {
        StringBuilder builder = new StringBuilder();
        builder.append(car.getName()).append(" : ");
        for (int i = 0; i < car.getDistance(); i++) {
            builder.append("-");
        }
        System.out.println(builder);
    }

    public static void printWinners(List<Car> winners) {
        StringBuilder builder = new StringBuilder();
        builder.append("최종 우승자: ")
                .append(winners.get(0).getName());
        for (int i = 1; i < winners.size(); i++) {
            builder.append(",").append(winners.get(i).getName());
        }
        System.out.println(builder);
    }

    public static void printExceptionMessage(Exception e) {
        System.out.println("[ERROR] " + e.getMessage());
    }
}
