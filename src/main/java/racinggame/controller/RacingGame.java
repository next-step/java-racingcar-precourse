package racinggame.controller;

import nextstep.utils.Randoms;
import racinggame.view.InputView;
import racinggame.view.ResultView;
import racinggame.domain.Car;
import racinggame.domain.Cars;
import racinggame.domain.Round;
import racinggame.domain.Winner;

/**
 * Name : RacingGame <br/>
 * Description : 레이싱 게임 객체
 */
public class RacingGame {
    public static final int START_INCLUSIVE = 0;
    public static final int END_INCLUSIVE = 9;
    private final InputView inputView;

    public RacingGame(InputView inputView) {
        this.inputView = inputView;
    }

    public void play() {
        Cars users = new Cars(inputView.inputUserName());
        Round round = new Round(inputView.inputRound());
        ResultView resultView = new ResultView(users);
        while (round.isRemainRound()){
            run(users);
            resultView.printResult();
            round.decreaseCount();
        }
        resultView.printWinner(new Winner(users).getWinner());
    }

    private void run(Cars users) {
        for (Car user : users.getUsers()) {
            user.move(Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE));
        }
    }
}
