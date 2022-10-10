package racingcar.utils;

import racingcar.domain.Winner;

import java.util.List;

public class ViewUtils {
    private static final int INITIAL_VALUE = 0;
    private static final int CORRECT_SIZE = 1;

    private ViewUtils() {

    }

    public static String drawLine(int number) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = INITIAL_VALUE; i < number; i++) {
            stringBuilder.append("-");
        }
        return stringBuilder.toString();
    }

    public static String printWinners(List<Winner> winnerList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = INITIAL_VALUE; i < winnerList.size(); i++) {
            appendNames(winnerList, stringBuilder, i);
        }
        return stringBuilder.toString();
    }

    private static void appendNames(List<Winner> winnerList, StringBuilder stringBuilder, int index) {
        if (index < winnerList.size() - CORRECT_SIZE) {
            stringBuilder.append(winnerList.get(index).name()).append(", ");
            return;
        }
        stringBuilder.append(winnerList.get(index).name());
    }
}
