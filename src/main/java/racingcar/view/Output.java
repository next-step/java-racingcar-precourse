package racingcar.view;

import java.util.List;

public class Output {
    private static Output output;
    private final String CAR_NAME_REQUEST = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String ROUND_REQUEST = "시도할 회수는 몇회인가요?";
    private final String PROCESS = "실행 결과";
    private final String RESULT = "최종 우승자: ";
    private static final String DELIMITER = ",";

    private Output() {}

    public static Output getInstance() {
        if(output == null) {
            output = new Output();
        }
        return output;
    }

    public void printCarNameRequest() {
        System.out.println(CAR_NAME_REQUEST);
    }

    public void printRoundRequest() {
        System.out.println(ROUND_REQUEST);
    }

    public void printProcessStart() {
        System.out.println(PROCESS);
    }

    public void printProcess(List<?> objects) {
        objects.forEach(System.out::println);
        System.out.println();
    }

    public void printResult(List<String> winners) {
        String winnerNames = String.join(DELIMITER, winners);
        System.out.print(RESULT + winnerNames);
    }

}
