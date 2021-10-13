package racinggame;

import java.util.Map;

import static nextstep.utils.Console.readLine;

public class RacingCarView {
    static final String inputCarNamesMessage = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    static final String inputRaceCountMessage = "시도할 회수는 몇회인가요?";
    static final String prefixWinnerMessage = "최종 우승자는 ";
    static final String postfixWinnerMessage = " 입니다.";
    RacingCarController racingCarController = new RacingCarController();

    public void play() {
        String carNames = inputCarNames();
        racingCarController.initRacingCar(carNames);
        racingCarController.setRaceCount(Integer.parseInt(inputRaceCount()));
        printResult();
        for (int i = 0; i < racingCarController.getRaceCount(); i++) {
            printRaceResult(racingCarController.race());
        }
        printWinner(racingCarController.getWinnerCarNames());
    }

    private String inputCarNames() {
        System.out.println(inputCarNamesMessage);
        return readLine();
    }

    private String inputRaceCount() {
        System.out.println(inputRaceCountMessage);
        return readLine();
    }

    private void printResult() {
        System.out.println();
        System.out.println("실행결과");
    }

    private void printRaceResult(Map<String, Integer> racingResult){
        racingResult.forEach((key, value)->{
            System.out.print(key + " : ");
            for (int i = 0; i < value; i++) {
                System.out.print("-");
            }
            System.out.println();
        });
        System.out.println();
    }

    private void printWinner(String winnerCarNames){
        System.out.print(prefixWinnerMessage);
        System.out.print(winnerCarNames);
        System.out.println(postfixWinnerMessage);
    }
}
