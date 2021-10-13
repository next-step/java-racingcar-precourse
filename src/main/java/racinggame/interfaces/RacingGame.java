package racinggame.interfaces;

import nextstep.utils.Console;
import racinggame.SystemMessages;
import racinggame.domain.CarList;
import racinggame.domain.RacingCount;

import java.security.InvalidParameterException;

public class RacingGame {
    private final static String SPLIT_CRITERIA = ",";
    private boolean isNamesVerified = false;
    private boolean isRacingCountVerified = false;

    public void play() {

        CarList carList = new CarList();

        while (!isNamesVerified) {
            try {
                System.out.println(SystemMessages.INPUT_RACING_CAR_NAMES);
                String names = Console.readLine();
                carList = new CarList(names.split(RacingGame.SPLIT_CRITERIA));
                isNamesVerified = true;
            } catch (InvalidParameterException e) {
                System.out.println(e.getMessage());
            }
        }

        RacingCount racingCount = new RacingCount();

        while (!isRacingCountVerified) {
            try {
                System.out.println(SystemMessages.INPUT_RACING_COUNT);
                String racingCountInput = Console.readLine();
                racingCount = new RacingCount(racingCountInput);
                isRacingCountVerified = true;
            } catch (InvalidParameterException e) {
                System.out.println(e.getMessage());
            }

        }

        System.out.println(SystemMessages.RACING_RESULT);


        for (int i = 0; i < racingCount.getCount(); i++) {
            carList.race();
        }

        carList.filterChampions();


        System.out.println("최종 우승자는 " + carList + " 입니다.");

    }

}
