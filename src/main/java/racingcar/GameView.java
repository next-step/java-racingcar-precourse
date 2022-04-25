package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class GameView {
    private final ConsoleUtil consoleUtil;

    public GameView() {
        consoleUtil = new NextstepConsoleUtil();
    }

    public GameView(ConsoleUtil util) {
        consoleUtil = util;
    }

    public void printCarNamesInputRequestMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printCarNamesErrorMessage() {
        System.out.println("[ERROR] 자동차 이름을 잘못 입력하였습니다.");
    }

    public void printLapCountInputRequestMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printLapCountErrorMessage() {
        System.out.println("[ERROR] 시도 회수를 잘못 입력하였습니다.");
    }

    public void printBlankLine() {
        System.out.print("\n");
    }

    public void printLapResultBanner() {
        System.out.println("실행 결과");
    }

    public void printCurrentResult(RacingCar car) {
        String message = String.format("%s : %s", car.getCarName(), car.getDistance().toDashMarkup());
        System.out.println(message);
    }

    public void printWinnerBanner() {
        System.out.print("최종 우승자: ");
    }

    public void printWinnerNames(CommaSeparatedCarNames winner_names) {
        System.out.println(winner_names);
    }

    public void printCloseMessage() {
        System.out.println("게임 종료");
    }

    public CommaSeparatedCarNames readCarNames() {
        String input_car_names = consoleUtil.readLine();
        CommaSeparatedCarNames car_names;

        try {
            car_names = new CommaSeparatedCarNames(input_car_names);
        } catch (IllegalArgumentException error) {
            printCarNamesErrorMessage();
            return readCarNames();
        }

        return car_names;
    }

    public Laps readLapCount() {
        int lap_count = Integer.parseInt(consoleUtil.readLine());
        Laps laps = new Laps();

        try {
            laps.setNumericLap(lap_count);
        } catch (IllegalArgumentException error) {
            printLapCountErrorMessage();
            return readLapCount();
        }

        return laps;
    }

    public interface ConsoleUtil {
        String readLine();
    }

    public static class NextstepConsoleUtil implements ConsoleUtil {

        @Override
        public String readLine() {
            return Console.readLine();
        }
    }
}
