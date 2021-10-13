package racinggame;

import nextstep.utils.Console;
import racinggame.domain.game.RacingGame;

public class Application {
    public static void main(String[] args) {
        // TODO 자동차 경주 게임 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = "";
        do {
            try {
                carNames = Console.readLine();
            } catch (Exception e) {
                System.out.println("[ERROR] 자동차 이름은 5자 이하만 가능합니다.");
            }
        } while (!RacingGame.isAvailableCarNames(carNames));

        System.out.println("시도할 횟수는 몇회인가요?");
        int limitCount = Integer.parseInt(Console.readLine());

        RacingGame racingGame = new RacingGame(carNames, limitCount);
        racingGame.gameStart();

    }
}
