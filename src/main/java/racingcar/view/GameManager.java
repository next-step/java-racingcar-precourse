package racingcar.view;

import racingcar.model.Car;
import racingcar.model.CarGroup;

import java.util.ArrayList;

public class GameManager {

    public static final String HYPHEN = "-";

    public static void reportGameResult(CarGroup carGroup) {
        for(Car car : carGroup.getCars()){
            System.out.println(car.getName() + " : " + positionToHyphen(car.getPosition()));
        }
        System.out.println();
    }

    private static String positionToHyphen(int position) {
        String hyphens = "";
        for (int i = 0; i < position; i++) {
            hyphens += HYPHEN;
        }
        return hyphens;
    }

    public static void inputCarNames() {
        System.out.println(Message.getInputCarNames());
    }

    public static void reportWinners(ArrayList<Car> winnerGroups) {
        System.out.print("최종 우승자: ");
        for(int carNum = 0; carNum < winnerGroups.size(); carNum++){
            if(carNum > 0)
                System.out.print(", ");
            System.out.print(winnerGroups.get(carNum).getName());
        }
        System.out.println();
    }

    public static void inputGameCount() {
        System.out.println(Message.getInputGameCount());
    }
}
