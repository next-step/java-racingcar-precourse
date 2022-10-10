package racingcar;

import camp.nextstep.edu.missionutils.Console;

/**
 * @author SeongRok.Oh
 * @since 2022/10/09
 */
public class RaceStarter {

    private RaceStarter() {
    }

    public static void start() {
        Race race;

        while (true) {
            System.out.println(PrintMessage.INPUT_RACING_CAR_NAME);
            String names = Console.readLine();
            try {
                race = Race.from(names);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            System.out.println(PrintMessage.INPUT_RACING_CAR_TRY_COUNT);
            String tryCount = Console.readLine();
            try {
                race.start(Integer.parseInt(tryCount));
                break;
            } catch (NumberFormatException e) {
                System.out.println(PrintMessage.TRY_COUNT_NUMBER_FORMAT_ERROR);
            }
        }
    }
}
