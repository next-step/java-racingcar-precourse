package view;

import dto.CarResponse;
import dto.RaceResult;
import model.Winners;

public class OutputView {

    public static void printResult(RaceResult result) {
        for (CarResponse carResponse : result.getResponses()) {
            String carName = carResponse.getCarName();
            String displayHyphen = getDisplayHyphenByPosition(carResponse.getPosition());
            System.out.println(carName + " : " + displayHyphen);
        }
        System.out.println();
    }

    private static String getDisplayHyphenByPosition(int position) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position; i++) {
            sb.append('-');
        }
        return sb.toString();
    }

    public static void printWinners(Winners winners) {
        String winnersJoin = winners.getWinnerNames();
        System.out.println(winnersJoin + " 가 최종 우승했습니다.");
    }

    public static void printResultIntro() {
        System.out.println("실행 결과");
    }
}
