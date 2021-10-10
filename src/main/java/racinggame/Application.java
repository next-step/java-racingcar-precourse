package racinggame;

import nextstep.utils.Console;
import racinggame.domain.RacingGame;
import racinggame.utlis.RacingGameUtils;

public class Application {
    public static void main(String[] args) {
        // TODO 자동차 경주 게임 구현
        boolean isValid = true;
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCars = "";
        do {
            inputCars = Console.readLine();
            isValid = RacingGameUtils.isValidCarsInput(inputCars);
        } while (!isValid);

        System.out.println("시도할 회수는 몇회인가요?");
        String inputCount = "";
        do {
            inputCount = Console.readLine();
            isValid = RacingGameUtils.isNumeric(inputCount);
        } while (!isValid);

        RacingGame racingGame = new RacingGame(inputCars,Integer.parseInt(inputCount));

        racingGame.play();
    }
}
