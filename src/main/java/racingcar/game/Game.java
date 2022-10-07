package racingcar.game;

import camp.nextstep.edu.missionutils.Console;
import racingcar.cars.Cars;
import racingcar.message.Message;
import racingcar.rounds.Round;
import racingcar.rounds.Rounds;

public class Game {

    public static void start() throws IllegalArgumentException {

        Cars cars = initCars();
        int roundCnt = inputRacingRounds();

        loopRounds(cars, roundCnt);
        findWinner();
    }

    private static Cars initCars() throws IllegalArgumentException {
        System.out.println(Message.INPUT.getMessage());
        String carNames = Console.readLine();
        return Cars.generateRacingCarsFromInputString(carNames);
    }

    private static int inputRacingRounds() {
        System.out.println(Message.INPUT_GAME_COUNT.getMessage());
        return Integer.parseInt(Console.readLine());
    }

    private static void loopRounds(Cars cars, int roundCnt) {
        System.out.println(Message.RESULT.getMessage());
        for (int currentRoundCnt = 0; currentRoundCnt < roundCnt; currentRoundCnt++) {
            Rounds.playRacingCars(cars, currentRoundCnt);
        }
    }

    private static void findWinner() {
        Round lastRound = Rounds.getLastRound();
        Cars resultCars = lastRound.getCars();
        System.out.print(Message.COMPLETE_FIRST_SENTENCE.getMessage());
        System.out.println(resultCars.filterWinner());
    }

}
