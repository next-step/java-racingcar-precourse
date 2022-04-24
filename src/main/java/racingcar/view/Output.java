package racingcar.view;

public class Output {
    public static final String MESSAGE_OUTPUT_WINNER = "최종 우승자: ";
    public static void resultMessage(String message){
        outputMessage(MESSAGE_OUTPUT_WINNER + message);
    }
    public static void outputMessage(String message){
        System.out.println(message);
    }
}
