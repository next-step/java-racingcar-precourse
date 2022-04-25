package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Game {

    public static final String PRINT_ASK_CAR_NAMES = "경주할 자동차 이름을 입력하세요.\n";
    public static final String PRINT_ASK_LAP_COUNT = "시도할 회수는 몇회인가요?\n";

    public static void play() {
        CarNames carNames = getInputName();
        LapCount lapTimes = getInputLapCount();
        Racing racing = setRacing(carNames, lapTimes);
        racing.start();
        RacingResult racingResult = RacingResult.generateResult(racing);
        racingResult.printResult();
    }

    private static CarNames getInputName() {
        System.out.print(PRINT_ASK_CAR_NAMES);
        String userInput = Console.readLine();
        try {
            return CarNames.getCarNamesFromInput(userInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getInputName();
        }
    }

    private static LapCount getInputLapCount() {
        System.out.print(PRINT_ASK_LAP_COUNT);
        String userInputCount = Console.readLine();
        try {
            return LapCount.createLapCount(userInputCount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getInputLapCount();
        }
    }

    private static Racing setRacing(CarNames carNames, LapCount lapTimes) {
        System.out.print("\n");
        return Racing.setRacingCondition(carNames, lapTimes);
    }
}
