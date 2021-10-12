package racinggame;

import nextstep.utils.Console;
import racinggame.Enum.Error;
import racinggame.Enum.StartGuide;
import racinggame.car.domain.CarName;
import racinggame.car.utils.CarsUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DataInput {

    public static List<CarName> inputCarName() {
        while (true) {
            try {
                System.out.println(StartGuide.NAME_MSG.getMsg());
                return Arrays.asList(CarsUtil.makeCarStringToAry(Console.readLine())).stream()
                        .map(name -> new CarName(name))
                        .collect(Collectors.toList());
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int inputDoingRound() {
        while(true) {
            try {
                System.out.println(StartGuide.ROUND_MSG.getMsg());
                return Integer.parseInt(Console.readLine());
            }catch (NumberFormatException e) {
                System.out.println(Error.WRONG_INPUT_NUMBER.getMsg());
            }
        }
    }
}
