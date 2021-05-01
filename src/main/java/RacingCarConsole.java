import java.util.List;
import java.util.Scanner;

public class RacingCarConsole {

    private static final String WELCOME_MSG = "레이싱 카 게임에 오신 걸 환영합니다!!";
    private static final String REQUEST_CAR_NAME_MSG = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(WELCOME_MSG);
        System.out.println(REQUEST_CAR_NAME_MSG);
        String userInput = scanner.nextLine();

        UserInputParser userInputParser = new UserInputParser();
        List<CarName> carNames = userInputParser.parse(userInput);

        System.out.println(carNames);
    }
}
