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
    private InputView inputView;

    public RacingGame(InputView inputView) {
        this.inputView = inputView;
    }

    public void play() {
        //이름을 입력
        Cars users = new Cars(inputView.inputUserName());
        //라운드를 입력
        Round round = new Round(inputView.inputRound());
        ResultView resultView = new ResultView(users);
        //게임실행
        while (round.isRemainRound()){
            run(users);
            //라운드별 결과 출력
            resultView.printResult();
            round.decreaseCount();
        }
        //위너 판별
        Winner winner = new Winner(users);
        resultView.printWinner(winner.getWinner());
    }

    private void run(Cars users) {
        for (Car user : users.getUsers()) {
            user.move(Randoms.pickNumberInRange(0, 9));
        }
    }

    public static void main(String[] args) {
        RacingGame game = new RacingGame(new InputView());
        game.play();
    }
}
