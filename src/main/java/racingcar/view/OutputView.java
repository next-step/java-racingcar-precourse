package racingcar.view;

import java.util.ArrayList;
import java.util.List;

import racingcar.dto.CarPrintDto;
import racingcar.dto.WinnerDto;

public class OutputView {
    public static final String RESULT_MESSAGE = "실행 결과";
    public static final String FINAL_WINNER_MESSAGE = "최종 우승자 : ";
    public static final String ERROR_MESSAGE = "[ERROR]";

    private OutputView() {
    }

    public static void printError(String message) {
        System.out.println(ERROR_MESSAGE + message);
    }

    public static void printCurrentStatus(CarPrintDto car) {
        String message = String.format("%s : %s", car.getName(), printDistance(car.getDistance()));
        System.out.println(message);
    }

    public static void printWinner(List<WinnerDto> winnerList) {
        List<String> nameList = new ArrayList<>();
        for (WinnerDto dto : winnerList) {
            nameList.add(dto.getName());
        }
        System.out.println(FINAL_WINNER_MESSAGE + String.join(", ", nameList));
    }

    public static void printLn() {
        System.out.println();
    }

    public static void printResult() {
        printLn();
        System.out.println(RESULT_MESSAGE);
    }

    private static String printDistance(int distance) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < distance; i++) {
            sb.append("-");
        }
        return sb.toString();
    }
}
