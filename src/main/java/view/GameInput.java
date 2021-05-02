package view;

import racingcar.Name;

import java.util.*;

public class GameInput {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String NAME_SPLIT_REGEX = ",";

    public static Set<Name> inputCarNames() {
        String[] carNames = scanner.next().split(NAME_SPLIT_REGEX);
        try {
            return convertNames(carNames);
        } catch (IllegalArgumentException e) {
            GameOutput.printEnterAgain(e);
            return inputCarNames();
        }
    }

    private static Set<Name> convertNames(String[] carNames) {
        Set<Name> names = new HashSet<>();
        for (String carName : carNames)
            names.add(new Name(carName));
        return names;
    }

}
