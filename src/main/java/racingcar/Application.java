package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        boolean isInputGameNamesValidation = true;
        boolean isInputGameCount = true;
        String inputGameNames = "";
        String inputGameCount = "";

        while(isInputGameNamesValidation){
            System.out.println("경주할 자동차 이름을 입력 하세요. (이름은 쉼표(,) 기준으로 구분)");
            inputGameNames = readLine();
            isInputGameNamesValidation = !ValidationUtil.checkRacingGameNameInput(inputGameNames);
        }

        while(isInputGameCount){
            System.out.println("시도할 회수는 몇회 인가요");
            inputGameCount = readLine();
            isInputGameCount = !ValidationUtil.checkGameCount(inputGameCount);
        }

        RacingGame racingGame = new RacingGame(inputGameNames,inputGameCount);
        racingGame.runRace();
        racingGame.getRacingResult();

    }
}
