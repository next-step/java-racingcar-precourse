package racingcar.view;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.car.Car;

public class SystemOutputView {

    public static void getCarsName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉽표(,) 기준으로 구분");
    }

    public static void getRacingRepeatCoount() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void startRacing() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void currentCarDistance(String currentStatusToString) {
        System.out.println(currentStatusToString);
    }

    public static void blank() {
        System.out.println();
    }

    public static void finishRacing(List<Car> headCarList) {
        List<String> carNameList = new ArrayList<>();
        for (Car car : headCarList) {
            carNameList.add(car.getCarName());
        }

        System.out.printf("최종 우승자: %s%n", String.join(", ", carNameList));
    }

}
