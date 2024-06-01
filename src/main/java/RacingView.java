import java.util.Scanner;

public class RacingView {
    private Scanner scanner = new Scanner(System.in);
    private String raceResult = "\n실행 결과\n";

    public String readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉽표(,) 기준으로 구분");

        return scanner.nextLine();
    }

    public String readTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");

        return scanner.nextLine();
    }

    public void printError(Exception e) {
        System.out.println("[ERROR] " + e.getMessage());
    }

    public void printRaceResult() {
        System.out.println(raceResult);
    }

    public void addRaceResult(CarProgress[] carProgresses) {
        for (CarProgress carProgress : carProgresses) {
            raceResult += (carProgress.toString() + "\n");
        }
        raceResult += "\n";
    }

    public void printWinners(String[] winners) {
        String winnerMsg = "최종 우승자 : ";
        winnerMsg += String.join(", ", winners);

        System.out.println(winnerMsg);
    }
}
