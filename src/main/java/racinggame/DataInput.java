package racinggame;

import nextstep.utils.Console;
import racinggame.Enum.Error;
import racinggame.Enum.StartGuide;
import racinggame.car.domain.CarName;
import racinggame.car.utils.CarsUtil;

import java.util.ArrayList;
import java.util.List;

public class DataInput {

    public static List<CarName> inputCarName() {
        System.out.println(StartGuide.NAME_MSG.getMsg());
        try {
            String[] inputCarNames = CarsUtil.makeCarStringToAry(Console.readLine());
            List<CarName> rtnData = new ArrayList<>();
            for(String carName : inputCarNames) {
                rtnData.add(new CarName(carName));
            }
            return rtnData;
        }catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public static int inputDoingRound() {
        try {
            System.out.println(StartGuide.ROUND_MSG.getMsg());
            return Integer.parseInt(Console.readLine());
        }catch (NumberFormatException e) {
            throw new NumberFormatException(Error.WRONG_INPUT_NUMBER.getMsg());
        }
    }
}
