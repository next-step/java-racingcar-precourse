package racinggame.view;

public class OutputView {

    public void printOutputRacingResultTitle() {
        System.out.println("실행 결과");
    }

    public void printOutputRacingResult(String carName, String runNumber) {

        System.out.println(carName + " : " + runNumber);
    }

    public void printOutputLine() {
        System.out.println("");
    }

    public void printOutputRacingWinner(String winner) {
        System.out.println("최종 우승자는 " + winner + " 입니다.");
    }

    public void printOutputErrorMessage() {
        System.out.println("[ERROR] 잘못된 입력값입니다");
    }
}
