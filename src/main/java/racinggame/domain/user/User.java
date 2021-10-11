package racinggame.domain.user;

import nextstep.utils.Console;
import racinggame.domain.constants.Messages;

public class User {

    public String readInput(Messages text) {
        System.out.println(text.getMessage());
        return Console.readLine();
    }
}
