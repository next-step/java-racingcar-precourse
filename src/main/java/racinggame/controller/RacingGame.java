package racinggame.controller;

import nextstep.utils.Randoms;
import racinggame.domain.Car;
import racinggame.domain.Cars;
import racinggame.domain.Round;
import racinggame.domain.Winner;
import racinggame.view.InputView;
import racinggame.view.ResultView;

import java.util.NoSuchElementException;

/**
 * Name : RacingGame <br/>
 * Description : 레이싱 게임 객체
 */
public class RacingGame {
    public static final int START_INCLUSIVE = 0;
    public static final int END_INCLUSIVE = 9;
    private final InputView inputView;
    private Cars users;
    private Round round;
    private ResultView resultView;

    public RacingGame(InputView inputView) {
        this.inputView = inputView;
    }

    public void play() {
        inputUserName();
        if (users != null) {
            inputRound();
        }
        if (round != null) {
            printRoundResultInfoText();
            runRound();
            printWinner();
        }
    }

    private void runRound() {
        while (round.isRemainRound()) {
            run(users);
            printRoundResult();
            round.decreaseCount();
        }
    }

    private void printRoundResultInfoText() {
        resultView = new ResultView(users);
        resultView.printResultInfoText();
    }

    private void printRoundResult() {
        resultView.printResult();
    }

    private void printWinner() {
        resultView.printWinner(new Winner(users).getWinner());
    }

    private void inputRound() {
        try {
            round = new Round(inputView.inputRound());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputRound();
        }
    }

    private void inputUserName() {
        try {
            users = new Cars(inputView.inputUserName());
        } catch (NoSuchElementException ne) {
            throw ne;
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            inputUserName();
        }
    }

    private void run(Cars users) {
        for (Car user : users.getUsers()) {
            user.move(getRandomNumber());
        }
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
    }
}
