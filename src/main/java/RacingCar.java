import model.Race;
import util.ConvertInputUtil;

import java.util.List;
import java.util.Scanner;

public class RacingCar {
    private static final String PRINT_INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String PRINT_INPUT_TRY_NUMBER = "시도할 회수는 몇회인가요?";
    private static final String PRINT_RESULT = "실행 결과";
    private static final String PRINT_WINNER = "가 최종 우승했습니다.";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println(PRINT_INPUT_CAR_NAME);
        Race race = new Race(ConvertInputUtil.getCarNameFromInput(scan.next()));

        System.out.println(PRINT_INPUT_TRY_NUMBER);
        int tryNumber = ConvertInputUtil.getTryNumberFromInput(scan.next());

        System.out.println(PRINT_RESULT);
        for (int i = 0; i < tryNumber; i++) {
            System.out.println(race.play());
        }

        System.out.println(race.getWinner() + PRINT_WINNER);
    }
}
