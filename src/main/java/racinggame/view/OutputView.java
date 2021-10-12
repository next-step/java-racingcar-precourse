package racinggame.view;

public class OutputView {

    public void printOutputRacingResultTitle() {
        System.out.println("실행 결과");
    }

    public void printOutputRacingResult(String carName, String runNumber) {

        System.out.println(carName + " : " + runNumber);
    }

    public void printOutputRacingWinnerPrefix() {
        System.out.print("최종 우승자는 ");
    }

    public void printOutputRacingWinnerSuffix() {
        System.out.println(" 입니다.");
    }

    public void printOutputErrorMessage() {
        System.out.println("[ERROR] 잘못된 입력값입니다");
    }
}
