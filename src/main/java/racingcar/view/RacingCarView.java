package racingcar.view;

import java.util.List;
import racingcar.domain.RacingCar;

public class RacingCarView {

    public static final String RACING_CAR_NAME_PHRASE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String PLAY_COUNT_PHRASE = "시도할 회수는 몇회인가요?";
    public static final String RESULT_PHRASE = "실행 결과";
    public static final String FINAL_WINNER_PHRASE = "최종 우승자 : ";
    public static final String NAME_ERROR_PHRASE = "[ERROR] 자동차 이름은 5자 이내여야 한다.";
    public static final String NUMBER_ERROR_PHRASE = "[ERROR] 시도 횟수는 숫자여야 한다.";

    public static void printWinner(String winner) {
        System.out.println(FINAL_WINNER_PHRASE + winner);
    }

    public static void printPlayResult() {
        System.out.println(RESULT_PHRASE);
    }

    public static void printPosition(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            System.out.println(racingCar.getName() + " : " + racingCar.getPositionString());
        }

        System.out.println();
    }

    public static void printRacingCarNamePhrase() {
        System.out.println(RACING_CAR_NAME_PHRASE);
    }

    public static void printPlayCountPhrase() {
        System.out.println(PLAY_COUNT_PHRASE);
    }

    public static void printNameError() {
        System.out.println(NAME_ERROR_PHRASE);
    }

    public static void printNumberError() {
        System.out.println(NUMBER_ERROR_PHRASE);
    }
}
