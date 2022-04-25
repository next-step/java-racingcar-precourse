package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.RacingCar;

import java.util.ArrayList;

public class ConsoleView {

    public String getNameStringFromReadLine() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String nameString = Console.readLine();
        return nameString;
    }

    public String getLapCountFromReadLine() {
        System.out.println("시도할 회수는 몇회인가요?");
        String lapCount = Console.readLine();
        return lapCount;
    }

    public void printConsoleRacingCarRaceProgress(ArrayList<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            System.out.println(racingCar.getName() + " : " + this.printRaceProgress(racingCar.getRaceProgress()));
        }
    }

    private String printRaceProgress(int raceProgress) {
        String result = "";
        for (int i = 0; i < raceProgress; i++) result += "-";
        return result;
    }

    public void printWinner(ArrayList<String> winners) {
        StringBuffer resultMessage = new StringBuffer("최종 우승자는 ");
        for (String winner : winners) {
            resultMessage.append(winner + ", ");
        }
        resultMessage.setLength(resultMessage.length() - 2);
        System.out.println(resultMessage.append(" 입니다."));
    }

    public void printConsoleRunResult() {
        System.out.println("실행 결과");
    }

}
