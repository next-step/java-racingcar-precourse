package racingcar;

import java.util.List;

public class OutputView {
    private OutputView() {
        throw new IllegalStateException("출력을 위한 유틸리티 클래스입니다.");
    }

    public static void printResult(Cars cars) {
        System.out.println("실행결과");
        printAllRacingResult(cars);
        System.out.println();
    }

    private static void printAllRacingResult(Cars cars) {
        List<Car> carList = cars.getCarList();
        for (int i = 0; i < carList.size(); i++) {
            System.out.print(carList.get(i).getName()
                    + " : " + printDashes(carList.get(i)));
            System.out.println();
        }
    }

    private static String printDashes(Car car) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < car.getPosition(); i++) {
            sb.append("-");
        }
        return sb.toString();
    }

    public static void printWinners(Cars cars) {
        List<Car> winnerList = cars.getWinnerList();
        StringBuilder sb = new StringBuilder("최종 우승자 : ");
        for (int i = 0; i < winnerList.size(); i++) {
            sb.append(winnerList.get(i).getName());
            sb.append(",");
        }
        System.out.println(sb.toString().substring(0, sb.length()-1));
    }
}
