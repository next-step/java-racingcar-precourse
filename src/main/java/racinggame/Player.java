package racinggame;

import nextstep.utils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player {
    public List<String> setCarNames() {
        List<String> carNames = new ArrayList<>();
        boolean validCarNames = false;
        while (!validCarNames) {
            System.out.println(Message.REQUEST_CAR_NAMES.getMessage());
            String inputCarNames = Console.readLine();
            carNames = Arrays.asList(inputCarNames.replace(" ", "").split(","));
            validCarNames = validCarNames(carNames);
        }
        return carNames;
    }

    private boolean validCarNames(List<String> carNames) {
        for (String carName : carNames) {
            if (!Boundary.NAME.isWithinRange(carName.length())) {
                System.out.println(Message.NAME_RANGE.getMessage());
                return false;
            }
        }
        return true;
    }
}
