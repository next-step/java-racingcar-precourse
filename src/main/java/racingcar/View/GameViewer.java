package racingcar.View;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Controller.RacingController;
import racingcar.Model.Racing.Result.ResultViewer;
import racingcar.Model.User;

public class GameViewer {
    RacingController controller = new RacingController();

    public void start() {
        try{
            ResultViewer resultViewer = controller.play(getUserValue());
            resultViewer.printMovement();
            resultViewer.printWinner();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private User getUserValue() throws IllegalArgumentException {
        User user = new User();
        System.out.println("* 경주할 자동차 이름(이름은 쉼표(,)기준으로 구분)");
        user.setCarNameArray(Console.readLine());
        System.out.println("* 시도할 횟수");
        user.setMovingAmount(Console.readLine());

        return user;
    }
}
