package src;

import java.util.Random;

public class RaceGame {

    final static int MIN_RANDOM_NUMBER = 0;
    final static int MAX_RANDOM_NUMBER = 9;

    private static Car[] racingCars;

    public RaceGame(String[] userName) {
        racingCars = new Car[userName.length];
        for (int i = 0; i < userName.length; i++) {
            racingCars[i] = new Car(userName[i]);
        }
    }

    public void doGame(int numberOfTry) {
        for (int i = 0; i < numberOfTry; i++) {
            doSingleGame();
        }
        selectWinner();
    }

    public void doSingleGame() {
        AnswerPrinter answerPrinter = new AnswerPrinter();

        for (int i = 0; i < racingCars.length; i++) {
            if (randomNum() >= 4) {
                racingCars[i].increasePosition();
            }
        }
        answerPrinter.printEffect(racingCars);
    }

    private int randomNum() {
        Random random = new Random();
        return random.nextInt(MAX_RANDOM_NUMBER-MIN_RANDOM_NUMBER) + MIN_RANDOM_NUMBER;
    }

    public void selectWinner() {
        AnswerPrinter answerPrinter = new AnswerPrinter();
        int maxPosition = 0;
        StringBuilder winner = new StringBuilder();
        for (int i = 0; i < racingCars.length; i++) {
            maxPosition = racingCars[i].compareMaxAndPosition(maxPosition);
        }
        for (int i = 0; i < racingCars.length; i++) {
            winner = racingCars[i].addWinner(winner, maxPosition);
        }
        answerPrinter.printWinner(winner);
    }
}