package racingcar.Controller;

import racingcar.Model.Racing.Racing;
import racingcar.Model.User;
import racingcar.Model.Racing.Result.ResultViewer;

public class RacingController {
    public ResultViewer play(User user) {
        return new Racing(user).gameStart();
    }
}
