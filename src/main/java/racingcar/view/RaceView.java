package racingcar.view;

import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Console;

public class RaceView {
    public static final String MESSAGE_NAMES_OF_CARS = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
    public static final String MESSAGE_ROUND_COUNT = "시도할 회수는 몇회인가요?";
    public static final String MESSAGE_ROUND_RESULT = "실행 결과";
    public static final String MESSAGE_WINNER_IS = "최종 우승자: %s";
    public static String startView(){
        System.out.println(MESSAGE_NAMES_OF_CARS);
        return Console.readLine();
    }
    public static String roundView(){
        System.out.println(MESSAGE_ROUND_COUNT);
        return Console.readLine();
    }
    public static void outputView(String message){
        System.out.println(message);
    }
    public static void roundResultView(Map<String, Integer> result){
        System.out.println(MESSAGE_ROUND_RESULT);
        for (String carName : result.keySet()){
            System.out.print(carName + " : ");
            System.out.println(moveStatus(result.get(carName)));
        }
    }
    private static String moveStatus(int move){
        String result = "";
        for (int i = 0; i < move; i++){
            result += "-";
        }
        return result;
    }
    public static void resultView(List<String> winners){
        System.out.println(String.format(MESSAGE_WINNER_IS, String.join(", ", winners)));
    }
}
