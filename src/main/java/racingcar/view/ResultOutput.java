package racingcar.view;

import racingcar.domain.Mileage;

public class ResultOutput {

    public static final String COLON = " : ";
    public static final String DASH = "-";
    public static final String WINNERS = "최종 우승자: ";

    public static void printRoundResult(String name, Mileage mileage) {
        System.out.println(name + COLON + toDash(mileage));
    }

    public static void printWinners(StringBuilder stringBuilder) {
        final int lastIndex = stringBuilder.length() - 1;
        System.out.println(WINNERS + stringBuilder.deleteCharAt(lastIndex));
    }

    private static String toDash(Mileage mileage) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < mileage.getMeter(); i++) {
            stringBuilder.append(DASH);
        }
        return stringBuilder.toString();
    }

}
