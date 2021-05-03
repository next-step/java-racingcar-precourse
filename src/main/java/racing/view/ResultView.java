package racing.view;

import racing.model.Car;

import java.util.List;

public class ResultView {

    private static final String PRINT_WINNERS_FORMAT = "%s가 최종 우승했습니다.";

    /**
     * 라운드 결과
     *
     * @param list
     */
    public static void printRoundResult(List<Car> list) {
        list.forEach(car -> System.out.println(String.format("%s : %s", car.getName(), car.getRecord())));
        System.out.println();
    }

    /**
     * 우승자 발표
     *
     * @param winners
     */
    public static void printWinners(String winners) {
        System.out.println(String.format(PRINT_WINNERS_FORMAT, winners));
    }

}
