package racing;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RacingGame {
    
    public static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요. (이름은쉼표(,)기준으로구분)";
    public static final String PLAY_COUNT_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    public static final String INPUT_ONLY_NUMBER_EXCEPTION_MESSAGE = "숫자만 입력해주세요.";
    
    PlayResult result = new PlayResult();
    Scanner scanner = new Scanner(System.in);
    
    public void gameStart() {
        String carList = carNameInput();
        Cars cars = new Cars(carList);
        
        int playCount = playCountInput();
        for (int i = 0; i < playCount; i++) {
            cars.play();
            result.printCurrentStatus(cars);
        }
        
        result.printFinalResult(cars);
    }
    
    private String carNameInput() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
        return scanner.nextLine().replace(" ", "");
    }
    
    private int playCountInput() {
        System.out.println(PLAY_COUNT_INPUT_MESSAGE);
        int playCount = 0;
        
        try {
            playCount = scanner.nextInt();
        } catch (InputMismatchException ime) {
            throw new InputMismatchException(INPUT_ONLY_NUMBER_EXCEPTION_MESSAGE);
        }
        
        return playCount;
    }
    
}
