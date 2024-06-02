package view;

public class OutputView {
    public static void printResult(String name, String progressLine) {
        System.out.println(name + " : " + progressLine);
    }

    public static void printWinner(String winners) {
        System.out.println("최종 우승자 : " +  winners);
    }
}
