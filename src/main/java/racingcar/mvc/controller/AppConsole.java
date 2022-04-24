package racingcar.mvc.controller;

import camp.nextstep.edu.missionutils.Console;

public class AppConsole {

    public static String[] waitTypePlayerNames() {
        String input = Console.readLine();
        return input.split(",");
    }

    public static int waitTypeHowManyRound() {
        return Integer.parseInt(Console.readLine());
    }
}
