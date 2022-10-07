package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Race;
import java.util.ArrayList;
import java.util.Collections;

public class Print {
    private static final String errorMark = "[ERROR] ";
    private static final String delimiter = " : ";
    private static final String distDelimiter = "-";
    private static final String nameDelimiter = ", ";
    private static final String empty = "";
    private static final String InputRequestTryCount = "시도할 회수는 몇인가요?";
    private static final String InputRequestName = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String StartMsg = "실행 결과";
    private static final String ResultMsg = "최종 우승자";


    public static void printError(String errorMsg) {
        System.out.println(errorMark + errorMsg);
    }

    public static void printInputRequestTryCount() {
        System.out.println(InputRequestTryCount);
    }
    public static void printInputRequestName() {
        System.out.println(InputRequestName);
    }
    public static void printRun(Race race){
        for (Car car: race.getCars()) {
            String result = car.getName() + delimiter + drawDistance(car.getDistance());
            System.out.println(result);
        }
        System.out.println();
    }

    public static void printRaceStart(){
        System.out.println(StartMsg);
    }
    
    public static void printResult(ArrayList<String> winnerNames){
        System.out.println(ResultMsg + delimiter + String.join(nameDelimiter, winnerNames) );
    }

    private static String drawDistance(int distance){
        return String.join(empty, Collections.nCopies(distance, distDelimiter));
    }
}
