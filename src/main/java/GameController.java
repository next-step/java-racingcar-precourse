import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GameController {

    private Scanner scanner;

    public GameController() {
        this.scanner = new Scanner(System.in);
    }

    public String[] inputCarNames(){
        String[] carNames;
        while(true){
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String names = scanner.nextLine();
            carNames = names.split(",");

            for (int i = 0; i < carNames.length; i++) { carNames[i] = carNames[i].trim(); }
            try {
                checkNameLength(carNames);// if wrong: throws IllegalArgumentException
                return carNames; // correct
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 자동차의 이름은 5자 이하만 가능합니다. 다시 입력하세요");
            }
        }
    }

    public void checkNameLength(String[] carNames) {
        for (String carName : carNames) {
            if(carName.length() > 5){
                throw new IllegalArgumentException();
            }
        }
    }

    public int inputTryCount() {
        int tryCount = 0;
        while (true) {
            try {
                System.out.println("시도할 횟수는 몇회인가요?");
                tryCount = scanner.nextInt();
                checkTryCountValue(tryCount);
                return tryCount;
            } catch (InputMismatchException e) {
                System.out.println("잘못된 값 타입입니다. 다시 입력하세요.");
                scanner.nextLine();  // make input buffer empty
            } catch (IllegalArgumentException e) {
                System.out.println("잘못된 값입니다. 값은 0보다 커야합니다. 다시 입력하세요.");
            }
        }
    }

    public void checkTryCountValue(int tryCount) {
        if (tryCount <= 0) {
            throw new IllegalArgumentException();
        }
    }

}
