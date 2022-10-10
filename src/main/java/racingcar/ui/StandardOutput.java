package racingcar.ui;

import java.util.List;
import java.util.StringJoiner;

public class StandardOutput implements Output {

    private static final StringJoiner stringJoiner = new StringJoiner(", ");

    @Override
    public void printResultNotice() {
        System.out.println("실행 결과");
    }

    @Override
    public void printMovingResults(String carsMovingResults) {
        System.out.println(carsMovingResults);
    }

    @Override
    public void printWinners(List<String> names) {
        stringJoiner.setEmptyValue("");
        for (String name : names) {
            stringJoiner.add(name);
        }
        System.out.println("최종 우승자 : " + stringJoiner);
    }

    @Override
    public void printError(String error) {
        System.out.println(error);
    }
}
